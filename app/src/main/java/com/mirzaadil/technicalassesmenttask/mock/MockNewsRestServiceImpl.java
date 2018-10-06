package com.mirzaadil.technicalassesmenttask.mock;

import com.mirzaadil.technicalassesmenttask.app.utils.services.ServicesInterface;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNews;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class MockNewsRestServiceImpl implements ServicesInterface {
    private final List<PopularNews> newsList = new ArrayList<>();
    private PopularNews dummyNews, dummyUser2;

    public MockNewsRestServiceImpl() {
        dummyNews = new PopularNews(
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
//        dummyUser2 = new PopularNews("riggaroo2", "Rebecca's Alter Ego",
//                "https://s-media-cache-ak0.pinimg.com/564x/e7/cf/f3/e7cff3be614f68782386bfbeecb304b1.jpg", "A unicorn");
        newsList.add(dummyNews);
 //       newsList.add(dummyUser2);
    }

    private static Observable dummyNYNewsResult = null;

    public static void setDummyNyNewsCallResult(Observable result) {
        dummyNYNewsResult = result;
    }


    @Override
    public Observable<PopularNewsResponse> getNYNewsArticles() {
        if (dummyNYNewsResult != null) {
            return dummyNYNewsResult;
        }
        return Observable.just(new PopularNewsResponse(newsList));
    }
}
