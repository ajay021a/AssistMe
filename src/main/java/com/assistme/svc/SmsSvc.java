package com.assistme.svc;

public interface SmsSvc {
	public boolean sendSms(String num);

	boolean verification(String nubmer, String pin);

}
