package com.test.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.board.dto.BoardDto;
import com.test.board.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class BoardService {
	private final BoardMapper boardMapper;
	//전체 리스트 조회
	public List<BoardDto> selectBoardList(){
		List<BoardDto>selectBoardList= boardMapper.selectBoardList();
		return selectBoardList;
	}
	//하나의 게시글 insert
	public void insertBoard(BoardDto board) {
		log.info("board에 담기는 값:{}",board);
		boardMapper.insertBoard(board);
	}
	public BoardDto openBoardDeatail(int boardIdx){
		BoardDto boardDetail = boardMapper.openBoardDeatail(boardIdx);
		return boardDetail;
	}
}
