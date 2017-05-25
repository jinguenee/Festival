package com.test.web.board.bean;

public class BoardBean {

	private String no;
	private String memberId;
	private String memberName;
	private String title;
	private String content;
	private String replyTotCount;
	private String regDate;
	
	public BoardBean() {
		
	}
	public BoardBean(String no, String memberId) {
		this.no = no;
		this.memberId = memberId;
	}
	
	
	public String getReplyTotCount() {
		return replyTotCount;
	}
	public void setReplyTotCount(String replyTotCount) {
		this.replyTotCount = replyTotCount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNo() {
		return no;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
