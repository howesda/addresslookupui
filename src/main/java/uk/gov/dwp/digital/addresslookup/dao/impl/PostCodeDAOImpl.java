package uk.gov.dwp.digital.addresslookup.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import uk.gov.dwp.digital.addresslookup.dao.PostCodeDAO;
import uk.gov.dwp.digital.addresslookup.domain.Results;

public class PostCodeDAOImpl implements PostCodeDAO{
	
	@Override
	public Results byPostCode(String postCode) {
		ClientConfig clientConfig = new DefaultClientConfig();
		//clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		
		WebResource wr = client.resource("http://localhost:8081/addresses/postcode/" + postCode);
		
		ClientResponse response = wr.accept("application/json").get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}

		String jsonStr = response.getEntity(String.class);
	
	    ObjectMapper mapper = new ObjectMapper();  
	    Results wrapper = null;
	    try {
	        wrapper = mapper.readValue(jsonStr , Results.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return wrapper;
	}

}
