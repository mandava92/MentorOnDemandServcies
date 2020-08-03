package com.mentorondemand.training.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Version
	private Long version;
	private String courseName;
	private Integer skillId;
	private Integer batchId;
	private BigDecimal studentFee;
	private BigDecimal mentorShare;
	private String courseStatus;
	private String userName;
	
	
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", version=" + version + ", courseName=" + courseName + ", skillId=" + skillId
				+ ", batchId=" + batchId + ", studentFee=" + studentFee + ", mentorShare=" + mentorShare + "]";
	}
	
	
}
