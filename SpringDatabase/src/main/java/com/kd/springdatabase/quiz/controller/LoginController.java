package com.kd.springdatabase.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kd.springdatabase.quiz.service.LoginService;

@RestController
public class LoginController {
	
	private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
	
	@PostMapping("/quiz/loginRequest")
	public String loginRequest(
			@RequestParam String ID, @RequestParam String PW) {
		
		boolean success = loginService.login(ID, PW);
		
		return success ? "success" : "failed";
	}
	
}
