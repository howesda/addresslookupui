package uk.gov.dwp.digital.addresslookup.domain;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	private List<AddressResult> results;
	private String message;
	
	

	/**
	 * @return the error
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param error the error to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the addresses
	 */
	public List<AddressResult> getResults() {
		return results;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setResults(List<AddressResult> results) {
		this.results = results;
	}
	

}
