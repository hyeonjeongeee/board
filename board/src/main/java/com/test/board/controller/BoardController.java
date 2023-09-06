package com.test.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.board.dto.BoardDto;
import com.test.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board")
@Slf4j
@AllArgsConstructor
@Controller
public class BoardController {
	private final BoardService boardService;
	//전체 게시글 조회
	@GetMapping("/boardList")
	public String openBoardList(Model model) {
		List<BoardDto> list = boardService.selectBoardList();
		log.info("list담긴 값:{}", list);
		model.addAttribute("list", list);
		return"boardList";
	}
	
	//하나의 게시글 등록	화면 
	@GetMapping("/openBoardWrite")
	public String openBoardWrite() {
		return"boardWrite";
	}
	//하나의 게시글 insert 
	@PostMapping("/insertBoard")
	public String insertBoard(BoardDto board) {
		boardService.insertBoard(board);
		return"redirect:boardList";
	}
	@GetMapping("/openBoardDeatail")
	public String openBoardDeatail(@RequestParam int boardIdx, Model model) {
		BoardDto board = boardService.openBoardDeatail(boardIdx);
		log.info("boarddetail담긴 값:{}", board);
		model.addAttribute("board",board);
		return "boardDetail";
	}
}	