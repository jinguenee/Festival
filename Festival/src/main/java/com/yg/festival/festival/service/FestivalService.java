package com.yg.festival.festival.service;

import java.util.List;

import com.yg.festival.common.bean.PagingBean;
import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;

public interface FestivalService {
	// 메인 축제정보 전체 불러오기
	public List<FestivalBean> selectFestivalList(PagingBean pBean) throws Exception;
	// 기본 축제정보 전체 불러오기
	public List<FestivalBasicBean> selectFestivalBasicList(FestivalBasicBean fBBean) throws Exception;
	// 파일 축제정보 전체 불러오기
	public List<FestivalFileBean> selectFestivalFileList(FestivalFileBean fFBean) throws Exception;
	
	// 메인 축제정보 전체 갯수
	public int selectFestivalCount() throws Exception;
	
	// 메인 축제정보 한건 불러오기
	public FestivalBean selectFestival(FestivalBean fBean) throws Exception;
	// 기본 축제정보 한건 불러오기
	public FestivalBasicBean selectFestivalBasic(FestivalBean fBean) throws Exception;
	// 파일 축제정보 한건 불러오기
	public List<FestivalFileBean> selectFestivalFile(FestivalBean fBean) throws Exception;
	
	// 축제 추가(FestivalBean)
	public int insertFestival(FestivalBean fBean) throws Exception;
	// 축제 추가(FestivalBasicBean)
	public int insertFestivalBasic(FestivalBasicBean fBBean) throws Exception;
	// 축제 추가(FestivalFileBean)
	public int insertFestivalFile(FestivalFileBean fFBean) throws Exception;
	
	// 축제 변경(FestivalBean)
	public int updateFestival(FestivalBean fBean) throws Exception;
	// 축제 변경(FestivalBasicBean)
	public int updateFestivalBasic(FestivalBasicBean fBBean) throws Exception;
	// 축제 변경(FestivalFileBean)
	public int updateFestivalFile(FestivalFileBean fFBean) throws Exception;
	
	// 축제 삭제(FestivalBean)
	public int deleteFestival(FestivalBean fBean) throws Exception;
	// 축제 삭제(FestivalBasicBean)
	public int deleteFestivalBasic(FestivalBasicBean fBBean) throws Exception;
	// 축제 삭제(FestivalFileBean)
	public int deleteFestivalFile(FestivalFileBean fFBean) throws Exception;
	
	
} // end of interface
