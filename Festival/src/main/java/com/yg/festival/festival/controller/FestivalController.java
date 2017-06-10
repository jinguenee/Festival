package com.yg.festival.festival.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yg.festival.common.Constants;
import com.yg.festival.common.bean.PagingBean;
import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;
import com.yg.festival.festival.dao.FestivalDao;
import com.yg.festival.festival.service.FestivalService;
import com.yg.festival.member.dao.MemberDao;

@Controller
public class FestivalController {
	
	// 파일 업로드 저장경로
	//  file.upload.main.path = C:/DEV/WORKS/Festival/webapp/images/festival_main
	@Value("#{config['file.upload.main.path']}")
	private String FILE_UPLOAD_MAIN_PATH;
		
	@Autowired
	private FestivalDao festivalDao;
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
	
	/** 검색 페이지 화면 **/
	@RequestMapping("/board/searchView")
	public String searchView(Model model, PagingBean pBean) {
		
		//전체 레코드 갯수 취득
		int totRecord = festivalDao.selectBoardListTotalCount(pBean);
		//페이징 계산
		pBean.calcPage(totRecord);
		
		List<FestivalBean> list = festivalDao.selectBoardList(pBean);
		model.addAttribute("searchView", list);
		model.addAttribute("pBean", pBean);
		return "/board/searchView";
	}
	
	// 축제 메인페이지 - 출력정보 처리
	@RequestMapping("/festival/festival_main_Proc")
	@ResponseBody
	public Map<String, Object> festival_main_Proc(FestivalBean fBean, PagingBean pBean) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 실패!");
		
