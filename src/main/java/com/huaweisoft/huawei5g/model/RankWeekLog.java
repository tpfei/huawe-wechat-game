package com.huaweisoft.huawei5g.model;

public class RankWeekLog {
    private Integer id;

    private Integer userid;

    private Integer groupid;

    private Integer topgroup;

    private Integer score;

    private Byte rankType;

    private Short rankId;

    private String weeks;

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

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getTopgroup() {
        return topgroup;
    }

    public void setTopgroup(Integer topgroup) {
        this.topgroup = topgroup;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getRankType() {
        return rankType;
    }

    public void setRankType(Byte rankType) {
        this.rankType = rankType;
    }

    public Short getRankId() {
        return rankId;
    }

    public void setRankId(Short rankId) {
        this.rankId = rankId;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks == null ? null : weeks.trim();
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