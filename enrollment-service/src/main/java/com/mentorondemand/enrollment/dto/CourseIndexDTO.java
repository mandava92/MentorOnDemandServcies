package com.mentorondemand.enrollment.dto;


public class CourseIndexDTO {
	private String courseId;
	
	private TrainingEnrollmentDTO trainee;
	
	
	
	public TrainingEnrollmentDTO getTrainee() {
		return trainee;
	}

	public void setTrainee(TrainingEnrollmentDTO trainee) {
		this.trainee = trainee;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String couseId) {
		this.courseId = couseId;
	}

}

