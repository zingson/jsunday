package com.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

public class MybatisGenMain {

    public static void main(String[] args) {
        new MybatisGenMain().generatorMybatisMapper();
    }


    /**
     * 生成MyBatis Mapper代码
     */
    public void generatorMybatisMapper(){
        final String genCfg = "/mybatis-generator-oracle.xml";
        try {
            new MyBatisGenerator(new ConfigurationParser(new ArrayList<>())
                    .parseConfiguration(new File(this.getClass().getResource(genCfg).getFile()))
                    , new DefaultShellCallback(true)
                    , new ArrayList<>()).generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
