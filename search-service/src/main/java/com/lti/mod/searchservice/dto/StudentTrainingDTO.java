package com.lti.mod.searchservice.dto;

import java.math.BigDecimal;

public class StudentTrainingDTO {
	
	private Integer userId;
	private Integer mentorTrainingId;
	private BigDecimal ratings;
	private String approvalStatus;
	
	
	
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
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
	
	
	

}
