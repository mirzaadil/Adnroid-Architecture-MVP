package com.mirzaadil.data;

import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepository;
import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepositoryImpl;
import com.mirzaadil.technicalassesmenttask.app.utils.services.ServicesInterface;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNews;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;


public class NYTIMESRepositoryImpl {
    @Mock
    ServicesInterface nyTimesRestService;

    private NYTimesRepository nyTimesRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        nyTimesRepository = new NYTimesRepositoryImpl(nyTimesRestService);
    }

    @Test
    public void searchUsers_200OkResponse_InvokesCorrectApiCalls() {
        //Given
        when(nyTimesRestService.getNYNewsArticles()).thenReturn(Observable.just(getPopularNewsList()));


        //When
        TestSubscriber <PopularNewsResponse> subscriber = new TestSubscriber<>();
        nyTimesRestService.getNYNewsArticles().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        List<PopularNewsResponse> onNextEvents = subscriber.getOnNextEvents();
        PopularNewsResponse popularNewsResponse = onNextEvents.get(0);
        Assert.assertEquals("OK", popularNewsResponse.getStatus());
        Assert.assertEquals("Copyright (c) 2018 The New York Times Company. All Rights Reserved.", popularNewsResponse.getCopyright());
        verify(nyTimesRestService).getNYNewsArticles();

    }


    @Test
    public void ensureNYTIMESOtherHttpErrorsTerminatedWithError() {
        //Given
        when(nyTimesRestService.getNYNewsArticles()).thenReturn(get403ForbiddenError());
        //When
        TestSubscriber<PopularNewsResponse> subscriber = new TestSubscriber<>();
        nyTimesRepository.getPopularNews().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertError(HttpException.class);
        verify(nyTimesRestService).getNYNewsArticles();
    }


    private Observable getIOExceptionError() {
        return Observable.error(new IOException());
    }

    private Observable<PopularNewsResponse> get403ForbiddenError() {
        return Observable.error(new HttpException(
                Response.error(403, ResponseBody.create(MediaType.parse("application/json"), "Forbidden"))));

    }
    private PopularNewsResponse getPopularNewsList() {
        List<PopularNews> popularNews = new ArrayList<PopularNews>();
        popularNews.add(news1FullDetails());
        //  PopularNewsResponse popularNewsResponse  = new PopularNewsResponse("OK","Copyright (c) 2018 The New York Times Company. All Rights Reserved.",1704,popularNews);

        return new PopularNewsResponse("OK", "Copyright (c) 2018 The New York Times Company. All Rights Reserved.", 1704, popularNews);
    }

    private PopularNews news1FullDetails() {

        return new PopularNews(
                "https://www.nytimes.com/interactive/2018/10/02/us/politics/donald-trump-tax-schemes-fred-trump.html",
                "\"Trump, Donald J;Tax Shelters;Tax Evasion;Trump, Fred C;Frauds and Swindling;Inheritance and Estate Taxes;Appraisals and Valuation (Property);Wills and Estates;United States Politics and Government",
                "",
                "U.S",
                "By DAVID BARSTOW, SUSANNE CRAIG and RUSS BUETTNER",
                "Interactive",
                "Trump Engaged in Suspect Tax Schemes as He Reaped Riches From His Father",
                "",
                "2018-10-02",
                "The New York Times",
                "100000006140728",
                "100000006140728",
                1,
                null

        );
//        List<PopularNews> popularNewsList   = new ArrayList<PopularNews>();
//        popularNewsList.add(popularNews);
//        PopularNewsResponse popularNewsResponse  = new PopularNewsResponse("OK","Copyright (c) 2018 The New York Times Company. All Rights Reserved.",1704,popularNewsList);
//        return popularNewsResponse;
    }
}
