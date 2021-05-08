package com.assistme.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ASSIST_USER", uniqueConstraints = { @UniqueConstraint(columnNames = "USER_NAME"),
		@UniqueConstraint(columnNames = "EMAIL"), @UniqueConstraint(columnNames = "PHONE_NUM") })
public class AssistUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASSIST_USER_ID")
	private Integer id;

	@NotBlank
	@Column(name = "USER_NAME")
	@Size(max = 100)
	private String userName;

	@NotBlank
	@Column(name = "PHONE_NUM")
	@Size(max = 50)
	private String phoneNum;

	@Column(name = "EMAIL")
	@Size(max = 100)
	private String email;

	@Column(name = "FULL_NAME")
	@Size(max = 200)
	private String fullName;

	@Column(name = "LOGIN_IP")
	@Size(max = 100)
	private String loginIp;

	@NotBlank
	@Column(name = "LAST_LOGIN_DT")
	private Date lastLoginDt;

	@Column(name = "LAST_LOGIN_PIN")
	@Size(max = 10)
	private String lastLoginPin;

	@NotBlank
	@Column(name = "DEVICE_ID")
	private String deviceId;

	@NotBlank
	@Column(name = "ACTIVE_FLG")
	private Boolean activeFlg;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ROLE_MAP_ID")
	private Set<UserRoleMap> userRoleMaps = new HashSet<UserRoleMap>(0);

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Set<Address> addresses = new HashSet<Address>(0);

	public AssistUser() {

	}

	public AssistUser(Integer id, @NotBlank @Size(max = 100) String userName, @NotBlank @Size(max = 50) String phoneNum,
			@Size(max = 100) String email, @Size(max = 200) String fullName, @NotBlank @Size(max = 100) String loginIp,
			@NotBlank Date lastLoginDt, @NotBlank @Size(max = 10) String lastLoginPin, @NotBlank String deviceId,
			@NotBlank Boolean activeFlg, Set<UserRoleMap> userRoleMaps, Set<Address> addresses) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.fullName = fullName;
		this.loginIp = loginIp;
		this.lastLoginDt = lastLoginDt;
		this.lastLoginPin = lastLoginPin;
		this.deviceId = deviceId;
		this.activeFlg = activeFlg;
		this.userRoleMaps = userRoleMaps;
		this.addresses = addresses;
	}

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

	public Set<UserRoleMap> getUserRoleMaps() {
		return userRoleMaps;
	}

	public void setUserRoleMaps(Set<UserRoleMap> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
