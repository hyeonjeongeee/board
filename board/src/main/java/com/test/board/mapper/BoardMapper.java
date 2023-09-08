package com.test.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	//전체 게시판 리스트 조회
	public List<BoardDto>selectBoardList();
	//하나의 게시글 등록
	public void insertBoard(BoardDto board);
	//게시글 번호로 하나의 게시글 상세 조회
	public BoardDto openBoardDeatail(int boardIdx);
	//조회수 증가
	public void updateHitCnt(int boardIdx);
	//게시글 수정
	public void updateBoard(BoardDto board);
	//게시글 삭제
	public void deleteBoard(int boardIdx);
}
