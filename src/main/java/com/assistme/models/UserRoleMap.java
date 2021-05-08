package com.assistme.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE_MAP")
public class UserRoleMap implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ROLE_MAP_ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ASSIST_USER_ID")
	private AssistUser assistUser;

	@ManyToOne
	@JoinColumn(name = "USER_ROLES_ID")
	private UserRoles userRoles;

	public UserRoleMap() {

	}

	public UserRoleMap(Integer id, AssistUser assistUser, UserRoles userRoles) {
		super();
		this.id = id;
		this.assistUser = assistUser;
		this.userRoles = userRoles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AssistUser getAssistUser() {
		return assistUser;
	}

	public void setAssistUser(AssistUser assistUser) {
		this.assistUser = assistUser;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

}
