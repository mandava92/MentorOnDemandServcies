package com.lti.mod.searchservice.dto;

import java.math.BigDecimal;

public class TrainingEnrollmentDTO {
	private String userName;
	private Integer courseId;
	private BigDecimal ratings;
	private String courseApprovalStatus;
	private Integer version;
	private Integer id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	
	public String getCourseApprovalStatus() {
		return courseApprovalStatus;
	}
	public void setCourseApprovalStatus(String courseApprovalStatus) {
		this.courseApprovalStatus = courseApprovalStatus;
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
	@Override
	public String toString() {
		return "TrainingEnrollmentDTO [userName=" + userName + ", courseId=" + courseId + ", ratings=" + ratings
				+ ", courseApprovalStatus=" + courseApprovalStatus + ", version=" + version + "]";
	}
	
	
	
	
	
	

}


