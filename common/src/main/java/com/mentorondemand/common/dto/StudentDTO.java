package com.mentorondemand.common.dto;

import java.math.BigDecimal;

public class StudentDTO {
	
	private String userName;
	private BigDecimal ratings;
	private String approvalStatus;
	private Integer mentorTrainingId;
	
	
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public BigDecimal getRatings() {
		return ratings;
	}
	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
	}
	
	public Integer getMentorTrainingId() {
		return mentorTrainingId;
	}
	public void setMentorTrainingId(Integer mentorTrainingId) {
		this.mentorTrainingId = mentorTrainingId;
	}
	@Override
	public String toString() {
		return "StudentDTO [userName=" + userName + ", ratings=" + ratings + ", approvalStatus=" + approvalStatus
				+ ", mentorTrainingId=" + mentorTrainingId + "]";
	}
	
	

}
