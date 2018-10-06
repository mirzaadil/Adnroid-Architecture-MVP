package com.mirzaadil.technicalassesmenttask.mvp.contract;

import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;
import com.mirzaadil.technicalassesmenttask.mvp.presenter.MvpPresenter;
import com.mirzaadil.technicalassesmenttask.mvp.presenter.MvpView;

/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Contract Interface.
 * Define functions.</p>
 */
public interface NYNewsContract {


    interface View extends MvpView {

        void showNewsResults(PopularNewsResponse popularNews);

        void showError(String message);

        void showLoading();

        void hideLoading();
    }

    interface Presenter extends MvpPresenter<View> {
        void loadData();
    }
}
