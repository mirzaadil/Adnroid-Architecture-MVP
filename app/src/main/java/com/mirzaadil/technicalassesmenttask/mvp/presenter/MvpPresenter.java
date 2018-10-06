package com.mirzaadil.technicalassesmenttask.mvp.presenter;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the MVP Generic Presenter.
 *.</p>
 */
public interface MvpPresenter <V extends MvpView>{

    void attachView(V mvpView);
    void detachView();
}
