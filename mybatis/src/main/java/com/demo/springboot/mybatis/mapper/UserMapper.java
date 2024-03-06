package com.demo.springboot.mybatis.mapper;

import com.demo.springboot.mybatis.annotation.Select;

/**
 * @author zbw
 */
public interface UserMapper {

    @Select("select * from ss_user t where t.login_name = #{loginName}")
    String queryUserName(String loginName);

}
