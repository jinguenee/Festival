package com.yg.festival.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yg.festival.board.bean.BoardBean;
import com.yg.festival.board.bean.BoardFileBean;
import com.yg.festival.board.dao.BoardDao;
import com.yg.festival.board.service.BoardService;
import com.yg.festival.common.Constants;
import com.yg.festival.common.bean.PagingBean;


@Controller
public class BoardController {

	//파일 업로드 저장경로
	@Value("#{config['file.upload.path']}")
	private String FILE_UPLOAD_PATH;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDao boardDao;
	
	/** Index **/
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
		
	/** 게시판 View 화면 **/
	@RequestMapping("/board/noticeView")
	public String noticeView(Model model, BoardBean bBean) {
		
		BoardBean tempBean = boardService.selectBoard(bBean);
		
		int tempBeanJoin = boardService.updateBoardJoin(bBean);
		
		model.addAttribute("boardList",tempBean);
		model.addAttribute("tempBeanJoin", tempBeanJoin);
		
		return "/board/noticeView";
	}
	

	/** 게시판 View AJAX **/
	@RequestMapping("/board/noticeViewAjax") 
	@ResponseBody
	public Map<String, Object> noticeViewAjax(BoardBean bean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "게시글 상세보기 실패");
		
		
		BoardBean bBean =  boardService.selectBoard(bean);
		
		resMap.put(Constants.RESULT, Constants.RESULT_OK);
		resMap.put(Constants.RESULT_MSG, "게시글 상세보기 성공");
		resMap.put("bBean", bBean); // 게시글 저장
		
		return resMap;
	}

	/** 게시판 List 화면**/
	@RequestMapping("/board/noticeList")
	public String noticeList(Model model, BoardBean bBean) {
		
		List<BoardBean> list = boardService.selectBoardInfo(bBean);
		
		model.addAttribute("boardList", list);
		
		return "/board/noticeList";
	}
	
	/** 게시판 쓰기 화면 **/
	@RequestMapping("/board/noticeWrite") 
		public String noticeWrite() {
			return "/board/noticeWrite";
	}
	

	
	/** 게시판 쓰기 AJAX **/
	@RequestMapping("/board/noticeWriteAjax")
	@ResponseBody
	public Map<String, Object> noticeWriteAjax(BoardBean bBean, BoardFileBean bfBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "게시글 작성 실패");
		
		
		try {
			int res = boardService.insertBoardFile(bBean, bfBean, FILE_UPLOAD_PATH + "/upfile");
//			int res = boardService.insertBoard(bBean);

			List<BoardBean> LbBean = boardService.selectBoardInfo(bBean);

			BoardBean LbBeanIndex = LbBean.get(LbBean.size()-1);

			if(res > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "게시글 작성 성공");
				resMap.put("LbBean", LbBeanIndex); // 게시글 저장
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	
	/** 게시판 글쓰기 수정 화면 **/
	@RequestMapping("/board/noticeUpdate") 
	public String noticeUpdate(BoardBean bBean, Model model) {

		BoardBean tempBean =  boardService.selectBoard(bBean);

		model.addAttribute("boardList", tempBean);

		return "/board/noticeUpdate";
	}
	/** 게시판 글쓰기 수정 AJAX **/
	@RequestMapping("/board/noticeUpdateAjax")
	@ResponseBody
	public Map<String, Object> noticeUpdateAjax(BoardBean bBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "게시글 수정 실패");

		try {
			
			int res = boardService.updateBoard(bBean);
			
			if(res > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "게시글 수정 성공");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	/** 검색 페이지 화면 **/
	@RequestMapping("/board/searchView")
	public String searchView(Model model, PagingBean pBean) {
		
		//전체 레코드 갯수 취득
		int totRecord = boardDao.selectBoardListTotalCount(pBean);
		//페이징 계산
		pBean.calcPage(totRecord);
		
		List<BoardBean> list = boardDao.selectBoardList(pBean);
		model.addAttribute("searchView", list);
		model.addAttribute("pBean", pBean);
		return "/board/searchView";
	}
}
