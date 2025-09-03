package com.kd.springrest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kd.springrest.dto.AnimalDTO;

@RequestMapping("/jquery")
@Controller
public class JQueryController {
	
	@GetMapping("/")
	public String home() {
		return "/jquery/index";
	}
	
	@ResponseBody
	@GetMapping(value = "/animal/dog", produces = MediaType.APPLICATION_JSON_VALUE)
	public AnimalDTO getDog() {
		return new AnimalDTO("바둑이", 4, "허스키");
	}
	
	
	
}
