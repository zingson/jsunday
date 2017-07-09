package com.ul.core.utils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Java反射工具类
 */
public class UReflect {




    /**
     * 清理对象或者Map中值为null的属性，返回Map集合
     * @param obj
     * @return
     */
    public static Map<String,Object> clearAttrByIsNull(Object obj){
        Map<String,Object> returnMap = new LinkedHashMap<>();
        if(obj instanceof Map){
            Map<String,Object> objectMap = (Map<String, Object>) obj;
            objectMap.forEach((k,v)->{
                if(v!=null) {
                    returnMap.put(k, v);
                }
            });
        }else{
            try {
                PropertyDescriptor[] propertyDescriptors =  Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
                for (PropertyDescriptor descriptor:propertyDescriptors) {
                    String propertyName = descriptor.getName();
                    if (propertyName.equals("class")) {
                        continue;
                    }
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(obj);
                    if(result!=null) {
                        returnMap.put(propertyName, result);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            return returnMap;
        }
        throw new RuntimeException("clearAttrByIsNull Error ");
    }
}
