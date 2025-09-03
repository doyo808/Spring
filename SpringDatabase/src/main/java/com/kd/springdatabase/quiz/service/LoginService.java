package com.kd.springdatabase.quiz.service;

import com.kd.springdatabase.board.controller.BoardController;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean login(String ID, String PW) {
		
		System.out.println("ID: " + ID);
		System.out.println("PW: " + PW);
		
		if (ID.equals("qwer") && PW.equals("1234")) {
			return true;
		} else {
			return false;		
		}
	}
}

