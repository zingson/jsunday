package com.unionlive.waimai.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.unionlive.waimai.model.UltabWmOrderInfo;
import com.zingson.mybatis.MybatisTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by songz on 2017/6/16.
 */
public class UltabWmOrderInfoMapperTest extends MybatisTest {


    @Test
    public void selectAll() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UltabWmOrderInfoMapper mapper = session.getMapper(UltabWmOrderInfoMapper.class);

        PageHelper.startPage(3,10);
        Page<UltabWmOrderInfo> list = (Page<UltabWmOrderInfo>) mapper.selectAll();

        assertEquals(10,list.size());
        System.out.println(list.getTotal());
    }

}