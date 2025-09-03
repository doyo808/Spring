package com.kd.springdatabase.board.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kd.springdatabase.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardMapper {
	
	private final SqlSessionTemplate sql;
	
	public BoardDTO get(Integer board_id) {
		return sql.selectOne("Boards.get", board_id);
	}
	
	public void plusViewCount(Integer board_id) {
		sql.update("Boards.plusViewCount", board_id);
	}
}
