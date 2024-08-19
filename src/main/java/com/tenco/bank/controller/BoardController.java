package com.tenco.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.bank.dto.BoardDTO;
import com.tenco.bank.model.Board;
import com.tenco.bank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@PostMapping("/write")
	public String writeProc(BoardDTO dto) {
		if (dto.getTitle() == null) {
			System.out.println("타이틀 입력 안 됨");
		}
		if (dto.getContent() == null) {
			System.out.println("내용 입력 X");
		}
		if (dto.getAuthor() == null) {
			System.out.println("작성자 입력이 안됐음");
		}
		boardService.createBoard(dto);
		
		return "redirect:/main";
	}
	
	@GetMapping("/revise")
	public String updatePage(Model model ,@RequestParam(name = "id") int id) {
		Board board = boardService.viewById(id);
		model.addAttribute("board",board);
		System.out.println(board.toString());
		return "user/update";
	}
	
	@PostMapping("/revise")
	public String updateProc(BoardDTO dto,@RequestParam(name = "id") int id) {
		boardService.updateBoard(dto,id);
		System.out.println("id : " + id + "title : " + dto.getTitle() + "content : " + dto.getContent() + "author : " + dto.getAuthor());
		return "redirect:/main";
	}
	
	@PostMapping("/delete")
	public String deleteProc(@RequestParam(name = "id") int id) {
		boardService.deleteBoard(id);
		return "redirect:/main";
	}
	
}
