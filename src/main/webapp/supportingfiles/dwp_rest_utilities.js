//Utilities to handle REST approach to this application
"use strict";

var apiLocation ="/test-webapp/webapi/pip";
var pipApp;
var contextRoot = window.location.pathname.substring(0,window.location.pathname.lastIndexOf("/"));
var callback;


function startApplicationProcess(tagMe,nextPage){
	$(tagMe).click(function() {
		$.ajax({
			url: apiLocation,
			method: "POST",
			cache: false,
	        async:true,
			success: function(result,textStatus, request){
				window.location.href = contextRoot + "/" + nextPage + "?id=" + result.publicId + "&hid=" +result.privateId.id;

			},
			error: function(x,textStatus,exception){
				 return("false");
			}
		});
	});  
}

function prepare(mappings,nextPage,formattingCallBack,validationCallBack){
	callback = formattingCallBack;
	$(document).ready(preparePage(mappings));
		
	$(window).load(prepareCallToAction(mappings,nextPage,validationCallBack));

}



function preparePage(mappings){
	
	var queryString = {}
	location.search.substr(1).split("&").forEach(function(item) {queryString[item.split("=")[0]] = item.split("=")[1]})

	$.ajax({
		url: apiLocation + "/" + queryString["id"] + "/" + queryString["hid"] ,
		success: function(result){
			pipApp = result;
		  	for(var i = 0; i < mappings.length; i++){
		  		$(mappings[i].domName).val(eval('(pipApp.'+[mappings[i].dataName] +')'));
		  	}
		  	callback();
		},
	});
	


}

function prepareCallToAction(mappings,nextPage,validation){

   $('#submitMe' ).click(function() {
	   
	 var validationPassed = validation();
	 
	 if (! validationPassed ){
		 return false;
	 }

   	 for(var i = 0; i < mappings.length; i++){
        eval ('pipApp.' + [mappings[i].dataName] + ' =  $(mappings[i].domName).val()');
  	}
  	
    $.ajax({
        url: apiLocation + "/" + pipApp.id + "/" + pipApp.internalId.id,
        method: "PUT",
        data: JSON.stringify(pipApp),
        contentType: "application/json",
        cache: false,
        async: true,
        success: function(result){

        	handleAjaxSuccess(result,nextPage);
        	return false;
        },
        error: function(x,textStatus,exception){
             return false;
        }
    });

});  
}

function handleAjaxSuccess(result,nextPage){
		window.location.assign( contextRoot + "/" + nextPage + "?id=" + result.id + "&hid=" + result.internalId.id);
}



