package com.zingson.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis mysql test
 */
public class MybatisTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSessionFactory(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        log.info("SqlSession={}",sqlSession);
    }



}
