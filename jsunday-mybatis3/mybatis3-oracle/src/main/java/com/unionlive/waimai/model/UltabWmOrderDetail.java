package com.unionlive.waimai.model;

public class UltabWmOrderDetail {
    private String orgId;

    private String mercId;

    private String shopId;

    private String orderId;

    private String prodId;

    private Integer prodNum;

    private Long prodPrice;

    private Long prodAmount;

    private String prodName;

    private String channelProdId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId == null ? null : mercId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getProdNum() {
        return prodNum;
    }

    public void setProdNum(Integer prodNum) {
        this.prodNum = prodNum;
    }

    public Long getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Long prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Long getProdAmount() {
        return prodAmount;
    }

    public void setProdAmount(Long prodAmount) {
        this.prodAmount = prodAmount;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getChannelProdId() {
        return channelProdId;
    }

    public void setChannelProdId(String channelProdId) {
        this.channelProdId = channelProdId == null ? null : channelProdId.trim();
    }
}