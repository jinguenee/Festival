package com.yg.festival.board.service;

import java.util.List;

import com.yg.festival.board.bean.BoardBean;
import com.yg.festival.board.bean.BoardFileBean;

public interface BoardService {
	
	/** 게시글 insert 처리 **/
	public int insertBoard(BoardBean bBean);
	
	/** 게시글 insert 업로드 처리 **/
	public int insertBoardFile(BoardBean bBean, BoardFileBean bfBeen, String upPath);
	
	/** 게시글 1건 조회 **/
	public BoardBean selectBoard(BoardBean bean);
	
	/** 게시글 정보 조회 **/
	public List<BoardBean> selectBoardInfo(BoardBean bean);
	
	/** 게시판 게시글 수정 **/
	public int updateBoard(BoardBean bean);
	
	/** 게시판 조회수 증가 **/
	public int updateBoardJoin(BoardBean bean);
	
}
