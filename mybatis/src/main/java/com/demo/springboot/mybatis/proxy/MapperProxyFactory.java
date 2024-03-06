package com.demo.springboot.mybatis.proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author zbw
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, Object> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return mapperInterface.cast(Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{mapperInterface},
                mapperProxy));
    }

}
