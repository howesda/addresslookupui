package uk.gov.dwp.digital.addresslookup.common;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String msg,Exception e) {
		super(msg,e);
	}
}
