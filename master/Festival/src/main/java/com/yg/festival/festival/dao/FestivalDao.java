package com.yg.festival.festival.dao;

import java.util.List;

import com.yg.festival.common.bean.PagingBean;
import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;

public interface FestivalDao {
	// 메인 축제정보 전체 불러오기
	public List<FestivalBean> selectFestivalList(PagingBean pBean);
	// 기본 축제정보 전체 불러오기
	public List<FestivalBasicBean> selectFestivalBasicList(FestivalBasicBean fBBean);
	
	
	// 메인 축제정보 한건 불러오기
	public FestivalBean selectFestival(FestivalBean fBean);
	// 메인 축제정보 전체 갯수 
	public int selectFestivalCount();
	// 기본 축제정보 한건 불러오기
	public FestivalBasicBean selectFestivalBasic(FestivalBean fBean);
	
	
	// 축제 추가(FestivalBean)
	public int insertFestival(FestivalBean fBean);
	// 축제 추가(FestivalBasicBean)
	public int insertFestivalBasic(FestivalBasicBean fBBean);
	// 축제 추가(FestivalFileBean)
	public int insertFestivalFile(FestivalFileBean fFBean);
	
	// 축제 변경(FestivalBean)
	public int updateFestival(FestivalBean fBean);
	// 축제 변경(FestivalBasicBean)
	public int updateFestivalBasic(FestivalBasicBean fBBean);
	
	// 축제 삭제(FestivalBean)
	public int deleteFestival(FestivalBean fBean);
	// 축제 삭제(FestivalBasicBean)
	public int deleteFestivalBasic(FestivalBasicBean fBBean);

} // end of interface
