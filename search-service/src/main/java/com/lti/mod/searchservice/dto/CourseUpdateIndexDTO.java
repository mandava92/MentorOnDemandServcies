package com.lti.mod.searchservice.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import io.searchbox.annotations.JestId;
import io.searchbox.annotations.JestVersion;

public class CourseUpdateIndexDTO {
	private String courseId;
	private Long documentVersion;
	private String courseName;
	private Integer skillId;
	private Integer batchId;
	private BigDecimal studentFee;
	private BigDecimal mentorShare;
	private String batchName;
	private String skillName;
	private String userName;
	private String mentorName;
	private String mentorImage;
	private TrainingEnrollmentDTO trainee;
	private String courseStatus;

	

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Long getDocumentVersion() {
		return documentVersion;
	}

	public void setDocumentVersion(Long documentVersion) {
		this.documentVersion = documentVersion;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public BigDecimal getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(BigDecimal studentFee) {
		this.studentFee = studentFee;
	}

	public BigDecimal getMentorShare() {
		return mentorShare;
	}

	public void setMentorShare(BigDecimal mentorShare) {
		this.mentorShare = mentorShare;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getMentorImage() {
		return mentorImage;
	}

	public void setMentorImage(String mentorImage) {
		this.mentorImage = mentorImage;
	}

	
	public TrainingEnrollmentDTO getTrainee() {
		return trainee;
	}

	public void setTrainee(TrainingEnrollmentDTO trainees) {
		this.trainee = trainees;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	

}
