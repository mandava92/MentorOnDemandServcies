package com.mentorondemand.mentor.dto;

import java.math.BigDecimal;

public class MentorTrainingDTO {
	
	private Integer id;
	private Integer userId;
	private Integer courseId;
	private BigDecimal ratings;
	private String courseStatus;
	private String courseName;
	private String batchName;
	private BigDecimal mentorAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public BigDecimal getMentorAmount() {
		return mentorAmount;
	}
	public void setMentorAmount(BigDecimal mentorAmount) {
		this.mentorAmount = mentorAmount;
	}
	@Override
	public String toString() {
		return "MentorTrainingDTO [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", ratings=" + ratings
				+ ", courseStatus=" + courseStatus + "]";
	}
	
	
}
