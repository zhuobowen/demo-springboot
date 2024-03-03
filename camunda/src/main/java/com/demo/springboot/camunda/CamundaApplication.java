package com.demo.springboot.camunda;

import org.camunda.bpm.engine.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaApplication {

	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

}
