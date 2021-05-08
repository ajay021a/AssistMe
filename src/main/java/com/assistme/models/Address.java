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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private String id;

	@NotBlank
	@Column(name = "ADDRESS1")
	@Size(max = 200)
	private String address1;

	@Column(name = "ADDRESS2")
	@Size(max = 200)
	private String address2;

	@Column(name = "STREET")
	@Size(max = 200)
	private String street;

	@NotBlank
	@Column(name = "LANDMARK")
	@Size(max = 200)
	private String landmark;

	@NotBlank
	@Column(name = "CITY")
	@Size(max = 200)
	private String city;

	@NotBlank
	@Column(name = "PINCODE")
	@Size(max = 10)
	private String pincode;

	@NotBlank
	@Column(name = "STATE")
	@Size(max = 100)
	private String state;

	@ManyToOne
	@JoinColumn(name = "ASSIST_USER_ID")
	private AssistUser assistUser;

	public Address() {

	}

	public Address(String id, @NotBlank @Size(max = 200) String address1, @Size(max = 200) String address2,
			@Size(max = 200) String street, @NotBlank @Size(max = 200) String landmark,
			@NotBlank @Size(max = 200) String city, @NotBlank @Size(max = 10) String pincode,
			@NotBlank @Size(max = 100) String state, AssistUser assistUser) {
		super();
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.assistUser = assistUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AssistUser getAssistUser() {
		return assistUser;
	}

	public void setAssistUser(AssistUser assistUser) {
		this.assistUser = assistUser;
	}

}
