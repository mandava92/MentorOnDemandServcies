package com.mentorondemand.mentor.dto;

import java.math.BigDecimal;

public class MentorTrainingDTO {
	
	private Integer id;
	private Integer userId;
	private Integer courseId;
	private BigDecimal ratings;
	private String courseStatus;
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
	@Override
	public String toString() {
		return "MentorTrainingDTO [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", ratings=" + ratings
				+ ", courseStatus=" + courseStatus + "]";
	}
	
	
}
