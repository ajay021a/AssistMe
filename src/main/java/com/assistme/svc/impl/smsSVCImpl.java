package com.assistme.svc.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assistme.svc.SmsSvc;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

@Service
public class smsSVCImpl implements SmsSvc {
	
	@Value("${app.twillio.accountSID}")
	private String ACCOUNT_SID;
	
	@Value("${app.twillio.authToken}")
	private String AUTH_TOKEN;
	
	@Value("${app.twillio.fromPhoneNo}")
	private String FROM_NUMBER;
	
	@Value("${app.twillio.serviceId}")
	private String SERVICE_ID;

	@Override
	public boolean sendSms(String nubmer) {
		try {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			Verification verification = Verification.creator(SERVICE_ID, nubmer, "sms").create();
			System.err.println(verification.getStatus());
			if ("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
				return true;
			}
			return false;
		} catch (ApiException exception) {
			System.err.println(exception.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean verification(String nubmer, String pin) {
		try {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			VerificationCheck verification = VerificationCheck.creator(SERVICE_ID, pin).setTo(nubmer).create();
			System.err.println(verification);
			if ("approved".equals(verification.getStatus())) {
				return true;
			}
			return false; 
		} catch (ApiException exception) {
			System.err.println(exception.getMessage());
			return false;
		}
	}


}
