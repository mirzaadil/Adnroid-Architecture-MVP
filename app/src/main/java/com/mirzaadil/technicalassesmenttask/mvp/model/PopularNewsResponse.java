
package com.mirzaadil.technicalassesmenttask.mvp.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a model class for popular News API.
 */

@SuppressLint("ParcelCreator")
public class PopularNewsResponse implements Parcelable {

    @SerializedName("status")
    private String status;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("num_results")
    private Integer numResults;

    public PopularNewsResponse(List<PopularNews> popularArticles) {
        this.popularArticles = popularArticles;
    }

    @SerializedName("results")
    private List<PopularNews> popularArticles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<PopularNews> getpopularArticles() {
        return popularArticles;
    }

    public void setpopularArticles(List<PopularNews> results) {
        this.popularArticles = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public PopularNewsResponse(String status, String copyright, Integer numResults, List<PopularNews> popularArticles) {
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.popularArticles = popularArticles;
    }
}
