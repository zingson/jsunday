package com.ul.biz.waimai.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ul.biz.waimai.model.WmOrderInfo;
import com.ul.core.spring.BaseJunitTest;
import com.ul.core.spring.PropertyConfig;
import com.ul.core.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.*;

public class UltabWmOrderInfoMapperTest extends BaseJunitTest {

    @Autowired(required = false)
    private WmOrderInfoMapper wmOrderInfoMapper;

    @Test
    public void insert() throws Exception {
        WmOrderInfo orderInfo = new WmOrderInfo();
        orderInfo.setOrderId("1200000000000");
        orderInfo.setMercId("123000000000000");

        int i = wmOrderInfoMapper.insert(orderInfo);
        log.info("i={}",i);
        wmOrderInfoMapper.deleteByOrderId(orderInfo);
    }

    @Test
    public void deleteByOrderId() throws Exception {
        WmOrderInfo orderInfo = new WmOrderInfo();
        orderInfo.setOrderId("1200000000000");

        wmOrderInfoMapper.deleteByOrderId(orderInfo);
    }

    @Test
    public void selectAll() throws Exception {

        PageHelper.startPage(1,3);
        Page<WmOrderInfo> page = (Page<WmOrderInfo>) wmOrderInfoMapper.selectAll();

        log.info(JsonUtil.obj2json(page));
        log.info("Total={}",page.getTotal());

        assertEquals(3,page.size());

    }

}