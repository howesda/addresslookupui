package uk.gov.dwp.digital.addresslookup.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.gov.dwp.digital.addresslookup.common.BadRequestException;
import uk.gov.dwp.digital.addresslookup.common.NotFoundException;
import uk.gov.dwp.digital.addresslookup.common.UnrecoverableException;
import uk.gov.dwp.digital.addresslookup.domain.AddressResult;
import uk.gov.dwp.digital.addresslookup.domain.Results;
import uk.gov.dwp.digital.addresslookup.forms.PostCodeSearchForm;
import uk.gov.dwp.digital.addresslookup.forms.PostCodeSearchForm.AddressSelected;
import uk.gov.dwp.digital.addresslookup.service.PostCodeService;

@Controller
@RequestMapping("postcode")

public class PostCodeController {
	
	private PostCodeService postCodeService;
	private SpringValidatorAdapter validator;
	
	
	public PostCodeController(PostCodeService postCodeService,
			                  SpringValidatorAdapter validator) {
		this.postCodeService = postCodeService;
		this.validator = validator;
	}
	
	int[] studentGrades = { 99, 23, 56, 23, 59 };
	String[] students = { "Alice", "Jordan", "Matt" };
	
	//  Displays the postcode search page
	@RequestMapping(value="index.html", method = RequestMethod.GET)
	public ModelAndView showIndex() {
		return new ModelAndView("postcode/index.jsp","postCodeSearchForm",new PostCodeSearchForm());
	}

	//  Handles the methods involved in searching for, selecting and displaying the Address
	@RequestMapping(value="index.html", method = RequestMethod.POST)
	public ModelAndView executeSearch(PostCodeSearchForm form,BindingResult bindingResult, HttpServletRequest request) {
		validator.validate(form, bindingResult);
		
		if ( bindingResult.hasErrors() ){
			return new ModelAndView("postcode/index.jsp","postCodeSearchForm",form);
		}
		ModelAndView mv = null;
		
		
		switch (request.getParameter("action")){
			case "Search" :
				mv = processSearchRequest(form, bindingResult, request);
				break;
			case "Select" :
				validator.validate(form, bindingResult, AddressSelected.class);
				if ( bindingResult.hasErrors() ){
					mv = new ModelAndView("postcode/index.jsp","postCodeSearchForm",form);
				} else {
					mv = selectAddress(form, bindingResult,request);
				}
				break;
			case "Continue" :
				mv = confirmAddress(form, bindingResult,request);
				break;
			default:
				mv = new ModelAndView("error.jsp");
		}
	
		return mv;
	}
	
	private ModelAndView processSearchRequest(PostCodeSearchForm form,BindingResult bindingResult,HttpServletRequest request){
		Results addresses = null;
		
		try{
			addresses = postCodeService.byPostcode(form.getPostCode().toUpperCase());
			
			if ( addresses.getResults().size() == 1 ) {
				form.setSelectedAddress(addresses.getResults().get(0));
				form.setSelectedAddressUprn(addresses.getResults().get(0).getUprn());
				form.setResults(null);
			} else {
				form.setResults(addresses.getResults());		
				
			}
		} catch(NotFoundException e) {
			bindingResult.rejectValue("postCode", "postCodeNotFound");
		} catch (BadRequestException e) {
			bindingResult.rejectValue("postCode", "postCodeTooShort");
		} catch (UnrecoverableException e) {
			e.printStackTrace();
			bindingResult.rejectValue("postCode", "unrecoverable");
		} 
		
		HttpSession session = request.getSession(true);
		session.setAttribute("results", addresses);
		return new ModelAndView("postcode/index.jsp","postCodeSearchForm",form);
	}
	
	private ModelAndView selectAddress(PostCodeSearchForm form,BindingResult bindingResult,HttpServletRequest request){
		HttpSession session = request.getSession();
		Results results = (Results) session.getAttribute("results");
		for(int i = 0; i<results.getResults().size(); i++) {
			if (results.getResults().get(i).getUprn() == form.getSelectedAddressUprn()){
				AddressResult ar = new AddressResult();
				ar.setUprn(results.getResults().get(i).getUprn());
				ar.setAddress(results.getResults().get(i).getAddress());
				ar.setBuildingNumber(results.getResults().get(i).getBuildingNumber());
				ar.setDependentLocality(results.getResults().get(i).getDependentLocality());
				ar.setOrganisationName(results.getResults().get(i).getOrganisationName());
				ar.setThoroughfareName(results.getResults().get(i).getThoroughfareName());
				ar.setPosttown(results.getResults().get(i).getPosttown());
				ar.setPostcode(results.getResults().get(i).getPostcode());
				form.setSelectedAddress(ar);
			}
		}
		return new ModelAndView("postcode/index.jsp","postCodeSearchForm",form);
	}
	
	private ModelAndView confirmAddress(PostCodeSearchForm form,BindingResult bindingResult,HttpServletRequest request){
		HttpSession session = request.getSession();
		Results results = (Results) session.getAttribute("results");
		for(int i = 0; i<results.getResults().size(); i++) {
			if (results.getResults().get(i).getUprn() == form.getSelectedAddressUprn()){
				AddressResult ar = new AddressResult();
				ar.setUprn(results.getResults().get(i).getUprn());
				ar.setAddress(results.getResults().get(i).getAddress());
				ar.setBuildingNumber(results.getResults().get(i).getBuildingNumber());
				ar.setDependentLocality(results.getResults().get(i).getDependentLocality());
				ar.setOrganisationName(results.getResults().get(i).getOrganisationName());
				ar.setThoroughfareName(results.getResults().get(i).getThoroughfareName());
				ar.setPosttown(results.getResults().get(i).getPosttown());
				ar.setPostcode(results.getResults().get(i).getPostcode());
				form.setSelectedAddress(ar);
			}
		}
		return new ModelAndView("postcode/confirm.jsp","form",form);
	}
}
