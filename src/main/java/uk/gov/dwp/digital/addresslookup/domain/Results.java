package uk.gov.dwp.digital.addresslookup.domain;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	private List<AddressResult> results;
	private AddressLookupError error;
	
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

	public AddressLookupError getError() {
		return error;
	}

	public void setError(AddressLookupError error) {
		this.error = error;
	}
	

}
