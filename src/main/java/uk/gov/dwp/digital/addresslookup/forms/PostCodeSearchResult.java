package uk.gov.dwp.digital.addresslookup.forms;

import uk.gov.dwp.digital.addresslookup.domain.AddressResult;

public class PostCodeSearchResult {

	private AddressResult address;

	public PostCodeSearchResult(AddressResult a) {
		this.address = a;
	}

	public long getUprn() {
		return address.getUprn();
	}

	public String getAddress() {
		return address.getAddress();
	}

	public String getBuildingNumber() {
		return address.getBuildingNumber();
	}

	public String getOrganisationName() {
		return address.getOrganisationName();
	}

	public String getThoroughfareName() {
		return address.getThoroughfareName();
	}
	
	public String getDependentLocality() {
		return address.getDependentLocality();
	}

	public String getPosttown() {
		return address.getPosttown();
	}
	
	public String getPostcode() {
		return address.getPostcode();
	}

	

}
