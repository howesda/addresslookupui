package uk.gov.dwp.digital.addresslookup.service.impl;

import uk.gov.dwp.digital.addresslookup.common.BadRequestException;
import uk.gov.dwp.digital.addresslookup.common.NotFoundException;
import uk.gov.dwp.digital.addresslookup.common.UnrecoverableException;
import uk.gov.dwp.digital.addresslookup.dao.PostCodeDAO;
import uk.gov.dwp.digital.addresslookup.dao.impl.PostCodeDAOImpl;
import uk.gov.dwp.digital.addresslookup.domain.Results;
import uk.gov.dwp.digital.addresslookup.service.PostCodeService;

public class PostCodeServiceImpl implements PostCodeService{
	
	private PostCodeDAO dao = new PostCodeDAOImpl();
	
	@Override
	public Results byPostcode(String postCode) throws NotFoundException, BadRequestException, UnrecoverableException {		
		return dao.byPostCode(postCode);
	}

}
