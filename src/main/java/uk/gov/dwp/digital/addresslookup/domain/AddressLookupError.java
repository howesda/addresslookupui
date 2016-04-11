package uk.gov.dwp.digital.addresslookup.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressLookupError {
	@JsonProperty("statuscode")
	private String statusCode;
	private String message;
	
	public String getStatuscode() {
		return statusCode;
	}
	
	public void setStatuscode(String statuscode) {
		this.statusCode = statuscode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
