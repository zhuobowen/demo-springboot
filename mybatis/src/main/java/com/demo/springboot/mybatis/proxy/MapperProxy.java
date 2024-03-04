package com.demo.springboot.mybatis.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理类
 * @author 86479
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private Map<String, Object> sqlSession;

    private Class<T> mapperInterface;

    public MapperProxy(Map<String, Object> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "欢迎你：" + args[0];
    }

}
