package com.zingson.log;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Before
    public void before(){

    }

    @Test
    public void logTest(){
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

    }


}
