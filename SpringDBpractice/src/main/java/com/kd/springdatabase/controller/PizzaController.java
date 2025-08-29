package com.kd.springdatabase.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kd.springdatabase.dto.Dog;
import com.kd.springdatabase.dto.Pizza;
import com.kd.springdatabase.mapper.PizzaMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/pizza")
@Controller
public class PizzaController {
	
	@Autowired
	PizzaMapper pm;
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Pizza> pizzas = pm.selectAll();
		
//		for (Pizza p : pizzas) {
//			log.info("{}", p);
//		}
		
		model.addAttribute("pizzas", pizzas);
	}
	
	@GetMapping("/modify")
	public String modifyForm(@RequestParam Integer pizza_id, Model model) {
		model.addAttribute("pizza", pm.selectOne(pizza_id));
		return "/pizza/modify_form";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam Integer pizza_id) throws Exception {
		log.info("이제 {}번 상품을 삭제해야 합니다!", pizza_id);
		
		int result = pm.deleteById(pizza_id);
		if (result > 0) {
			log.info("삭제 완료!!");
			return "redirect:/pizza/list";
		} else {
			throw new Exception("삭제 실패!");
		}
	}
	
	@PostMapping("/modify")
	public String modify(Pizza pizza) throws Exception {
		int result = pm.update(pizza);
		
		if (result > 0) {
			log.info("수정 완료!!");
			return "redirect:/pizza/list";
		} else {
			throw new Exception("수정 실패!");
		}
	}
	
	@PostMapping("/timetest")
	public String timetest(@RequestParam String regist_date,
							@RequestParam String regist_date2) {
		log.info("regist date: {}", regist_date);
		log.info("regist date2: {}", regist_date2);
		
		return "redirect:/pizza/list";
	}
	
	@PostMapping("/timetest2")
	public String timetest2(Dog dog) {
		log.info("dog's regist date: {}", dog.getRegist_date());
		log.info("dog's regist date2: {}", dog.getRegist_date2());
		
		return "redirect:/pizza/list";
	}
	
	
	@GetMapping("/add")
	public String addForm(Model model) {
		// DB에서 이런 값을 꺼내와서 활용하는 건 어떨까..?
		List<String> pizzaNames = List.of("하와이안피자", "불고기피자", "치즈피자");
		model.addAttribute("pizzaNames", pizzaNames);
		 
		LocalDate today = LocalDate.now();
		model.addAttribute("today", today);
		
		return "/pizza/add_form";
	}
	
	@PostMapping("/add1")
	public String add(Pizza pizza) throws Exception {
		
		int result = pm.addPz1(pizza);
		log.info("insert문 실행 결과: {}", result);
		
		if (result > 0) {return "redirect:/pizza/list";}
		else {throw new Exception("insert 실패!!");}
	}
	@PostMapping("/add2")
	public String add2(Pizza pizza) throws Exception {
		
		Integer pk = pm.addPz2(pizza);
		log.info("insert문 실행 결과(기본키): {}", pk);
		
		if (pk > 0) {return "redirect:/pizza/list";}
		else {throw new Exception("insert 실패!!");}
	}
	
	
	
	
}
