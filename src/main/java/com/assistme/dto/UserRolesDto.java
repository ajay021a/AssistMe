package com.assistme.dto;

public class UserRolesDto {
	private Integer id;
	private String roleName;
	private String comments;

	public UserRolesDto() {
		super();
	}

	public UserRolesDto(Integer id, String roleName, String comments) {
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
