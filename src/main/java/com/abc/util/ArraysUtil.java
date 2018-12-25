package com.abc.util;

/**
 * Created by Reen on 2018/12/19.
 * @author reen
 * 数组工具类
 */
public class ArraysUtil {

    /**
     *
     * @param objects 数组集合
     * @return 数组为空
     */
    public static boolean isEmty(Object [] objects){
        if ( null == objects ){
            return true;
        }else {
            return objects.length == 0;
        }

    }

    /**
     *
     * @param objects 数组集合
     * @return 数组不为空
     */
    public static boolean isNotEmty(Object [] objects){
        if ( null != objects ){
            return objects.length > 0;
        }
        return false;
    }

    /**
     *
     * @param objects 数组
     * @param o 元素
     * @return 数组是否包含这个元素
     */
    public static boolean containElement(Object [] objects ,Object o){
        boolean flag = false;
        for (Object object : objects) {
            if ( object.equals(o) ){
                flag = true;
                break;
            }
        }
        return flag;
    }


}
