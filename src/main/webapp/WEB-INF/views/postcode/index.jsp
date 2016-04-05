<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="../common/header.jsp"%>


<body class="js-enabled">

	<%@ include file="../common/banner.jsp"%>
	<div id="postcode_search" class="grid-row">
		<div class="column-two-thirds">


			<form:form id="form" method="post" action="index.html" commandName="postCodeSearchForm">
				<h1 class="form-title heading-large">Enter your Name and Address</h1>
				<ul>
					<li>
						<div class="form-group">
							<label class="form-label-bold" for="name">Name</label>
							<form:input path="name" type="text" class="form-control" id="name" />
							<div id="name.errors" class="validation-message">
								<form:errors path="name"/>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="form-label-bold" for="post-code">Post Code</label>
							<form:input path="postCode" type="text" class="form-control" id="post-code" />
							<div id="postCode.errors" class="validation-message">
								<form:errors path="postCode"/>
							</div>
							<div class="form-group">
								<input type="submit" class="button" value="Search" name="action" id="search">
							</div>
						</div>
					</li>
				</ul>

				<div id="post-code-results" class="${postCodeSearchForm.results.size() == 0 ? 'hidden' : ''}">
					<c:if test="${postCodeSearchForm.results.size() != 0}">
						<ul>
							<form:radiobuttons element="li" path="selectedAddressUprn" items="${postCodeSearchForm.results}" itemLabel="address" itemValue="uprn" />
						</ul>
						<div id="selectedAddressUprn.errors" class="validation-message">
							<form:errors path="selectedAddressUprn"/>			
						</div>						
						<div class="form-group">
							<input type="submit" class="button" value="Select" id="select" name="action">
						</div>
					</c:if>
							
				</div>

			<div id="selected-address" class="${(postCodeSearchForm.selectedAddress == null) ? 'hidden' : ''}">
				<c:if test="${postCodeSearchForm.selectedAddress != null}">
					<ul>
						<li id="addr1">
							${postCodeSearchForm.selectedAddress.address}
						</li>
					</ul>
				</c:if>
				<form:input type="hidden" id="selectedAddressUprn" path="selectedAddressUprn"/>
				<div class="form-group">
					<input type="submit" class="button" value="Continue" id="continue" name="action">
				</div>
				
			</div>
				
	
			</form:form>


		</div>
		<div class="column-third"></div>
	</div>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>