package com.diary.model;

import java.sql.Date;

public class DiaryVO {
    private int no;
    private String weather;
    private String title;
    private String content;
    private Date wdate;

    public DiaryVO() {}

    public DiaryVO(int no, String weather, String title, String content, Date wdate) {
        this.no = no;
        this.weather = weather;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getWdate() {
        return wdate;
    }
    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }
}
