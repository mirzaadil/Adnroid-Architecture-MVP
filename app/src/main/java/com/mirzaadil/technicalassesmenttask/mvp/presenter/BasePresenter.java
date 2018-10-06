package com.mirzaadil.technicalassesmenttask.mvp.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Base Presenter.
 * Generic Base Presenter.</p>
 */

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {
    private T view;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void detachView() {
        compositeSubscription.clear();
        view = null;
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    protected void addSubscription(Subscription subscription) {
        this.compositeSubscription.add(subscription);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
        }
    }
}
