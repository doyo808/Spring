package com.kd.springdatabase.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Pizza {
	private Integer pizza_id;
	private String pizza_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date made_date;
}
