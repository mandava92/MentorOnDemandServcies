package com.mentorondemand.mentor.dto;

import java.math.BigDecimal;

public class MentorTrainingDTO {
	
	private Integer id;
	private String userName;
	private Integer courseId;
	private BigDecimal ratings;
	private String courseStatus;
	private String courseName;
	private String batchName;
	private BigDecimal amount;
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
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal mentorAmount) {
		this.amount = mentorAmount;
	}
	@Override
	public String toString() {
		return "MentorTrainingDTO [id=" + id + ", userName=" + userName + ", courseId=" + courseId + ", ratings="
				+ ratings + ", courseStatus=" + courseStatus + ", courseName=" + courseName + ", batchName=" + batchName
				+ ", amount=" + amount + "]";
	}
	
	
}
