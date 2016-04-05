package uk.gov.dwp.digital.addresslookup.service;

import uk.gov.dwp.digital.addresslookup.domain.Results;

public interface PostCodeService {

	Results byPostcode(String postCode);

}
