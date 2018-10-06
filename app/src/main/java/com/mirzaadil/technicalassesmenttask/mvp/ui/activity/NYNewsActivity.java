package com.mirzaadil.technicalassesmenttask.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mirzaadil.technicalassesmenttask.R;
import com.mirzaadil.technicalassesmenttask.app.utils.Injection;
import com.mirzaadil.technicalassesmenttask.mvp.contract.NYNewsContract;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNewsResponse;
import com.mirzaadil.technicalassesmenttask.mvp.presenter.NYNewsPresenter;
import com.mirzaadil.technicalassesmenttask.mvp.ui.adapter.NYNewsRecyclerViewAdapter;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Mirza Adil on 5/10/2018.
 * <p>
 * This class contains the Main Activity.
 * </p>
 **/
public class NYNewsActivity extends AppCompatActivity implements NYNewsContract.View {

    private NYNewsContract.Presenter presenter;
    private NYNewsRecyclerViewAdapter newsRecyclerViewAdapter;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private RecyclerView recyclerViewUsers;
    private TextView textViewErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nynews);

        // Initializing this activity component .
        initView();

    }


    /**
     * In this method we are configuring mainRecycler according to our needs.
     */

    @Override
    public void showNewsResults(PopularNewsResponse popularNewsList) {
        recyclerViewUsers.setVisibility(View.VISIBLE);
        textViewErrorMessage.setVisibility(View.GONE);
        newsRecyclerViewAdapter.setItems(popularNewsList.getpopularArticles());
    }

    /**
     * In this method we are configuring mainRecycler according Show Error.
     */

    @Override
    public void showError(String message) {
        textViewErrorMessage.setVisibility(View.VISIBLE);
        recyclerViewUsers.setVisibility(View.GONE);
        textViewErrorMessage.setText(message);
    }


    /**
     * In this method we are configuring mainRecycler according to Show Loading.
     */

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewUsers.setVisibility(View.GONE);
        textViewErrorMessage.setVisibility(View.GONE);
    }


    /**
     * In this method we are configuring mainRecycler according Hide Loading.
     */

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerViewUsers.setVisibility(View.VISIBLE);
        textViewErrorMessage.setVisibility(View.GONE);
    }

    /**
     * In this method destroy Presenter Data.
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    /**
     * In this method Initialize component .
     */

    private void initView() {
        presenter = new NYNewsPresenter(Injection.provideUserRepo(), Schedulers.io(), AndroidSchedulers.mainThread());
        presenter.attachView(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textViewErrorMessage = (TextView) findViewById(R.id.text_view_error_msg);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recycler_view_users);
        newsRecyclerViewAdapter = new NYNewsRecyclerViewAdapter(this, null);
        recyclerViewUsers.setAdapter(newsRecyclerViewAdapter);
        presenter.loadData();
    }

}
