package com.mentorondemand.mentor.dto;

import java.math.BigDecimal;

public class MentorTrainingDTO {
	
	private Integer id;
	private String userName;
	private String mentorName;
	private Integer courseId;
	private BigDecimal ratings;
	private String courseStatus;
	private BigDecimal mentorFee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public BigDecimal getRatings() {
		return ratings;
	}
	public void setRatings(BigDecimal rating) {
		this.ratings = rating;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	
	
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public BigDecimal getMentorFee() {
		return mentorFee;
	}
	public void setMentorFee(BigDecimal mentorFee) {
		this.mentorFee = mentorFee;
	}
	

	
}
