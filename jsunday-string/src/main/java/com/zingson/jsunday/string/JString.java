package com.zingson.jsunday.string;

/**
 * @author zengs
 * 字符串处理工具类
 */
public class JString {

    /**
     *
     * @param v
     * @return
     */
    public static boolean isEmpty(Object v){
        return v==null||"".equals(String.valueOf(v).trim());
    }

}
