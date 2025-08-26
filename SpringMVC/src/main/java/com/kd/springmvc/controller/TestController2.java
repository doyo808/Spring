package com.kd.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kd.springmvc.dto.Coffee;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController2 {

	@GetMapping("/coffee/add")
	public String coffeeAdd() {
		System.out.println("겟으로 오나요?");
		return "/coffee/coffeeAddForm";
	}
	
	@PostMapping("/coffee/add")
	public String add(HttpServletRequest req) {
		String coffee_name = req.getParameter("coffee_name");
		String coffee_bean = req.getParameter("coffee_bean");
		String coffee_price = req.getParameter("coffee_price");
		
		System.out.println("coffee_name: " + coffee_name);
		System.out.println("coffee_bean: " + coffee_bean);
		System.out.println("coffee_price: " + coffee_price);
		
		return "redirect:/coffee/add";
	}
	
	// 해당 파라미터를 필드로 갖는 모델 객체를 매개변수로 활용하면
	// 파라미터에 있는 값을 활용하여 자동으로 만들어진 새 인스턴스가 전달된다
	// 타입캐스팅도 자동으로 된다
	@PostMapping("/coffee/add2")
	public String add2(Coffee coffee, Model model) {
		System.out.println("coffee to add: " + coffee);
		
		// DB에 추가 후 ID 잘 얻어왓다고 가정...
		coffee.setCoffee_id(138);
		
		// 값을 다음 객체로 실어보낼때는(데이터만) 어트리뷰트보다 모델 객체를 사용하는 것이 바람직하다
//		request.setAttribute("coffee", coffee);
//		request.setAttribute("result", "success");
		model.addAttribute("coffee", coffee);
		model.addAttribute("result", "failed");
		
		return "/coffee/add_result";
	}
	
	// 컨트롤러에 전달되는 파라미터의 이름과 똑같은 이름의 매개변수를 선언해두면
	// 파라미터 값을 알아서 매핑해준다
	@PostMapping("/coffee/add3")
	public String add3(
			@RequestParam("coffee_name") String coffee_name,
			@RequestParam("coffee_bean") String coffee_bean,
			@RequestParam("coffee_price") Integer coffee_price) {
		System.out.println("coffee_name: " + coffee_name);
		System.out.println("coffee_bean: " + coffee_bean);
		System.out.println("coffee_price: " + coffee_price);
		
		return "redirect:/coffee/add";
	}
}
