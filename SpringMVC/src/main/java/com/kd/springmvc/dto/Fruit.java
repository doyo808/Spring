package com.kd.springmvc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
public class Fruit {
	@NonNull
	private String name;
	private Integer price;
	private String farm;
}
