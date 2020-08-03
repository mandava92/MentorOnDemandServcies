package com.mentorondemand.common.dto;

import java.math.BigDecimal;
import java.util.List;

public class CourseIndexDTO {
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
	private List<StudentDTO> trainees;
	private String courseStatus;
	private BigDecimal courseRating;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String couseId) {
		this.courseId = couseId;
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

	public List<StudentDTO> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<StudentDTO> trainees) {
		this.trainees = trainees;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	
	public BigDecimal getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(BigDecimal courseRating) {
		this.courseRating = courseRating;
	}

	@Override
	public String toString() {
		return "CourseIndexDTO [courseId=" + courseId + ", documentVersion=" + documentVersion + ", courseName="
				+ courseName + ", skillId=" + skillId + ", batchId=" + batchId + ", studentFee=" + studentFee
				+ ", mentorShare=" + mentorShare + ", batchName=" + batchName + ", skillName=" + skillName
				+ ", userName=" + userName + ", mentorName=" + mentorName + ", mentorImage=" + mentorImage
				+ ", trainees=" + trainees + ", courseStatus=" + courseStatus + ", courseRating=" + courseRating + "]";
	}

	
}
