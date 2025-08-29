package com.kd.springdatabase.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Dog {
	String name;
	Integer age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date regist_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	Date regist_date2;
}
