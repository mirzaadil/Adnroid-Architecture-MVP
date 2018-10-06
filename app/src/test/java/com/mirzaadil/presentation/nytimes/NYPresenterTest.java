package com.mirzaadil.presentation.nytimes;

import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepository;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNews;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;
import com.mirzaadil.technicalassesmenttask.mvp.presenter.BasePresenter;
import com.mirzaadil.technicalassesmenttask.mvp.contract.NYNewsContract;
import com.mirzaadil.technicalassesmenttask.mvp.presenter.NYNewsPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

public class NYPresenterTest {
    @Mock
    NYTimesRepository userRepository;
    @Mock
    NYNewsContract.View view;

    NYNewsPresenter userSearchPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userSearchPresenter = new NYNewsPresenter(userRepository, Schedulers.immediate(), Schedulers.immediate());
        userSearchPresenter.attachView(view);
    }


    @Test
    public void ensureNYTimesApiReturnsResults() {
        PopularNewsResponse popularNews = getPopularNewsList();
        when(userRepository.getPopularNews()).thenReturn(Observable.<PopularNewsResponse>just(popularNews));
        userSearchPresenter.loadData();

        verify(view).showLoading();
        verify(view).hideLoading();
        verify(view, never()).showError(anyString());
    }

    @Test
    public void ensureNYTimesApiShowErrorMessage() {
        String errorMsg = "No internet";
        when(userRepository.getPopularNews()).thenReturn(Observable.error(new IOException(errorMsg)));
        userSearchPresenter.loadData();
        verify(view).showLoading();
        verify(view).hideLoading();
        verify(view, never()).showNewsResults(any());
        verify(view).showError(errorMsg);
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException.class)
    public void search_NotAttached_ThrowsMvpException() {
        userSearchPresenter.detachView();
        userSearchPresenter.loadData();
        verify(view, never()).showLoading();
        verify(view, never()).showNewsResults(any());

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
