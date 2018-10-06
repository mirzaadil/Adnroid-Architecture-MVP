package com.mirzaadil.technicalassesmenttask.app.utils;

import com.mirzaadil.technicalassesmenttask.app.utils.services.ServicesInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Services Interface Injection .
 * All of the attributes in this class shall be static. So, that they can be used from anywhere
 * without even declaring the object of this class.</p>
 */

public class Injection {

    private static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/";
    private static OkHttpClient okHttpClient;
    private static ServicesInterface nyTimesRestService;
    private static Retrofit retrofitInstance;


    public static NYTimesRepository provideUserRepo() {
        return new NYTimesRepositoryImpl(provideNYTimesRestService());
    }

    static ServicesInterface provideNYTimesRestService() {
        if (nyTimesRestService == null) {
            nyTimesRestService = getRetrofitInstance().create(ServicesInterface.class);
        }
        return nyTimesRestService;
    }

    static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }

        return okHttpClient;
    }

    static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofit = new Retrofit.Builder().client(Injection.getOkHttpClient()).baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            retrofitInstance = retrofit.build();

        }
        return retrofitInstance;
    }
}
