package com.mirzaadil.technicalassesmenttask.app.utils;

import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;

import rx.Observable;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Update News Interface .
 * </p>
 */
public interface NYTimesRepository {
    Observable<PopularNewsResponse> getPopularNews();
}
