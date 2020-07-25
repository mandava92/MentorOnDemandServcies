package com.lti.mod.searchservice.dto;

import java.math.BigDecimal;
import java.util.List;

import io.searchbox.annotations.JestId;
import io.searchbox.annotations.JestVersion;

public class CourseIndexDTO {
	@JestId
	private String couseId;

	@JestVersion
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
	private List<StudentTrainingDTO> trainees;
	private String courseApprovalStatus;
	
	
	
	public String getCourseApprovalStatus() {
		return courseApprovalStatus;
	}
	public void setCourseApprovalStatus(String courseApprovalStatus) {
		this.courseApprovalStatus = courseApprovalStatus;
	}
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
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
	public List<StudentTrainingDTO> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<StudentTrainingDTO> trainees) {
		this.trainees = trainees;
	}
	@Override
	public String toString() {
		return "CourseIndexDTO [couseId=" + couseId + ", documentVersion=" + documentVersion + ", courseName="
				+ courseName + ", skillId=" + skillId + ", batchId=" + batchId + ", studentFee=" + studentFee
				+ ", mentorShare=" + mentorShare + ", batchName=" + batchName + ", skillName=" + skillName
				+ ", userName=" + userName + ", mentorName=" + mentorName + ", mentorImage=" + mentorImage
				+ ", trainees=" + trainees + "]";
	}
	
	
	
	
}
