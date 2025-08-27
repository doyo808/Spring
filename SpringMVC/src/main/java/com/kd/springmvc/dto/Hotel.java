package com.kd.springmvc.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Hotel {
	String name;
	String address;
	Chef chef;
	// Chef chef = new Chef(); 이러면 의존성이 높아져서 안좋다
}
