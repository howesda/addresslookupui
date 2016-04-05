package uk.gov.dwp.digital.addresslookup.forms;

import java.util.ArrayList;
import java.util.List;

import uk.gov.dwp.digital.addresslookup.domain.AddressResult;
import uk.gov.dwp.digital.addresslookup.domain.Results;

public class PostCodeSearchResultAdapter {
	
	public List<PostCodeSearchResult> adapt(List<AddressResult> candidateAddresses) {
		List<PostCodeSearchResult> results = new ArrayList<>();
		if ( null != candidateAddresses){
			candidateAddresses.stream().forEach(a ->results.add(new PostCodeSearchResult(a)));
		}
		return results;
	}

}
