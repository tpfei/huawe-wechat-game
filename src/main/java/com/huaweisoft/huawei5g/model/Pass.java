package com.huaweisoft.huawei5g.model;

public class Pass {
    private Integer id;

    private Integer passId;

    private Integer topicId1;

    private Integer topicId2;

    private Integer topicId3;

    private Integer topicId4;

    private Integer topicId5;

    private Integer topicId6;

    private String videoTitle;

    private String videoUrl;

    private Integer videoPraise;

    private Integer videoPosts;

    private Integer createdAt;

    private Integer updateAt;

    private String videoDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public Integer getTopicId1() {
        return topicId1;
    }

    public void setTopicId1(Integer topicId1) {
        this.topicId1 = topicId1;
    }

    public Integer getTopicId2() {
        return topicId2;
    }

    public void setTopicId2(Integer topicId2) {
        this.topicId2 = topicId2;
    }

    public Integer getTopicId3() {
        return topicId3;
    }

    public void setTopicId3(Integer topicId3) {
        this.topicId3 = topicId3;
    }

    public Integer getTopicId4() {
        return topicId4;
    }

    public void setTopicId4(Integer topicId4) {
        this.topicId4 = topicId4;
    }

    public Integer getTopicId5() {
        return topicId5;
    }

    public void setTopicId5(Integer topicId5) {
        this.topicId5 = topicId5;
    }

    public Integer getTopicId6() {
        return topicId6;
    }

    public void setTopicId6(Integer topicId6) {
        this.topicId6 = topicId6;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getVideoPraise() {
        return videoPraise;
    }

    public void setVideoPraise(Integer videoPraise) {
        this.videoPraise = videoPraise;
    }

    public Integer getVideoPosts() {
        return videoPosts;
    }

    public void setVideoPosts(Integer videoPosts) {
        this.videoPosts = videoPosts;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Integer updateAt) {
        this.updateAt = updateAt;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }
}