package uk.gov.dwp.digital.addresslookup.service;

import uk.gov.dwp.digital.addresslookup.common.BadRequestException;
import uk.gov.dwp.digital.addresslookup.common.NotFoundException;
import uk.gov.dwp.digital.addresslookup.common.UnrecoverableException;
import uk.gov.dwp.digital.addresslookup.domain.Results;

public interface PostCodeService {

	Results byPostcode(String postCode) throws NotFoundException, BadRequestException, UnrecoverableException;

}
