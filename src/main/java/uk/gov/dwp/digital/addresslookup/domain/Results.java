package uk.gov.dwp.digital.addresslookup.domain;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	private List<AddressResult> results;

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
	
	public String toString() {
		return "Results [results=" + results + "]";
	}

}
