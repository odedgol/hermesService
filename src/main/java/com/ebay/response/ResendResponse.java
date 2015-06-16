package com.ebay.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResendResponse {

	private List<String> errors = new ArrayList<String>();
	private HttpStatus httpStatus;
	private HttpStatus code;
	private String url;

	public ResendResponse(List<String> errors, HttpStatus httpStatus,
			HttpStatus code, String url) {
		this.errors = errors;
		this.httpStatus = httpStatus;
		this.code = code;
		this.url = url;
	}

	public ResendResponse(String error, HttpStatus httpStatus, HttpStatus code,
			String url) {
		this.errors.add(error);
		this.httpStatus = httpStatus;
		this.code = code;
		this.url = url;
	}

}
