package com.ebay.mvc;

import com.ebay.response.ResendStatus;

public class Message {
	
	private String epid;
	private ResendStatus resendStatus;
	public Message(String epid, ResendStatus resendStatus) {
		this.epid = epid;
		this.resendStatus = resendStatus;
	}

}
