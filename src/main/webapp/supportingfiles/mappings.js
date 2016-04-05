var pip01Mappings = [ {
	domName : "#full-name",
	dataName : "fullName"
}, {
	domName : "#ni-number",
	dataName : "nationalInsuranceNumber"
}, {
	domName : "#address-line1",
	dataName : "addressLine1"
}, {
	domName : "#address-line2",
	dataName : "addressLine2"
}, {
	domName : "#address-line3",
	dataName : "addressLine3"
}, {
	domName : "#postcode",
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
}

]
var pip01ValidationCallback = function() {
	if (document.getElementById('full-name').value === '') {
		document.getElementById("fullName.errors").innerHTML = "Client Side Validation : You must supply your full name";
		return false;
	}
	return true;
}

var pip02Mappings = [ {
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
} ]
var pip02ValidationCallback = function() {
	var errorMessage = "";
	var formIsValid = true;
	if (document.getElementById('health-desc').value === '') {
		errorMessage += "Client Side Validation : You need to tell us about your Health Conditions<br>";
	}

	if (document.getElementById('health-desc').value.length < 5
			|| document.getElementById('health-desc').value.length > 140) {
		errorMessage += "Client Side Validation : Your explanation must be between 5 and 140 characters in length";
	}

	if (errorMessage != "") {
		document.getElementById("healthConditions.errors").innerHTML = errorMessage;
		formIsValid = false;
	}

	// Cross validate Tablets check box and Description
	if (document.getElementById("health-tablets-medication-yes").checked
			&& (!document.getElementById("health-tablets-desc").value)) {
		document.getElementById("healthTabletsMedicationDetails.errors").innerHTML = "Client Side Validation : You must enter details here if you say that you are taking medication";
		formIsValid = false;
	} else {
		document.getElementById("healthTabletsMedicationDetails.errors").innerHTML = "";
	}

	// Cross validate Treatment check box and Description
	if (document.getElementById("health-treatment-yes").checked
			&& (!document.getElementById("health-treatment-desc").value)) {
		document.getElementById("healthTreatmentDetails.errors").innerHTML = "Client Side Validation : You must enter details here if you say that you are having treatment";
		formIsValid = false;
	} else {
		document.getElementById("healthTreatmentDetails.errors").innerHTML = "";
	}

	return formIsValid;
}

var pip03Mappings = [ {
	domName : "#healthcare-professional-name",
	dataName : "healthProfessional.healthCareProfessionalName"
}, {
	domName : "#address-line1",
	dataName : "healthProfessional.healthCareProfessionalAddressLine1"
}, {
	domName : "#address-line2",
	dataName : "healthProfessional.healthCareProfessionalAddressLine2"
}, {
	domName : "#address-line3",
	dataName : "healthProfessional.healthCareProfessionalAddressLine3"
}, {
	domName : "#postcode",
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
} ]

var pip03ValidationCallback = function() {
	if (document.getElementById('healthcare-professional-name').value === '') {
		document.getElementById("healthProfessionalName.errors").innerHTML = "Client Side Validation : You must supply the name of your Health Professional";
		return false;
	}
	return true;
}

var pip04Mappings = [  ];
var pip04ValidationCallback = function(){return true};


var pip05Mappings = [  ];
var pip05ValidationCallback = function(){return true};