package com.yg.festival.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yg.festival.common.bean.PagingBean;
import com.yg.festival.festival.bean.FestivalBasicBean;
import com.yg.festival.festival.bean.FestivalBean;
import com.yg.festival.festival.bean.FestivalFileBean;
import com.yg.festival.festival.dao.FestivalDao;

@Service
public class FestivalServiceImpl implements FestivalService {
	
	@Autowired
	private FestivalDao festivalDao;

	// 축제정보 전체 불러오기
	@Override
	public List<FestivalBean> selectFestivalList(PagingBean pBean) throws Exception {
		return festivalDao.selectFestivalList(pBean);
	}
	// 축제정보 한건 불러오기
	@Override
	public FestivalBean selectFestival(FestivalBean fBean) throws Exception {
		return festivalDao.selectFestival(fBean);
	}
	// 축제정보 전체 갯수 불러오기
	@Override
	public int selectFestivalCount() throws Exception {
		return festivalDao.selectFestivalCount();
	}

	// 축제 검색 / 현우
	@Override
	public List<FestivalBean> searchSelectFestivalList(FestivalBean fBean, PagingBean pBean) throws Exception {
		return festivalDao.searchSelectFestivalList(fBean, pBean);  
	}
	
	// 회원정보 전체 리스트 갯수를 가져온다. / 현우
	@Override
	public int selectFestivalListTotalCount(PagingBean pBean) throws Exception{
		return festivalDao.selectFestivalListTotalCount(pBean);
	};

	// 축제 추가하기(FestivalBean)
	@Override
	public int insertFestival(FestivalBean fBean) throws Exception {
		return festivalDao.insertFestival(fBean);
	}
	// 축제 추가하기(FestivalBasicBean)
	@Override
	public int insertFestivalBasic(FestivalBasicBean fBBean) throws Exception {
		return festivalDao.insertFestivalBasic(fBBean);
	}
	@Override
	public FestivalBasicBean selectFestivalBasic(FestivalBean fBean) throws Exception {
		return festivalDao.selectFestivalBasic(fBean);
	}
	// 축제 변경하기(FestivalBean)
	@Override
	public int updateFestival(FestivalBean fBean) throws Exception {
		return festivalDao.updateFestival(fBean);
	}
	// 축제 변경하기(FestivalBeanBasic)
	@Override
	public int updateFestivalBasic(FestivalBasicBean fBBean) throws Exception {
		return festivalDao.updateFestivalBasic(fBBean);
	}
	// 기본 축제정보 전체 불러오기
	@Override
	public List<FestivalBasicBean> selectFestivalBasicList(FestivalBasicBean fBBean) throws Exception {
		return festivalDao.selectFestivalBasicList(fBBean);
	}
	// 축제 삭제하기(FestivalBean)
	@Override
	public int deleteFestival(FestivalBean fBean) throws Exception {
		return festivalDao.deleteFestival(fBean);
	}
	// 축제 삭제하기(FestivalBasicBean)
	@Override
	public int deleteFestivalBasic(FestivalBasicBean fBBean) throws Exception {
		return festivalDao.deleteFestivalBasic(fBBean);
	}
	@Override
	public int insertFestivalFile(FestivalFileBean fFBean) throws Exception {
		return festivalDao.insertFestivalFile(fFBean);
	}
	@Override
	public int deleteFestivalFile(FestivalFileBean fFBean) throws Exception {
		return festivalDao.deleteFestivalFile(fFBean);
	}
	@Override
	public List<FestivalFileBean> selectFestivalFile(FestivalBean fBean) throws Exception {
		return festivalDao.selectFestivalFile(fBean);
	}
	@Override
	public int updateFestivalFile(FestivalFileBean fFBean) throws Exception {
		return festivalDao.updateFestivalFile(fFBean);
	}
	@Override
	public List<FestivalFileBean> selectFestivalFileList(FestivalFileBean fFBean) throws Exception {
		return festivalDao.selectFestivalFileList(fFBean);
	}
} // end of class 
