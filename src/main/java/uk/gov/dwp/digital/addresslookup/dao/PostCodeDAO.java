package uk.gov.dwp.digital.addresslookup.dao;

import uk.gov.dwp.digital.addresslookup.domain.Results;

public interface PostCodeDAO {
	
	Results byPostCode(String postCode);

}
