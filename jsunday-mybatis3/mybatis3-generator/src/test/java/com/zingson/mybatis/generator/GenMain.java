package com.zingson.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据配置文件生产Mybatis代码
 */
public class GenMain {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            String genCfg = "/mybatis-generator-oracle.xml";
            File configFile = new File(GenMain.class.getResource(genCfg).getFile());
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);

            MyBatisGenerator myBatisGenerator =  new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
