package com.demo.springboot.mybatis.mapper;

import com.demo.springboot.mybatis.entity.Instance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstanceMapper {

    @Select("select * from wl_work_instance limit 10")
    List<Instance> selectList();
}
