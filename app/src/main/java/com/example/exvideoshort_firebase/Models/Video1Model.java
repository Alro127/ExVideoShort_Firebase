package com.example.exvideoshort_firebase.Models;

import java.io.Serializable;

public class Video1Model implements Serializable {
    private String title;
    private String desc;
    private String url;

    public Video1Model() {} // Bắt buộc có constructor rỗng

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
