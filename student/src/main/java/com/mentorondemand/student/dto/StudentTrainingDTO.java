package com.mentorondemand.student.dto;

import java.math.BigDecimal;

public class StudentTrainingDTO {
	
	private Integer id;
	private Integer userId;
	private Integer mentorTrainingId;
	private BigDecimal ratings;
	private String courseApprovalStatus;
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
	public Integer getMentorTrainingId() {
		return mentorTrainingId;
	}
	public void setMentorTrainingId(Integer mentorTrainingId) {
		this.mentorTrainingId = mentorTrainingId;
	}
	public BigDecimal getRatings() {
		return ratings;
	}
	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
	}
	public String getCourseApprovalStatus() {
		return courseApprovalStatus;
	}
	public void setCourseApprovalStatus(String courseApprovalStatus) {
		this.courseApprovalStatus = courseApprovalStatus;
	}
	@Override
	public String toString() {
		return "StudentTrainingDTO [id=" + id + ", userId=" + userId + ", mentorTrainingId=" + mentorTrainingId
				+ ", ratings=" + ratings + ", courseApprovalStatus=" + courseApprovalStatus + "]";
	}
	
	

}
