package com.test.web.board.service;

import java.util.List;
import java.util.Map;

import com.test.web.board.bean.BoardAttachBean;
import com.test.web.board.bean.BoardBean;
import com.test.web.board.bean.BoardReplyBean;
import com.test.web.common.bean.PagingBean;

public interface BoardService {

	//게시글 1건 조회
	public BoardBean selectBoard(BoardBean bean);
	
	//댓글 목록 조회
	public List<BoardReplyBean> selectBoardReplyList(PagingBean bean);
	
	//게시글과 댓글목록을 한꺼번에 조회하는 처리
	public Map<String, Object> selectBoardReplyInfo(PagingBean pBean);
	
	//게시글과 파일의 정보를 한꺼번에 insert 처리
	public int insertBoardAttach(BoardBean bBean, BoardAttachBean baBean, String upPath);
	
}
