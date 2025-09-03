package com.kd.springdatabase.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
	
	@GetMapping("/quiz")
	public String quiz() {
		return "/quiz/index";
	}
	
	@GetMapping("/success")
	public String success(@RequestParam String ID, Model model) {
		model.addAttribute("userId", ID);
		return "/quiz/loginSuccess";
	}
}
