package com.yg.festival.festival.bean;

public class FestivalReplyBean {
	private String fr_no; // 축제 댓글 고유번호 
	private String fr_content; // 축제 댓글 내용
	private String fr_starpoint; // 축제 댓글 별점
	private String fr_date; // 축제 댓글 생성날짜
	// festival_no : 축제 메인 고유번호(FK)
	// member_no : 회원아이디(FK)
	
	public String getFr_no() {
		return fr_no;
	}
	public void setFr_no(String fr_no) {
		this.fr_no = fr_no;
	}
	public String getFr_content() {
		return fr_content;
	}
	public void setFr_content(String fr_content) {
		this.fr_content = fr_content;
	}
	public String getFr_starpoint() {
		return fr_starpoint;
	}
	public void setFr_starpoint(String fr_starpoint) {
		this.fr_starpoint = fr_starpoint;
	}
	public String getFr_date() {
		return fr_date;
	}
	public void setFr_date(String fr_date) {
		this.fr_date = fr_date;
	}
} // end of class
