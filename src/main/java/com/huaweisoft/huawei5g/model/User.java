package com.huaweisoft.huawei5g.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;

public class User extends Model<User> {
    private Integer id;

    private Integer groupid;

    private Integer topgroup;

    private String groups;

    private String username;

    private String nickName;

    private String image;

    private String mobile;

    private String email;

    private Integer energy;

    private Integer sumScore;

    private Integer sumScoreRank;

    private Integer weekScore;

    private Integer weekScoreRank;

    private Integer signCount;

    private Integer signScore;

    private Integer taskLvl;

    private Integer taskCount;

    private Integer taskScore;

    private Integer pkCount;

    private Integer pkScore;

    private Integer pkWin;

    private Integer pkLose;

    private Integer createdAt;

    private Integer updateAt;

    private Integer onlineAt;

    private Byte status;

    public User() {
    }

    public User(Integer id, Integer groupid, String username, String nickName, String image, String mobile, String email, Byte status) {
        this.id = id;
        this.groupid = groupid;
        this.username = username;
        this.nickName = nickName;
        this.image = image;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public Integer getSumScoreRank() {
        return sumScoreRank;
    }

    public void setSumScoreRank(Integer sumScoreRank) {
        this.sumScoreRank = sumScoreRank;
    }

    public Integer getWeekScore() {
        return weekScore;
    }

    public void setWeekScore(Integer weekScore) {
        this.weekScore = weekScore;
    }

    public Integer getWeekScoreRank() {
        return weekScoreRank;
    }

    public void setWeekScoreRank(Integer weekScoreRank) {
        this.weekScoreRank = weekScoreRank;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getSignScore() {
        return signScore;
    }

    public void setSignScore(Integer signScore) {
        this.signScore = signScore;
    }

    public Integer getTaskLvl() {
        return taskLvl;
    }

    public void setTaskLvl(Integer taskLvl) {
        this.taskLvl = taskLvl;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public Integer getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Integer taskScore) {
        this.taskScore = taskScore;
    }

    public Integer getPkCount() {
        return pkCount;
    }

    public void setPkCount(Integer pkCount) {
        this.pkCount = pkCount;
    }

    public Integer getPkScore() {
        return pkScore;
    }

    public void setPkScore(Integer pkScore) {
        this.pkScore = pkScore;
    }

    public Integer getPkWin() {
        return pkWin;
    }

    public void setPkWin(Integer pkWin) {
        this.pkWin = pkWin;
    }

    public Integer getPkLose() {
        return pkLose;
    }

    public void setPkLose(Integer pkLose) {
        this.pkLose = pkLose;
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

    public Integer getOnlineAt() {
        return onlineAt;
    }

    public void setOnlineAt(Integer onlineAt) {
        this.onlineAt = onlineAt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}