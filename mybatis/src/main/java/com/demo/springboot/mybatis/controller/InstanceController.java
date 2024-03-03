package com.demo.springboot.mybatis.controller;

import com.demo.springboot.mybatis.entity.Instance;
import com.demo.springboot.mybatis.mapper.InstanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instance")
@RequiredArgsConstructor
public class InstanceController {

    private final InstanceMapper instanceMapper;

    @GetMapping
    public List<Instance> list() {
        return instanceMapper.selectList();
    }

}
