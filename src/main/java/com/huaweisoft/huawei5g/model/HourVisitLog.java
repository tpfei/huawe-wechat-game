package com.huaweisoft.huawei5g.model;

public class HourVisitLog {
    private Integer id;

    private Integer userid;

    private Integer hours;

    private Short visitCount;

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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Short getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Short visitCount) {
        this.visitCount = visitCount;
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
        return "HourVisitLog{" +
                "id=" + id +
                ", userid=" + userid +
                ", hours=" + hours +
                ", visitCount=" + visitCount +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}