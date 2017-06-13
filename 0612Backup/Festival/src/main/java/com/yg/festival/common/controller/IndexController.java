package com.yg.festival.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;
import com.yg.festival.festival.dao.FestivalDao;
import com.yg.festival.festival.service.FestivalService;



@Controller
public class IndexController {
	@Autowired
	private FestivalDao festivalDao;
	@Autowired
	private FestivalService festivalService;
	
	// 관리자 - 축제 한건 정보 페이지 이동
		@RequestMapping("/index")
		public String index(FestivalBean fBean, Model model) {
			
			try {
				List<FestivalFileBean> dbFFBeanList = festivalService.selectFestivalFileList(null);
				model.addAttribute("fFBeanList", dbFFBeanList);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "/index";
		}
}
