package com.nihi.bl.driver.service;

import java.text.ParseException;


import org.springframework.stereotype.Component;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;

@Component
public class SmsService {
	private final String ACCOUNT_SID = "AC9ef9069f8f910f3140fa9cde02efcfa5";
	private final String AUTH_TOKEN = "a7faf369356e372a86a913c836e396a3";
	private final String FROM_NUMBER = "+19472253836";

	public String send(String toMobile) throws ParseException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		int min = 1000;
		int max = 9999;
		int number = (int) (Math.random() * (max - min + 1) + min);

		String msg = "Your OTP - " + number + "please verify you OTP in your Application by Brown Logistics";
		Message.creator(new PhoneNumber(toMobile),
				new PhoneNumber(FROM_NUMBER), " ").create();

		return msg;
	}
}
