package com.demo.springboot.mybatis.proxy;

import com.demo.springboot.mybatis.mapper.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class ProxyTest {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{UserMapper.class}, (proxy, method, args1) ->
                        "欢迎你：" + args1[0]);
        String userName = userMapper.queryUserName("张三");
        System.out.println(userName);


        MapperProxyFactory<UserMapper> mapperProxyFactory =
                new MapperProxyFactory<>(UserMapper.class);
        UserMapper userMapper1 = mapperProxyFactory.newInstance(new HashMap<>());
        String userName1 = userMapper1.queryUserName("李四");
        System.out.println(userName1);
        
    }
}
