package com.kd.springmvc.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kd.springmvc.dto.Fish;

@Controller
public class LombokTestController {
	
	// 현재 클래스에서 발생하는 로그를 수집하는 Logger를 생성 -> appender로 보낸다
	private final static Logger log = LoggerFactory.getLogger(LombokTestController.class);
	
	@GetMapping("/lombok/") 
	public String index() {
		return "/test/lombok";
	}
	
	@GetMapping("/lombok/test1")
	public String test1() {
		Fish f = new Fish("방어", new Date(), 3.5, 1000.0);
		
//		System.out.println("생선 객체가 하나 만들어짐: " + f);
		log.info("생선 객체가 하나 만들어짐... : {}", f);
		
		try {
			f.setName(null);
			log.error("@NonNull이 제대로 작동하지 않음");
		} catch (NullPointerException e) {
			log.error("생선 이름에 null을 넣으려 했으나 실패함");
		}
		
		log.trace("{}", f.getName());
		log.trace("{}", f.getKg());
		log.trace("{}", f.getPrice_per_kg());
		
		return "redirect:/lombok/";
	}
}
