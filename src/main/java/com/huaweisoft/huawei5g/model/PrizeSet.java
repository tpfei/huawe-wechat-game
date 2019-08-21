package com.huaweisoft.huawei5g.model;

public class PrizeSet {
    private Integer id;

    private String prizeName;

    private String prizeGift;

    private Integer prizeValue;

    private Short prizeNum;

    private String rule;

    private Integer createdAt;

    private Integer updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public String getPrizeGift() {
        return prizeGift;
    }

    public void setPrizeGift(String prizeGift) {
        this.prizeGift = prizeGift == null ? null : prizeGift.trim();
    }

    public Integer getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(Integer prizeValue) {
        this.prizeValue = prizeValue;
    }

    public Short getPrizeNum() {
        return prizeNum;
    }

    public void setPrizeNum(Short prizeNum) {
        this.prizeNum = prizeNum;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
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