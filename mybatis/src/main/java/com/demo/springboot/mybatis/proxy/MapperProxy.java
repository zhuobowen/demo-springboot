package com.demo.springboot.mybatis.proxy;

import com.demo.springboot.mybatis.annotation.Select;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理类
 * @author 86479
 */
@EqualsAndHashCode
@ToString
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private final Map<String, Object> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, Object> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Select annotation = method.getAnnotation(Select.class);
        String[] value = annotation.value();
        System.out.println("欢迎你：" + sqlSession.get("test") + mapperInterface.getName());
        return value;
    }

}
