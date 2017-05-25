package com.test.web.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.web.board.bean.BoardAttachBean;
import com.test.web.board.bean.BoardBean;
import com.test.web.board.bean.BoardReplyBean;
import com.test.web.board.dao.BoardAttachDao;
import com.test.web.board.dao.BoardDao;
import com.test.web.board.dao.BoardReplyDao;
import com.test.web.common.Constants;
import com.test.web.common.Util;
import com.test.web.common.bean.PagingBean;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardReplyDao boardReplyDao;
	@Autowired
	private BoardAttachDao boardAttachDao;
	
	
	@Override
	public BoardBean selectBoard(BoardBean bean) {
		return boardDao.selectBoard(bean);
	}

	@Override
	public List<BoardReplyBean> selectBoardReplyList(PagingBean bean) 
	{
		return boardReplyDao.selectReplyList(bean);
	}

	public Map<String, Object> selectBoardReplyInfo(PagingBean pBean) 
	{
		BoardBean bb = new BoardBean( pBean.getNo(), null );
		
		BoardBean boardBean = selectBoard(bb);
		List<BoardReplyBean> list = selectBoardReplyList(pBean);
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("boardBean", boardBean);
		resMap.put("boardReplyList", list);
		
		return resMap;
	}
	
	@Override
	public int insertBoardAttach(BoardBean bBean, BoardAttachBean baBean, String upPath) {
		
		//TODO 테스트 데이터
		bBean.setMemberId("kyg");
		int resVal1 = boardDao.insertBoard(bBean);
		
		if(resVal1 <= 0) return 0; //insert실패
		
		
		for(int i=0; i<baBean.getUpFile().length; i++) {
			
			MultipartFile file = baBean.getUpFile()[i];
			String fileName = "";
			try {
				fileName = Util.uploadFileMng(file, upPath);
			} catch(Exception e) {
				e.printStackTrace();
			}
			//insert
			BoardAttachBean inBean = new BoardAttachBean();
			inBean.setBoardNo( bBean.getNo() );
			inBean.setAttachType( Constants.FILE_TYPE_BOARD );
			inBean.setFileName( fileName );
			//DB
			boardAttachDao.insertBoardAttach(inBean);
		}
		
		return resVal1;
	}
	
}
