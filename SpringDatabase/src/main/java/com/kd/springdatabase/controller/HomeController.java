package com.kd.springdatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping(value = {"/index", "/home", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/guide")
	public void guide(HttpServletRequest request) {
		log.info("abc: {}", request.getParameter("abc"));
	}
	
	@GetMapping("/guide/desc1")
	public String desc1() {
		return "desc1";
	}
	@GetMapping("/guide/list")
	public String to_list(RedirectAttributes ra) {
		// GET방식 쿼리 스트링(파라미터) 추가 -> 주소에 붙어간다
		ra.addAttribute("abc", 123);
		
		return "redirect:/guide";
	}
}
