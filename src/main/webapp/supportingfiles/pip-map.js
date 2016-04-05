/**
 * 
 */
$(function() {
	if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
		var d = document, c = "appendChild", a = d.createElement("style");
		a[c](d.createTextNode("@-ms-viewport{width:auto!important}"));
		d.getElementsByTagName("head")[0][c](a);
	}

	$('#pip01_main').show();
	$('#pip02_main').hide();
	$('#pip03_main').hide();
	$('#pip04_main').hide();
	
});

document.body.className = ((document.body.className) ? document.body.className + ' js-enabled' : 'js-enabled');

$('#submitMe1').click(function() {
	if (document.getElementById('full-name').value === '') {
		document.getElementById("fullName.errors").innerHTML = "Client Side Validation : You must supply your full name";
		$("html, body").scrollTop($("#full-name").offset().top - 200);
	} else {
		$('#pip01_main').hide();
		$('#pip02_main').show();
		$('html,body').scrollTop(0);
	}
});
$('#submitMe2').click(function() {
	var errorMessage = "";
	var formIsValid = true;
	
	  if ( document.getElementById('health-desc').value === '' ) {
		  errorMessage += "Client Side Validation : You need to tell us about your Health Conditions<br>";
	  }

	  if ( document.getElementById('health-desc').value.length < 5 || document.getElementById('health-desc').value.length > 140 ) {
		  errorMessage += "Client Side Validation : Your explanation must be between 5 and 140 characters in length";
	  }

	  if ( errorMessage != "" ){
		  document.getElementById("healthConditions.errors").innerHTML = errorMessage;
		  formIsValid = false;
		  $("html, body").scrollTop($("#health-desc").offset().top - 200);
	  }
	  
 	// Cross validate Tablets check box and Description
		if ( document.getElementById("health-tablets-medication-yes").checked && (! document.getElementById("health-tablets-desc").value ) ){
			document.getElementById("healthTabletsMedicationDetails.errors").innerHTML = "Client Side Validation : You must enter details here if you say that you are taking medication";
			formIsValid = false;
			$("html, body").scrollTop($("#health-tablets-desc").offset().top - 200);
		} else {
			document.getElementById("healthTabletsMedicationDetails.errors").innerHTML = "";
		}
	
 	// Cross validate Treatment check box and Description
		if ( document.getElementById("health-treatment-yes").checked && (! document.getElementById("health-treatment-desc").value ) ){
			document.getElementById("healthTreatmentDetails.errors").innerHTML =  "Client Side Validation : You must enter details here if you say that you are having treatment";
			formIsValid = false;
			$("html, body").scrollTop($("#health-treatment-desc").offset().top - 200);
		} else {
			document.getElementById("healthTreatmentDetails.errors").innerHTML =  "";			
		}

	 if (formIsValid) {
		$('#pip02_main').hide();
		$('#pip03_main').show();
		$('html,body').scrollTop(0);
	}
});
$('#submitMe3').click(function() {
	if ( document.getElementById('healthcare-professional-name').value === '' ) {
		  document.getElementById("healthProfessionalName.errors").innerHTML = "Client Side Validation : You must supply the name of your Health Professional";
		  $("html, body").scrollTop($("#healthcare-professional-name").offset().top - 200);
	  } else {
			$('#pip03_main').hide();
			$('#pip04_main').show();
			$('html,body').scrollTop(0);
	  }
});

$('#backBtn1').click(function() {
	$('#pip01_main').show();
	$('#pip02_main').hide();
	$('html,body').scrollTop(0);
});
$('#backBtn2').click(function() {
	$('#pip02_main').show();
	$('#pip03_main').hide();
	$('html,body').scrollTop(0);
});
$('#backBtn3').click(function() {
	$('#pip03_main').show();
	$('#pip04_main').hide();
	$('html,body').scrollTop(0);
});

function handleAjaxSuccess(ajaxResult){
	 return window.location.assign( contextRoot + "/complete.html?id=" + ajaxResult.id + "&hid=" + ajaxResult.internalId.id);
}

var mappings = [ {
	domName : "#full-name",
	dataName : "fullName"
}, {
	domName : "#ni-number",
	dataName : "nationalInsuranceNumber"
}, {
	domName : "#address-line01",
	dataName : "addressLine1"
}, {
	domName : "#address-line02",
	dataName : "addressLine2"
}, {
	domName : "#address-line03",
	dataName : "addressLine3"
}, {
	domName : "#postcode1",
	dataName : "postCode"
}, {
	domName : "#dob-day",
	dataName : "dobDay"
}, {
	domName : "#dob-month",
	dataName : "dobMonth"
}, {
	domName : "#dob-year",
	dataName : "dobYear"
}, {
	domName : "#health-desc",
	dataName : "healthConds.healthDescription"
}, {
	domName : "#health-tablets-desc",
	dataName : "healthConds.healthTabletsDescription"
}, {
	domName : "#health-treatment-desc",
	dataName : "healthConds.healthTreatmentDescription"
}, {
	domName : "input[name=health-tablets-medication]:checked",
	dataName : "healthConds.healthTakesTablets"
}, {
	domName : "input[name=health-treatment]:checked",
	dataName : "healthConds.healthTreatment"
}, {
	domName : "#healthcare-professional-name",
	dataName : "healthProfessional.healthCareProfessionalName"
}, {
	domName : "#address-line11",
	dataName : "healthProfessional.healthCareProfessionalAddressLine1"
}, {
	domName : "#address-line12",
	dataName : "healthProfessional.healthCareProfessionalAddressLine2"
}, {
	domName : "#address-line13",
	dataName : "healthProfessional.healthCareProfessionalAddressLine3"
}, {
	domName : "#postcode2",
	dataName : "healthProfessional.healthCareProfessionalPostCode"
}, {
	domName : "#healthcare-professional-type",
	dataName : "healthProfessional.healthCareProfessionalType"
}, {
	domName : "#healthcare-professional-phone",
	dataName : "healthProfessional.healthCareProfessionalPhone"
}, {
	domName : "#healthcare-professional-date",
	dataName : "healthProfessional.healthCareProfessionalLastSeenDate"
} ];
