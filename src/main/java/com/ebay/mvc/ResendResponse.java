package com.ebay.mvc;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ResendResponse {

	@NotNull
	private String epid;
	
	@NotNull
	private Date date;

	public ResendResponse(String epid, Date date) {
		this.epid = epid;
		this.date = date;
	}

	public String getEpid() {
		return epid;
	}

	public Date getDate() {
		return date;
	}



}
