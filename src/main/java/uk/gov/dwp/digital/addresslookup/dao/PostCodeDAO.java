package uk.gov.dwp.digital.addresslookup.dao;

import uk.gov.dwp.digital.addresslookup.common.BadRequestException;
import uk.gov.dwp.digital.addresslookup.common.NotFoundException;
import uk.gov.dwp.digital.addresslookup.common.UnrecoverableException;
import uk.gov.dwp.digital.addresslookup.domain.Results;

public interface PostCodeDAO {
	
	Results byPostCode(String postCode) throws NotFoundException, BadRequestException, UnrecoverableException;

}
