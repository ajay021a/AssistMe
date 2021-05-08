package com.assistme.req;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String phoneNumber;

	private String pin;
	
	@NotBlank
	private String deviceId;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
