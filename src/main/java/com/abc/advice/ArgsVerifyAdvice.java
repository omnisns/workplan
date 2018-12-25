package com.abc.advice;

import com.abc.annotation.ArgsVerify;
import com.abc.exception.SyncheaException;
import com.abc.util.ArraysUtil;
import com.abc.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Reen on 2018/12/18.
 */
@Aspect
@Component
public class ArgsVerifyAdvice {
    /**
     * 环绕通知@Around   @Before前置通知  @After后置通知
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* com.abc.service.*.*(..))")
    public Object argsVerify(ProceedingJoinPoint proceedingJoinPoint){

        try {
            //处理业务信息
            //获得代理类 proceedingJoinPoint.getThis().getClass()
            //获得参数值 proceedingJoinPoint.getArgs()
            //当前所切方法签名 proceedingJoinPoint.getSignature()

            //获取方法签名
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            //拿到参数
            Object[] args = proceedingJoinPoint.getArgs();
            //获取方法
            Method method = methodSignature.getMethod();
            //获取标记注解的方法,读取注解配置
            ArgsVerify argsVerifyAnnotation = method.getAnnotation(ArgsVerify.class);
            //获取需要忽视的类 和需要校验的实体属性
            String[] propertyNames = argsVerifyAnnotation.propertyNames();
            Class<?> verifyClass = argsVerifyAnnotation.checkClasss();

            //只对有参校验
            if (ArraysUtil.isNotEmty(args)){
                //对需要校验的类进行提出
                if ( null !=  verifyClass) {
                    //遍历获取匹配指定类型
                    for (Object arg : args) {
                        // 抽取匹配类型的参数，此时不考虑类加载器不同
                        if (verifyClass.equals(arg.getClass())){
                            //如果指定属性，反射校验
                            if (ArraysUtil.isNotEmty(propertyNames)){
                                Class thisArgClass =  arg.getClass();
                                //对参数进行遍历
                                for (String propertyName : propertyNames) {
                                    try {
                                        Method thisMethod = thisArgClass.getMethod(StringUtil.getMethodName(propertyName));
                                        Object invoke = thisMethod.invoke(arg);
                                        if (null == invoke){
                                            throw new IllegalArgumentException("校验参数为空异常");
                                        }
                                    }catch (ReflectiveOperationException ex ){
                                        continue;
                                    }

                                }

                            } else {
                                //无参数，直接校验指定类型参数不为空
                                if ( null == arg ){
                                    throw new IllegalArgumentException("校验参数为空异常");
                                }
                            }
                        }
                    }

                } else {
                    //没有指定类型，默认校验参数不为空
                    for (Object arg : args) {
                        if ( null == arg ){
                            throw new IllegalArgumentException("默认校验参数为空异常");
                        }

                    }
                }

            }
            return proceedingJoinPoint.proceed();
        }catch(IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        } catch (Throwable throwable) {
            throw new SyncheaException("参数验证切面异常:",throwable);
        }

    }
}
