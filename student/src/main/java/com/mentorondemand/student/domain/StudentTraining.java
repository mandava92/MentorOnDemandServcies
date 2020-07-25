package com.mentorondemand.student.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Student_training")
public class StudentTraining {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Version
	private Integer version;
	
	@Column(name= "mentor_training_id")
	private Integer mentorTrainingId;
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "rating")
	private BigDecimal rating;
	
	@Column(name="approval_status")
	private String courseApprovalStatus;

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

	public Integer getMentorTrainingId() {
		return mentorTrainingId;
	}

	public void setMentorTrainingId(Integer mentorTrainingId) {
		this.mentorTrainingId = mentorTrainingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getCourseApprovalStatus() {
		return courseApprovalStatus;
	}

	public void setCourseApprovalStatus(String courseApprovalStatus) {
		this.courseApprovalStatus = courseApprovalStatus;
	}

	@Override
	public String toString() {
		return "StudentTraining [id=" + id + ", version=" + version + ", mentorTrainingId=" + mentorTrainingId
				+ ", userName=" + userName + ", rating=" + rating + ", courseApprovalStatus=" + courseApprovalStatus
				+ "]";
	}
	
	

}
