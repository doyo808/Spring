package com.kd.springdatabase.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kd.springdatabase.dto.Pizza;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PizzaMapper {
	
	private final SqlSessionTemplate sql;
	
	public List<Pizza> selectAll() {
		return sql.selectList("Pizzas.selectAll");
	}
	
	public Pizza selectOne(Integer id) {
		return sql.selectOne("Pizzas.selectOne", id);
	}
	
	public int deleteById(Integer pizza_id) {
		return sql.delete("Pizzas.deleteById", pizza_id);
	}
	
	public int update(Pizza pizza) {
		return sql.update("Pizzas.modify", pizza);
	}
	
	public int addPz1(Pizza pizza) {
		return sql.insert("Pizzas.add1", pizza);
	}
	public Integer addPz2(Pizza pizza) {
		int result = sql.insert("Pizzas.add2", pizza);
		
		if (result > 0) {
			// selectKey를 성공하고 나면 전달했던 dto에 pk를 채워 놓는다
			return pizza.getPizza_id();			
		} else {
			return null;
		}
	}
}
