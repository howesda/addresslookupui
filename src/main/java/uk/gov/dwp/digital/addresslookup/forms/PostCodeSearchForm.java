package uk.gov.dwp.digital.addresslookup.forms;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import uk.gov.dwp.digital.addresslookup.domain.AddressResult;

public class PostCodeSearchForm {
	
	public interface AddressSelected{};
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String postCode;
	
	
	// The list of candidate addresses matching the postcode
	private List<AddressResult> candidateAddresses = null;
	
	// The internal Id of the selected address
	@Min(value=1,
		 groups = AddressSelected.class)
	private long selectedAddressUprn;
	
	private AddressResult selectedAddress;


	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public List<PostCodeSearchResult> getResults() {
		PostCodeSearchResultAdapter adapter = new PostCodeSearchResultAdapter();
		return adapter.adapt(candidateAddresses);
	}

	public void setResults(List<AddressResult> list) {
		this.candidateAddresses = list;
	}

	public long getSelectedAddressUprn() {
		return selectedAddressUprn;
	}

	public void setSelectedAddressUprn(long selectedAddress) {
		this.selectedAddressUprn = selectedAddress;
	}

	public void setSelectedAddress(AddressResult address) {
		this.selectedAddress = address;
		
	}
	
	public AddressResult getSelectedAddress() {
		return selectedAddress;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PostCodeSearchForm [name=" + name + ", postCode=" + postCode
				+ ", candidateAddresses=" + candidateAddresses
				+ ", selectedAddressUprn=" + selectedAddressUprn
				+ ", selectedAddress=" + selectedAddress + "]";
	}


}
