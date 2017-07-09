package com.ul.biz.waimai.service;

import com.ul.biz.waimai.model.WmOrderInfo;

import java.util.List;

public interface WmOrderInfoService {
    int insert(WmOrderInfo record);

    List<WmOrderInfo> selectAll();

    WmOrderInfo findOrderInfoById(String orderId);
}