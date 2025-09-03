package com.kd.springdatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kd.springdatabase.dto.Fruit;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/guide")
@Controller
public class GuideController {
	@GetMapping("/guide")
	public void guide(HttpServletRequest request, Model model) {
		log.info("abc: {}", request.getParameter("abc"));
		
		// flashAttribute로 보낸 어트리뷰트들은 받는 쪽의 Model객체에 이미 추가되어 있다!!
		log.info("fruit from flashAttribute: {}", model.getAttribute("fruit"));
		log.info("babo from flashAttribute: {}", model.getAttribute("babo"));
	}
	
	@GetMapping("/desc1")
	public String desc1() {
		return "/guide/desc1";
	}
	@GetMapping("/list")
	public String to_list(RedirectAttributes ra) {
		// GET방식 쿼리 스트링(파라미터) 추가 -> 주소에 붙어간다
		ra.addAttribute("abc", 123);
		
		// 리다이렉트시 addAttribute는 사실 쿼리 스트링이기 때문에
		// 자바 객체는 불가능하고 String만 가능
		
		// 실제로는 세션 객체를 활용하여 동작하는 다음 리다이렉트까지만 유지되는 어트리뷰트
		// 필요한 경우 자바 객체를 전달 가능
		ra.addFlashAttribute("fruit", new Fruit(3, "토마토", 333, "길바닥"));
		ra.addFlashAttribute("babo", "바보");
		
		return "redirect:/guide/guide";
	}
	
	@GetMapping("/session1")
	public String sessionPage(HttpSession session) {
		session.setAttribute("icecream", "메로나");
		return "/guide/session";
	}
	@GetMapping("/session2")
	public String sessionPage2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("icecream", "스크류바");
		return "/guide/session";
	}
	@GetMapping("/session3")
	public String sessionPage3(
			@SessionAttribute String icecream,
			@SessionAttribute(required = false) String flavor) {
		// required를 false로 설정한 어트리뷰트는 자동주입을 받지 않더라도 null을 반환한다
		
		log.info("icecream : {}", icecream);
		log.info("맛: {}", flavor);
		return "/guide/session";
	}
	
	@GetMapping("/cookie/add")
	public String cookieAdd(
			HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookie = new Cookie("email", "abc123@gmail.com");
		
		cookie.setPath(request.getContextPath());
		cookie.setHttpOnly(true);	// 자바스크립트에서 못읽는다
		cookie.setMaxAge(-1);		// 웹 브라우저가 닫힐 때까지
		
		response.addCookie(cookie);
		return "redirect:/guide/guide";	// 컨텍스트패스를 알아서 더해준다
	}
	
	@GetMapping("/cookie/read")
	public String cookieRead(@CookieValue String email, Model model) {
		
		log.info("email from cookie: {}", email);
		// addAttribute할 때 name을 설정하지 않으면...?
		// 해당 클래스 타입의 첫 글자를 소문자로 한 것이 이름이 된다 
		// (email은 String클래스이므로 string이 됨)
		model.addAttribute(email);
		return "/guide/cookie";
	}
}
