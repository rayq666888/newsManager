package com.newsmanager.entity;

import java.util.Date;

/**
 * @author Administrator
 * @date 2019/7/12 22:43:31
 * @description 新闻表对应的实体类
 */
public class News {
    private int newsId;
    private String newsTitle;
    private String newsContent;
    private String newsStatus;
    private String newsType;
    private Date createTime;

    public News(int newsId, String newsTitle, String newsContent, String newsStatus, String newsType, Date createTime) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsStatus = newsStatus;
        this.newsType = newsType;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsStatus='" + newsStatus + '\'' +
                ", newsType='" + newsType + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public String getNewsType() {
        return newsType;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
