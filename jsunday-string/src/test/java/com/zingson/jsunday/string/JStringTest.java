package com.zingson.jsunday.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JStringTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true,JString.isEmpty(""));
    }

}