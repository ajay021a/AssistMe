package com.assistme.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_ROLES", uniqueConstraints = { @UniqueConstraint(columnNames = "ROLE_NAME") })
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ROLES_ID")
	private Integer id;

	@NotBlank
	@Column(name = "ROLE_NAME")
	@Size(max = 100)
	private String roleName;

	@NotBlank
	@Column(name = "COMMENTS")
	@Size(max = 200)
	private String comments;

	public UserRoles() {

	}

	public UserRoles(Integer id, @NotBlank @Size(max = 100) String roleName,
			@NotBlank @Size(max = 200) String comments) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
