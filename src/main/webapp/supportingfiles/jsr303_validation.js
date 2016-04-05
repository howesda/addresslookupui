"use strict";

/*
 * A collection of utilities mirroring a very small subset of the JSR303 validation specification
 * to indicate how the JSR303 semantics can be mirrored in the JavaScript world
 */
var JSR303 = {
	
	NotEmpty : function(val){
		//returns true if val is not empty
		if ( val === undefined ){
			return false;
		}
		
		if ( val.length === 0 ){
			return false;
		}
		
		return true;
	},

	Size : function(val,min,max){
		// returns true if the length of val falls between the min and max constraints ( inclusive )
		return (val.length >= min && val.length <= max);
		
	}
		
}

