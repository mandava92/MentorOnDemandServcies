package com.mentorondemand.user.dto;

public class UserRolesDTO {

	private Integer id;
	private Integer version;
	private Integer roleId;
	private Integer userId;
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
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserRolesDTO [id=" + id + ", version=" + version + ", roleId=" + roleId + ", userId=" + userId + "]";
	}
	
	
	
}
