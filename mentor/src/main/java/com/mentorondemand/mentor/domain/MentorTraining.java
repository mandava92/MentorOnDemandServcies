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
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "course_id")
	private Integer courseId;
	
	@Column(name = "status")
	private String courseStatus;
	
	@Column(name= "ratings")
	private BigDecimal ratings;
	
	@Column(name = "amount")
	private BigDecimal amount;

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
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MentorTraining [id=" + id + ", version=" + version + ", userName=" + userName + ", courseId=" + courseId
				+ ", courseStatus=" + courseStatus + ", ratings=" + ratings + "]";
	}
	
	
	
	

}
