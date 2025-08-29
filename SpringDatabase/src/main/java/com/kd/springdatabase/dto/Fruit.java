package com.kd.springdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fruit {
	private Integer fid;
	private String fname;
	private Integer fprice;
	private String farm;
}
