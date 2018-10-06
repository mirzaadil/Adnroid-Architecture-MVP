package com.mirzaadil.technicalassesmenttask.mvp.presenter;

import com.mirzaadil.technicalassesmenttask.app.utils.NYTimesRepository;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;
import com.mirzaadil.technicalassesmenttask.mvp.contract.NYNewsContract;

import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains NYNewsPresenter .
 * In this call call API.</p>
 */

public class NYNewsPresenter extends BasePresenter<NYNewsContract.View> implements NYNewsContract.Presenter {
    private final Scheduler mainScheduler, ioScheduler;
    private NYTimesRepository nyTimesRepository;

    public NYNewsPresenter(NYTimesRepository nyTimesRepository, Scheduler ioSchedulars, Scheduler mainSchedular) {
        this.mainScheduler = mainSchedular;
        this.ioScheduler = ioSchedulars;
        this.nyTimesRepository = nyTimesRepository;
    }


    // Defining the observable for News API Call.

    @Override
    public void loadData() {
        checkViewAttached();
        getView().showLoading();
        addSubscription(nyTimesRepository.getPopularNews().subscribeOn(ioScheduler).observeOn(mainScheduler)
                .subscribe(new Subscriber<PopularNewsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(PopularNewsResponse popularNewsResponse) {
                        getView().hideLoading();
                        getView().showNewsResults(popularNewsResponse);

                    }
                }));

    }
}
