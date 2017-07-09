package com.ul.biz.waimai.mapper;

import com.ul.biz.waimai.model.WmOrderInfo;
import java.util.List;

public interface WmOrderInfoMapper {
    int insert(WmOrderInfo record);

    List<WmOrderInfo> selectAll();

    WmOrderInfo findOrderInfoByOrderId(String orderId);


}