package com.huaweisoft.huawei5g.model;

public class DayVisitLog {
    private Integer id;

    private Integer userid;

    private String days;

    private Short visitCount;

    private Integer tickCount;

    private Byte signCount;

    private Short taskCount;

    private Short pkCount;

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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    public Short getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Short visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getTickCount() {
        return tickCount;
    }

    public void setTickCount(Integer tickCount) {
        this.tickCount = tickCount;
    }

    public Byte getSignCount() {
        return signCount;
    }

    public void setSignCount(Byte signCount) {
        this.signCount = signCount;
    }

    public Short getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Short taskCount) {
        this.taskCount = taskCount;
    }

    public Short getPkCount() {
        return pkCount;
    }

    public void setPkCount(Short pkCount) {
        this.pkCount = pkCount;
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

    @Override
    public String toString() {
        return "DayVisitLog{" +
                "id=" + id +
                ", userid=" + userid +
                ", days='" + days + '\'' +
                ", visitCount=" + visitCount +
                ", tickCount=" + tickCount +
                ", signCount=" + signCount +
                ", taskCount=" + taskCount +
                ", pkCount=" + pkCount +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}