		try {
//			int totalCount = festivalService.selectFestivalCount();
//			pBean.setTotal_Record(totalCount);
			
			List<FestivalBean> dbFListBean = festivalService.selectFestivalList(null); // 전체 축제메인정보
			List<FestivalFileBean> dbFFListBean = festivalService.selectFestivalFileList(null); // 전체 추제파일정보
			
			for (int i = 0; i < dbFFListBean.size(); i++) {
				if (dbFFListBean.get(i).getFf_titleimage() != null) { // 타이틀이미지가 있다면
					String ff_titleimage = dbFFListBean.get(i).getFf_titleimage();
					
					for (int j = 0; j < dbFListBean.size(); j++) { 
						if (dbFFListBean.get(i).getFestival_no().equals(dbFListBean.get(j).getFestival_no())) { // 같은 축제번호일때
							dbFListBean.get(j).setFf_titleimage(ff_titleimage);
							break;
						}
					} // end of for
				}
			} // end of for
			
			resMap.put(Constants.RESULT, Constants.RESULT_OK);
			resMap.put(Constants.RESULT_MSG, "축제 정보 불러오기 성공!");
			
			resMap.put("fListBean", dbFListBean);
			resMap.put("ffListBean", dbFFListBean);
			
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
			int resfFBean = insertFile(dbFBean, fBBean, fFBean);
			
			System.out.println(resfBean + "," + resfBBean + "," + resfFBean);
			
			if (resfBean > 0 && resfBBean > 0 && resfFBean > 0) {
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
	// 파일 
	public int insertFile(FestivalBean fBean, FestivalBasicBean fBBean, FestivalFileBean fFBean) {
		
		String realPath = FILE_UPLOAD_MAIN_PATH + "/images/festival_main/" + fBean.getThema1() + "/" + fBean.getFestival_no(); // 폴더트리 생성
		File realFolder = new File(realPath);
		if (!realFolder.exists()) {
			realFolder.mkdirs();
		}
		
		int res = 0;
		for (int i = 0; i < fFBean.getUpFile().length; i++) {
			MultipartFile file = fFBean.getUpFile()[i];
			
			String ff_originName = file.getOriginalFilename(); // 원래 파일이름
			String ff_size = file.getSize() + ""; // 파일 크기
			
			// 파일명을 UUID로 생성
			String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			String fileName = UUID.randomUUID().toString() + "." + fileExt;
			String full_UUID_fileName = realPath + "/" + fileName;
			
			String[] temp = realPath.split("/");
			// /images/festival_main/(thema1)/(festival_name)/fileName
			String ff_realpath = "/" + temp[temp.length - 4] + "/" + temp[temp.length - 3] + "/" + temp[temp.length - 2]
					+ "/" + temp[temp.length - 1] + "/" + fileName;
			System.out.println(ff_realpath);
			
			
			try {
				// 파일 저장
				byte[] bytes = file.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(full_UUID_fileName));
				
				bos.write(bytes);
				bos.flush();
				bos.close();
				
				//insert
				FestivalFileBean tempfFBean = new FestivalFileBean();
				tempfFBean.setFestival_no(fBean.getFestival_no());
				tempfFBean.setFf_realpath(ff_realpath);
				tempfFBean.setFf_name(fBean.getFestival_name());
				tempfFBean.setFf_originname(ff_originName);
				tempfFBean.setFf_path(full_UUID_fileName);
				tempfFBean.setFf_size(ff_size);

				if (i == 0) { // 첫번째 사진이 title 이미지로 설정해놓는다
					tempfFBean.setFf_titleimage(ff_realpath);
				}
				//DB
				res = festivalService.insertFestivalFile(tempfFBean);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (res > 0) {
			System.out.println("파일 성공!");
			return 1;
		}
		return 0;
	} // end of insertFile()
	
	
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
			List<FestivalFileBean> dbFFBeanList = festivalService.selectFestivalFile(fBean);
			
			model.addAttribute("fBean", dbFbean);
			model.addAttribute("fbBean", dbFBbean);
			model.addAttribute("fFBeanList", dbFFBeanList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/festival/master_selectFestival";
	}
	// 관리자 - 축제 사진 추가 Proc
	@RequestMapping("/festival/master_fixTitleImageProc")
	@ResponseBody
	public Map<String, Object> master_fixTitleImageProc(FestivalBean fBean, FestivalFileBean fFBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "사진 추가 실패!");
		
		try {
			List<FestivalFileBean> dbfFBeanList = festivalService.selectFestivalFile(fBean);
			
			// 기존에 title 설정된 이미지를 null 처리한다.
			for (int i = 0; i < dbfFBeanList.size(); i++) {
				if (dbfFBeanList.get(i).getFf_titleimage() != null) {
					dbfFBeanList.get(i).setFf_titleimage(null);
					int res = festivalService.updateFestivalFile(dbfFBeanList.get(i));
					if (res > 0) {
						System.out.println("null 처리 성공!");
					}
					break;
				}
			}
			
			// 설정한 title 이미지를 리스트에서 찾아낸다.
			FestivalFileBean tempFFBean = new FestivalFileBean();
			for (int i = 0; i < dbfFBeanList.size(); i++) {
				if (fFBean.getFf_no().equals(dbfFBeanList.get(i).getFf_no())) {
					tempFFBean = dbfFBeanList.get(i);
					break;
				}
			}
			
			// title 이미지 경로설정 및 db 작업
			tempFFBean.setFf_titleimage(tempFFBean.getFf_realpath());
			int res = festivalService.updateFestivalFile(tempFFBean);
			
			if (res > 0) {
				
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "사진 추가 성공!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
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
	public Map<String, Object> master_updateFestivalProc(FestivalBean fBean, FestivalBasicBean fBBean, FestivalFileBean fFBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 변경하기 실패!!");
		
		try {
			
			int res = festivalService.updateFestival(fBean);
			int res2 = festivalService.updateFestivalBasic(fBBean);
			
			// 축제 파일 DB추가
			int res3 = insertFile(fBean, fBBean, fFBean);
			
			if (res3 > 0) {
				System.out.println("파일 추가 완료!");
			}
			
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
	public Map<String, Object> master_deleteFestivalProc(FestivalBean fBean, FestivalBasicBean fBBean, FestivalFileBean fFBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "축제 삭제하기 실패!!");
		
		try {
			
			List<FestivalFileBean> tempFFBeanList = festivalService.selectFestivalFile(fBean);
			
			int res3 = festivalService.deleteFestivalFile(fFBean); // 파일정보 먼저 삭제한다
			int res2 = festivalService.deleteFestivalBasic(fBBean); // 기본정보 삭제한다.
			int res = festivalService.deleteFestival(fBean); // 마지막으로 메인정보 삭제한다
			
			for (int i = 0; i < tempFFBeanList.size(); i++) {
				String deletePath = tempFFBeanList.get(i).getFf_path();
				
				File file = new File(deletePath);
				if(file.delete()) {
					System.out.println("삭제완료!");
				}
			}
			
			if (res > 0 && res2 > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "축제 기본, 메인정보가 성공적으로 삭제되었습니다");
			}
			if (res3 > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "전체 축제정보가 성공적으로 삭제되었습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
} // end of controller