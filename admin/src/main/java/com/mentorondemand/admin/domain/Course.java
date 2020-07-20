package com.mentorondemand.admin.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	private Integer id;
	private String courseName;
	private Integer skillId;
	private Integer batchId;
	private BigDecimal studentFee;
	private BigDecimal mentorShare;
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", skillId=" + skillId + ", batchId=" + batchId
				+ ", studentFee=" + studentFee + ", mentorShare=" + mentorShare + "]";
	}
	
	
}
