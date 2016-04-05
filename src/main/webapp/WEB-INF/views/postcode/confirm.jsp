<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="../common/header.jsp"%>


<body class="js-enabled">

	<%@ include file="../common/banner.jsp"%>
	<div id="postcode-confirm" class="grid-row">
		<div class="column-two-thirds">

			<h1 class="form-title heading-large">Thank You</h1>
			<p>Your details have been stored and any future communication will be sent to</p>
			<ul>
				<li id="name">${form.name}</li>
				<li id="addr1">${form.selectedAddress.buildingNumber}</li>
				<li id="addr2">${form.selectedAddress.organisationName}</li>
				<li id="addr3">${form.selectedAddress.thoroughfareName}</li>
				<li id="addr4">${form.selectedAddress.dependentLocality}</li>
				<li id="addr4">${form.selectedAddress.posttown}</li>
				<li id="addr-post-code">${form.selectedAddress.postcode}</li>
			</ul>

			<div class="form-group">
				<a id="finish" class="button" href="index.html">Finish</a>
			</div>


		</div>
		<div class="column-third"></div>
	</div>

	<%@ include file="../common/footer.jsp"%>
</body>
<!-- 
<script type="text/javascript">

	$( document ).ready(function() {
	    $( "#form" ).submit(function(event){
	    	
	    	if (! JSR303.NotEmpty($('#full-name').val()) ){
	    		$('#fullName\\.errors').html("Client Side Validation : You must supply your full name");   
	    		event.preventDefault();
	    	}

	    });
	});
	

</script-->
</html>