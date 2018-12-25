package com.abc;

import com.abc.domain.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Reen on 2018/12/21.
 */
public class SimpleTest {


    @Test
    public  void testClass(){
        try {
            User user = new User();
            user.setUserId("1");

            Class<? extends User> userClass = user.getClass();

            Field userId = userClass.getDeclaredField("userId");
            String name = userId.getName();

            Method method = userClass.getMethod("get" + "UserId");

            String value = (String) method.invoke((Object)user);

            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
