package com.abc.util;

/**
 * Created by Reen on 2018/12/23.
 */
public class StringUtil {

    public static String getMethodName (String property){

        if (null == property){
            return null;
        }
        char[] ch = property.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return "get"+new String(ch);
    }
}
