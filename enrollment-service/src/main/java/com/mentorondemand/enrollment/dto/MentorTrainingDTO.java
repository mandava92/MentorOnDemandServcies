package com.mentorondemand.enrollment.dto;

public class MentorTrainingDTO {
	
	
	private String userName;
	private Integer courseId;
	
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
	@Override
	public String toString() {
		return "MentorTrainingDTO [userName=" + userName + ", courseId=" + courseId + "]";
	}
	
	
	
}
