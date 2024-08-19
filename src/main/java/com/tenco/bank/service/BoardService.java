package com.tenco.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.bank.dto.BoardDTO;
import com.tenco.bank.model.Board;
import com.tenco.bank.repository.interfaces.BoardRepository;

@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Autowired
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@Transactional
	public void createBoard(BoardDTO dto) {
		int result = 0;
		try {
			result = boardRepository.insert(dto.toBoard());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 0) {
			System.out.println("정상 처리 되지 않았어");
		}
	}

	public List<Board> readBoardList(int page, int size) {
		int limit = size;
		int offset = (page - 1) * size;
		List<Board> boardListEntity = new ArrayList<>();
		try {
			boardListEntity = boardRepository.findAll(limit,offset);
			System.out.println("boardListEntity : " + boardListEntity.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardListEntity;
	}

	public Board viewById(int id) {
		Board board = null;
		board = boardRepository.findById(id);
		return board ;
	}
	
	@Transactional
	public void updateBoard(BoardDTO dto, int id) {
		System.out.println("id : " + id + "title : " + dto.getTitle() + "content : " + dto.getContent() + "author : " + dto.getAuthor());
		boardRepository.updateById(dto.getTitle(),dto.getContent(),dto.getAuthor(), id);
	}

	@Transactional
	public void deleteBoard(int id) {
		boardRepository.deleteById(id);
	}


	public int countHistoryByAccountIdAndType() {
		return boardRepository.countAllRow();
	}


}
