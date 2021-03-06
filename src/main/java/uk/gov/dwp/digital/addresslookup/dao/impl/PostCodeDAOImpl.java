package uk.gov.dwp.digital.addresslookup.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import uk.gov.dwp.digital.addresslookup.common.BadRequestException;
import uk.gov.dwp.digital.addresslookup.common.NotFoundException;
import uk.gov.dwp.digital.addresslookup.common.UnrecoverableException;
import uk.gov.dwp.digital.addresslookup.dao.PostCodeDAO;
import uk.gov.dwp.digital.addresslookup.domain.Results;

public class PostCodeDAOImpl implements PostCodeDAO{
	
	private String addressLookupServiceURI = null;
	
	private final static String defaultPropsFileLocation = "/app.props";
	
	public PostCodeDAOImpl(){
		
		String propsFileLocation = System.getProperty("propsFile");
		Properties props = new Properties();
		try {

			InputStream is = null;
			if ( propsFileLocation == null ){
				is = PostCodeDAOImpl.class.getResourceAsStream(defaultPropsFileLocation);
			} else {
				is = new FileInputStream(new File(propsFileLocation));
			}
				
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		addressLookupServiceURI = props.getProperty("address.service.uri");
	}
	
	@Override
	public Results byPostCode(String postCode) throws NotFoundException, BadRequestException, UnrecoverableException {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		
		String urlEncodedPostCode;
		try {
			urlEncodedPostCode = URLEncoder.encode(postCode,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new BadRequestException("Unable to process postcode " + postCode,e);
		}
		
		WebResource wr = client.resource(addressLookupServiceURI + "/addresses/postcode/" + urlEncodedPostCode);
		
		ClientResponse response = null;
		try {
			response = wr.accept("application/json").get(ClientResponse.class);
		} catch (UniformInterfaceException | ClientHandlerException e) {
			throw new UnrecoverableException(" Unrecoverable error occured : " + e.getMessage());
		}
		
		if (response.getStatus() == 404) {
			throw new NotFoundException();
		}
		if (response.getStatus() == 400) {
			throw new BadRequestException();
		}
		if(response.getStatus() != 200) {
			throw new UnrecoverableException("Opps, Somethings not right there. HTTP Error status : " + response.getStatus());
		}
		String jsonStr = response.getEntity(String.class);
	
	    ObjectMapper mapper = new ObjectMapper();  
	    Results wrapper = null;
	    try {
	        wrapper = mapper.readValue(jsonStr , Results.class);
	    } catch (IOException e) {
			throw new UnrecoverableException("Cannot map string : " + jsonStr + " to class : " + Results.class + " Unrecoverable error occured : " + e.getMessage());
	    } 
		
		return wrapper;
	}

}
