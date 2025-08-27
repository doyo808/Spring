package com.kd.springmvc.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	String name;
	String carrer;
	int age;
}
