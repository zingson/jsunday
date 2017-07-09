package com.ul.biz.waimai.mapper;

import com.ul.biz.waimai.model.WmOrderInfo;
import com.ul.core.spring.PropertyConfig;
import com.ul.core.spring.datasource.DataSource;

import java.util.List;

@DataSource(PropertyConfig.DB1)
public interface WmOrderInfoMapper {

    int insert(WmOrderInfo record);

    void deleteByOrderId(WmOrderInfo orderInfo);

    List<WmOrderInfo> selectAll();

    WmOrderInfo findOrderInfoById(String orderId);
}