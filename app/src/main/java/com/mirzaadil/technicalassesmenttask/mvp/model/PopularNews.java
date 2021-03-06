
package com.mirzaadil.technicalassesmenttask.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a model class for popular News API.
 */

public class PopularNews implements Serializable {

    @SerializedName("url")
    private String url;

    @SerializedName("adx_keywords")
    private String adxKeywords;

    @SerializedName("column")
    private Object column;

    @SerializedName("section")
    private String section;

    @SerializedName("byline")
    private String byline;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String abstractData;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("source")
    private String source;

    @SerializedName("id")
    private String id;

    @SerializedName("asset_id")
    private String assetId;

    @SerializedName("views")
    private Integer views;

    @SerializedName("media")
    private List<PopularNewsMedia> media = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return abstractData;
    }

    public void setAbstract(String _abstract) {
        this.abstractData = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }


    public List<PopularNewsMedia> getMedia() {
        return media;
    }

    public void setMedia(List<PopularNewsMedia> media) {
        this.media = media;
    }

    public PopularNews(String url, String adxKeywords, Object column, String section, String byline, String type, String title, String abstractData, String publishedDate, String source, String id, String assetId, Integer views, List<PopularNewsMedia> media) {
        this.url = url;
        this.adxKeywords = adxKeywords;
        this.column = column;
        this.section = section;
        this.byline = byline;
        this.type = type;
        this.title = title;
        this.abstractData = abstractData;
        this.publishedDate = publishedDate;
        this.source = source;
        this.id = id;
        this.assetId = assetId;
        this.views = views;
        this.media = media;
    }
}
