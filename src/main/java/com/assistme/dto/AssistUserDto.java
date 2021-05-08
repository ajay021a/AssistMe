package com.assistme.dto;

import java.util.Date;
import java.util.List;

public class AssistUserDto {

	private Integer id;
	private String userName;
	private String phoneNum;
	private String email;
	private String fullName;
	private String loginIp;
	private Date lastLoginDt;
	private String lastLoginPin;
	private String deviceId;
	private Boolean activeFlg;
	private List<UserRolesDto> userRoles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public String getLastLoginPin() {
		return lastLoginPin;
	}

	public void setLastLoginPin(String lastLoginPin) {
		this.lastLoginPin = lastLoginPin;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Boolean getActiveFlg() {
		return activeFlg;
	}

	public void setActiveFlg(Boolean activeFlg) {
		this.activeFlg = activeFlg;
	}

	public List<UserRolesDto> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRolesDto> userRoles) {
		this.userRoles = userRoles;
	}

}
