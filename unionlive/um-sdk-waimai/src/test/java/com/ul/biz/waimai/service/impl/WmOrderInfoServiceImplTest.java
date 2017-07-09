package com.ul.biz.waimai.service.impl;

import com.ul.biz.waimai.model.WmOrderInfo;
import com.ul.biz.waimai.service.WmOrderInfoService;
import com.ul.core.spring.BaseJunitTest;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by song on 2017/7/9.
 */
public class WmOrderInfoServiceImplTest extends BaseJunitTest {

    @Resource(name = "wmOrderInfoServiceImpl")
    private WmOrderInfoService wmOrderInfoService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

    @Test
    public void findOrderInfoById() throws Exception {
        WmOrderInfo orderInfo = wmOrderInfoService.findOrderInfoById("17011103240911503277");
        System.out.println(orderInfo);
        assertEquals("17011103240911503277",orderInfo.getOrderId());
    }

}