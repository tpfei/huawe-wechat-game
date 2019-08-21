package com.huaweisoft.huawei5g.model;

public class PassLog {
    private Integer id;

    private Integer userid;

    private Integer passId;

    private Byte rights;

    private Byte stars;

    private Short score;

    private Short turnScore;

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

    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public Byte getRights() {
        return rights;
    }

    public void setRights(Byte rights) {
        this.rights = rights;
    }

    public Byte getStars() {
        return stars;
    }

    public void setStars(Byte stars) {
        this.stars = stars;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Short getTurnScore() {
        return turnScore;
    }

    public void setTurnScore(Short turnScore) {
        this.turnScore = turnScore;
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