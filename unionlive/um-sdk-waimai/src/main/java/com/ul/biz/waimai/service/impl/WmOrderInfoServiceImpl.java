package com.ul.biz.waimai.service.impl;

import com.ul.biz.waimai.mapper.WmOrderInfoMapper;
import com.ul.biz.waimai.model.WmOrderInfo;
import com.ul.biz.waimai.service.WmOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WmOrderInfoServiceImpl implements WmOrderInfoService{

    @Autowired
    private WmOrderInfoMapper wmOrderInfoMapper;

    @Override
    public int insert(WmOrderInfo record) {
        return 0;
    }

    @Override
    public List<WmOrderInfo> selectAll() {
        return wmOrderInfoMapper.selectAll();
    }

    @Override
    public WmOrderInfo findOrderInfoById(String orderId) {
        return wmOrderInfoMapper.findOrderInfoByOrderId(orderId);
    }
}