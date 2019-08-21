package com.huaweisoft.huawei5g.model;

public class PrizeMember {
    private Integer id;

    private Integer prizeSetId;

    private Short prizeSetRank;

    private String seg1;

    private String seg2;

    private String seg3;

    private Integer createdAt;

    private Integer updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrizeSetId() {
        return prizeSetId;
    }

    public void setPrizeSetId(Integer prizeSetId) {
        this.prizeSetId = prizeSetId;
    }

    public Short getPrizeSetRank() {
        return prizeSetRank;
    }

    public void setPrizeSetRank(Short prizeSetRank) {
        this.prizeSetRank = prizeSetRank;
    }

    public String getSeg1() {
        return seg1;
    }

    public void setSeg1(String seg1) {
        this.seg1 = seg1 == null ? null : seg1.trim();
    }

    public String getSeg2() {
        return seg2;
    }

    public void setSeg2(String seg2) {
        this.seg2 = seg2 == null ? null : seg2.trim();
    }

    public String getSeg3() {
        return seg3;
    }

    public void setSeg3(String seg3) {
        this.seg3 = seg3 == null ? null : seg3.trim();
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