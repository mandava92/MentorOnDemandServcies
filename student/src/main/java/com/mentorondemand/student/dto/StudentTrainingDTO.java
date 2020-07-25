package com.mentorondemand.student.dto;

import java.math.BigDecimal;

public class StudentTrainingDTO {
	
	private String userName;
	private Integer mentorTrainingId;
	private BigDecimal ratings;
	private String approvalStatus;
	
	
	
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
	@Override
	public String toString() {
		return "StudentTrainingDTO [userName=" + userName + ", mentorTrainingId=" + mentorTrainingId + ", ratings="
				+ ratings + ", approvalStatus=" + approvalStatus + "]";
	}
	
	
	
	
	
	

}
