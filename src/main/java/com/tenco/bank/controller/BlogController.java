package com.tenco.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.bank.model.Board;
import com.tenco.bank.service.BoardService;

@Controller
public class BlogController {

	private final BoardService boardService;

	@Autowired
	public BlogController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping({ "/main", "/index" })
	public String blogPage(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		int limit = size;
		int offset = (page - 1) * size;
		
		int totalRecords = boardService.countHistoryByAccountIdAndType();
		int totalPages = (int)Math.ceil( (double)totalRecords / size);
		
		List<Board> boardList = boardService.readBoardList(page,size);
		if (boardList.isEmpty()) {
			model.addAttribute("boardList", null);
		} else {
			model.addAttribute("boardList", boardList);
		}
		model.addAttribute("boardList", boardList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		return "main";
	}

	@GetMapping("/write")
	public String writePage() {
		System.out.println("호출 확인");
		return "user/write";
	}
}
