package com.kd.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.springrest.dto.AnimalDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyRestController {
	
	@GetMapping(
			value = "/restful/value1",
			produces = "text/plain; charset=UTF-8")
	public String value1() {
		// @RestController 내부의 String타입 메서드는
		// 해당 템플릿 경로를 찾아가서 응답하는 것이 아니라
		// 그냥 String 데이터를 응답하는 것이다
		return "안녕하세요 여긴 text/plain";
	}
	
	@GetMapping(value="/restful/value2",
			produces = "text/html; charcet=UTF-8")
	public String value2() {
		return "<h3>안녕하세요! 여긴 text/html</h3>";
	}
	
	// RestController에서 자바빈 형태의 객체를
	// 자동으로 JSON 형식으로 변환하여 응답해준다 (jackson-databind 라이브러리)
	@GetMapping(value="/restful/value3",
			produces="application/json; charset=UTF-8")
	public AnimalDTO values3() {
		return new AnimalDTO("바둑이", 5, "개");
	}
	
	@GetMapping(value="/restful/value4",
			produces="application/xml; charset=UTF-8")
	public AnimalDTO value4() {
		return new AnimalDTO("묘식이", 3, "고양이");
	}
	
	@GetMapping(value="/restful/value5",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AnimalDTO> value5() {
		List<AnimalDTO> animals = new ArrayList<>();
		
		animals.add(new AnimalDTO("백구", 3, "애완용"));
		animals.add(new AnimalDTO("천구", 3, "애완용"));
		animals.add(new AnimalDTO("만구", 3, "탐지용"));
		animals.add(new AnimalDTO("억구", 3, "경비용"));
		animals.add(new AnimalDTO("경구", 3, "경주용"));
		return animals;
	}
	
	@GetMapping(value="/restful/value6",
			produces=MediaType.APPLICATION_XML_VALUE)
	public List<AnimalDTO> value6() {
		List<AnimalDTO> animals = new ArrayList<>();
		
		animals.add(new AnimalDTO("백구", 3, "애완용"));
		animals.add(new AnimalDTO("천구", 3, "애완용"));
		animals.add(new AnimalDTO("만구", 3, "탐지용"));
		animals.add(new AnimalDTO("억구", 3, "경비용"));
		animals.add(new AnimalDTO("경구", 3, "경주용"));
		return animals;
	}
	
	@GetMapping("/restful/entity1")
	public ResponseEntity<String> entity1() {
		// ResponseEntity는 원하는 응답의 모든 것을 직접 생성하여 리턴하는 방식이다
		// (해당 응답의 상태 코드, 해당 응답의 종류, 응답의 내용 등...)
		
		// 원하는 내용을 계속 추가해가면서 응답을 생성하다가
		// 마지막에는 body를 생성해 해당 객체 생성을 마무리 지을 수 있다
		return ResponseEntity
				.status(200)
				.contentType(MediaType.TEXT_HTML)
				.body("<html><head><title>Hi"
						+ "</title></head><body><h3>Hello~"
						+ "</h3></body></html>");
	}
	
	// ResponseEntity의 제네릭은 응답의 body에 실려가는 데이터의 타입을 의미한다
	@GetMapping("/restful/entity2")
	public ResponseEntity<AnimalDTO> entity2() {
		// ResponseEntity 타입으로 직접 데이터 응답을 제작하여 보내는 방법
		// ResponseEntity로 생성한 자바빈 객체 응답도 jackson-databind가 변환해준다
		return ResponseEntity
				.status(200)
				.contentType(MediaType.APPLICATION_JSON)
				.body(new AnimalDTO("춘식이", 2, "곰"));
	}
	
	@GetMapping("/restful/entity3")
	public ResponseEntity<String> entity3() {
		return ResponseEntity
				.status(404)
				.body("페이지 못 찾음");
	}
}
