package com.mentorondemand.mentor.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "mentor_training")
public class MentorTraining {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Integer version;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "course_id")
	private Integer courseId;
	
	@Column(name = "status")
	private String courseStatus;
	
	@Column(name= "ratings")
	private BigDecimal ratings;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public BigDecimal getRatings() {
		return ratings;
	}

	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "MentorTraining [id=" + id + ", version=" + version + ", userId=" + userId + ", courseId=" + courseId
				+ ", courseStatus=" + courseStatus + ", ratings=" + ratings + "]";
	}
	
	
	
	

}
