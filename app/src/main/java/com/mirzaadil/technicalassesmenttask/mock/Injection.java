package com.mirzaadil.technicalassesmenttask.mock;

import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepository;
import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepositoryImpl;
import com.mirzaadil.technicalassesmenttask.app.utils.services.ServicesInterface;

public class Injection {
    private static ServicesInterface nyTimesRestService;


    public static NYTimesRepository provideNYNews() {
        return new NYTimesRepositoryImpl(provideNyTimesRestService());
    }

    static ServicesInterface provideNyTimesRestService() {
        if (nyTimesRestService == null) {
            nyTimesRestService = new MockNewsRestServiceImpl();
        }
        return nyTimesRestService;
    }
}
