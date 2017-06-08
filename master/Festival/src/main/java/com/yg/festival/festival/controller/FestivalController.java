package com.yg.festival.festival.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yg.festival.common.Constants;
import com.yg.festival.common.bean.PagingBean;
import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;
import com.yg.festival.festival.service.FestivalService;
import com.yg.festival.member.bean.MemberBean;
import com.yg.festival.member.dao.MemberDao;

@Controller
public class FestivalController {
	
	@Autowired
	private FestivalService festivalService;
	@Autowired
	private MemberDao memberDao;
	
	// 축제 메인페이지 이동
	@RequestMapping("/festival/festival_main")
	public String festival_main(Model model) {
		
//		// db에 임시로 생성한 jjk 사용자 아이디를 불러와서 model로 담는다
//		MemberBean mBean = new MemberBean();
//		mBean.setMember_id("jjk");
//		MemberBean dbMBean = memberDao.selectMember(mBean); // db 데이터 가져오기
//		
//		model.addAttribute("memberBean", dbMBean);
		
		return "/festival/festival_main";
	}
	// 축제 메인페이지 - 출력정보 처리
	@RequestMapping("/festival/festival_main_Proc")
	@ResponseBody
	public Map<String, Object> festival_main_Proc(FestivalBean fBean, PagingBean pBean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 실패!");
		
		try {
			int totalCount = festivalService.selectFestivalCount();
//			pBean.setTotal_Record(totalCount);
			
			List<FestivalBean> dbFListBean = festivalService.selectFestivalList(pBean);
			
			resMap.put(Constants.RESULT, Constants.RESULT_OK);
			resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 성공!");
			
			resMap.put("fListBean", dbFListBean);
			resMap.put("pBean", pBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	// 축제 상세페이지 이동
	@RequestMapping("/festival/festival_view")
	public String festival_view() {
		return "/festival/festival_view";
	}
	
	
	// 관리자 - 신규 축제 추가 페이지 이동
	@RequestMapping("/festival/master_insertFestival")
	public String master_insertFestival() {
		return "/festival/master_insertFestival";
	}
	// 관리자 - 신규 축제 추가 처리
	@RequestMapping("/festival/master_insertFestival_Proc")
	@ResponseBody
	public Map<String, Object> master_insertFestival_Proc(FestivalBean fBean, FestivalBasicBean fBBean, FestivalFileBean fFBean, HttpServletRequest req) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 추가하기 실패!!");
		
		try {
			// 신규 축제 메인정보 DB추가
			int resfBean = festivalService.insertFestival(fBean);
			
			// festival_no를 가져오기위해 저장된 축제 메인정보 DB리스트 불러오기
			List<FestivalBean> tempList = festivalService.selectFestivalList(null);
			
			// 신규축제 추가 페이지 -> 축제정보 보기 페이지 이동할때, 넘길 축제메인정보
			FestivalBean dbFBean = tempList.get(0);
			
			// festival_no를 FestivalBasicBean 에 저장하기
			fBBean.setFestival_no(tempList.get(0).getFestival_no());
			
			// 축제 기본정보 DB추가
			int resfBBean = festivalService.insertFestivalBasic(fBBean);
			
			
			// 축제 파일 DB추가
			
			
			System.out.println(resfBean + "," + resfBBean);
			
			if (resfBean > 0 && resfBBean > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "축제가 성공적으로 추가되었습니다.");
				resMap.put("fBean", dbFBean);
				req.getSession().setAttribute("sfBean", dbFBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	//파일 업로드 저장경로
//C:/DEV/WORKS/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/Festival
//	@Value("#{config['file.upload.path']}")
//	private String FILE_UPLOAD_PATH;
	
	// 축제 파일 test용
//	@RequestMapping("/festival/insertFileProc")
//	@ResponseBody
//	public Map<String, Object> insertFileProc(FestivalFileBean fFBean) {
//		Map<String, Object> resMap = new HashMap<String, Object>();
//		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
//		resMap.put(Constants.RESULT_MSG, "파일 업로드 실패!");
//		
//		String realPath = FILE_UPLOAD_PATH + "/uploadFile";
//		File realFolder = new File(realPath);
//		if (!realFolder.exists()) {
//			realFolder.mkdirs();
//		}
//		
//		for (int i = 0; i < fFBean.getUpFile().length; i++) {
//			MultipartFile file = fFBean.getUpFile()[i];
//			String fileName = "";
//			
//			
//			try {
//				
////				festivalService.insertFestivalFile(fFBean);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return resMap;
//	}
	
	// 관리자 - 축제 전체 정보 앵귤러 처리
	@RequestMapping("/festival/master_selectFestivalListProc")
	@ResponseBody
	public Map<String, Object> master_selectFestivalListProc(FestivalBean fBean, FestivalBasicBean fBBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 실패!");
		
		try {
			List<FestivalBean> fBeanList = festivalService.selectFestivalList(null);
			List<FestivalBasicBean> fBBeanList = festivalService.selectFestivalBasicList(null);
			
			resMap.put(Constants.RESULT, Constants.RESULT_OK);
			resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 성공!!");
			resMap.put("fBeanList", fBeanList);
			resMap.put("fBBeanList", fBBeanList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	// 관리자 - 축제 한건 정보 페이지 이동
	@RequestMapping("/festival/master_selectFestival")
	public String master_selectFestival(FestivalBean fBean, Model model) {
		
		try {
			FestivalBean dbFbean = festivalService.selectFestival(fBean);
			FestivalBasicBean dbFBbean = festivalService.selectFestivalBasic(fBean);
			
			model.addAttribute("fBean", dbFbean);
			model.addAttribute("fbBean", dbFBbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/festival/master_selectFestival";
	}
	// 관리자 - 축제 정보 변경 페이지 이동
	@RequestMapping("/festival/master_updateFestival")
	public String master_updateFestival(FestivalBean fBean, Model model) {
		
		try {
			FestivalBean dbFbean = festivalService.selectFestival(fBean);
			FestivalBasicBean dbFBbean = festivalService.selectFestivalBasic(fBean);
			
			model.addAttribute("fBean", dbFbean);
			model.addAttribute("fbBean", dbFBbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/festival/master_updateFestival";
	}
	// 관리자 - 축제 정보 변경 페이지 처리
	@RequestMapping("/festival/master_updateFestivalProc")
	@ResponseBody
	public Map<String, Object> master_updateFestivalProc(FestivalBean fBean, FestivalBasicBean fBBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 변경하기 실패!!");
		
		try {
			
			int res = festivalService.updateFestival(fBean);
			int res2 = festivalService.updateFestivalBasic(fBBean);
			
			if (res > 0 && res2 > 0) {
				
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "축제 변경에 성공하셨습니다.");
				
				resMap.put("fBean", fBean);
				resMap.put("fBBean", fBBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	// 관리자 - 축제 관리 페이지 이동
	@RequestMapping("/festival/master_managerFestival")
	public String master_managerFestival() {
		return "/festival/master_managerFestival";
	}
	// 관리자 - 축제 삭제 처리
	@RequestMapping("/festival/master_deleteFestivalProc")
	@ResponseBody
	public Map<String, Object> master_deleteFestivalProc(FestivalBean fBean, FestivalBasicBean fBBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 삭제하기 실패!!");
		
		try {
			int res2 = festivalService.deleteFestivalBasic(fBBean); // 기본정보 먼저 삭제한다.
			int res = festivalService.deleteFestival(fBean); // 그 다음에 메인정보 삭젠
			
			if (res > 0 && res2 > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "축제가 성공적으로 삭제되었습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
} // end of controller