package com.mirzaadil.technicalassesmenttask.app.utils.services;

import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Services Interface of the API.
 * All of the attributes in this class shall be static. So, that they can be used from anywhere
 * without even declaring the object of this class.</p>
 */

public interface ServicesInterface {
    @GET("all-sections/7.json?api-key=d300c6f06fbb4615a538f392a5936c32")
    Observable<PopularNewsResponse> getNYNewsArticles();
}
