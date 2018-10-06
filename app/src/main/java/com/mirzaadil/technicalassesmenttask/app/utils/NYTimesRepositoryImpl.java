package com.mirzaadil.technicalassesmenttask.app.utils;

import com.mirzaadil.technicalassesmenttask.app.utils.services.ServicesInterface;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;

import rx.Observable;


public class NYTimesRepositoryImpl implements NYTimesRepository {
    private ServicesInterface nyTimesRestService ;


    public NYTimesRepositoryImpl(ServicesInterface nyTimesRestService) {
        this.nyTimesRestService = nyTimesRestService;
    }

    @Override
    public Observable<PopularNewsResponse> getPopularNews() {
        return  nyTimesRestService.getNYNewsArticles();
    }
}
