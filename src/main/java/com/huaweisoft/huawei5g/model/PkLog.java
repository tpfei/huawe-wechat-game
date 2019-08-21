package com.huaweisoft.huawei5g.model;

public class PkLog {
    private Integer id;

    private Integer userid;

    private String roomId;

    private String days;

    private Short answerCount;

    private Short answerScore;

    private Short turnCount;

    private Short turnScore;

    private Short prizeScoreCount;

    private Short prizeScore;

    private Byte win;

    private Integer createdAt;

    private Integer updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    public Short getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Short answerCount) {
        this.answerCount = answerCount;
    }

    public Short getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(Short answerScore) {
        this.answerScore = answerScore;
    }

    public Short getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(Short turnCount) {
        this.turnCount = turnCount;
    }

    public Short getTurnScore() {
        return turnScore;
    }

    public void setTurnScore(Short turnScore) {
        this.turnScore = turnScore;
    }

    public Short getPrizeScoreCount() {
        return prizeScoreCount;
    }

    public void setPrizeScoreCount(Short prizeScoreCount) {
        this.prizeScoreCount = prizeScoreCount;
    }

    public Short getPrizeScore() {
        return prizeScore;
    }

    public void setPrizeScore(Short prizeScore) {
        this.prizeScore = prizeScore;
    }

    public Byte getWin() {
        return win;
    }

    public void setWin(Byte win) {
        this.win = win;
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
}