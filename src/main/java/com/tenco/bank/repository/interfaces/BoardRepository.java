package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.bank.model.Board;

@Mapper
public interface BoardRepository {
	public int insert(Board board);
	public int updateById(@Param("title") String title,@Param("content") String content, @Param("author") String author , @Param("id") int id); 
	public int deleteById(int id); 
	public List<Board> findAll(@Param("limit") int limit, 
			@Param("offset") int offset);
	public Board findById(int id);
	public int countAllRow();
	
}
