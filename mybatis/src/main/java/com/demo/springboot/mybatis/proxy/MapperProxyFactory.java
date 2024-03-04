package com.demo.springboot.mybatis.proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class MapperProxyFactory<T> {

    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, Object> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{mapperInterface}, 
                mapperProxy);
    }

}
