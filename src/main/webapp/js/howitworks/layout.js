	var diagramBox = function(x,y,width,height,font,text,topJustify){
		this.x = x;
		this.y =y;
		this.width = width;
		this.height = height;
		this.font = font;
		this.text = text;
		this.topJustify = topJustify;
	}
	
	var simpleBoxHeight = 80;
	var simpleContainerHeight = 140;
	var horizontalGutter = 10;
	var verticalGutter = 50;
	
	var restClient = new diagramBox(100, 
			                        10, 
			                        200, 
			                        simpleBoxHeight,
			                        "30px Arial",
			                        "RESTClient");
	var qas3Client = new diagramBox(600, 
			                        10, 
			                        200, 
			                        simpleBoxHeight,
			                        "30px Arial",
			                        "QAS v3 Client");
	
	var qas4Client = new diagramBox(1100, 
			                        10, 
			                        200, 
			                        simpleBoxHeight,
			                        "30px Arial",
			                        "QAS v4 Client");

	var camelBox = new diagramBox(50, 
			                      restClient.y + restClient.height + verticalGutter, 
			                      1300, 
			                      550);
	
	var restEndpoint = new diagramBox(100, 
			                         camelBox.y + verticalGutter, 
			                         300, 
			                         simpleBoxHeight,
			                         "30px Arial",
			                         "Apache CXF RS");
	var cxfEndpoint = new diagramBox(473, 
			                         camelBox.y + verticalGutter, 
			                         600, 
			                         simpleBoxHeight,
			                         "30px Arial",
			                         "Apache CXF");


	var restRoute = new diagramBox(camelBox.x + horizontalGutter, 
			                       restEndpoint.y + restEndpoint.height + verticalGutter, 
			                       400, 
			                       simpleContainerHeight,
			                       "30px Arial",
			                       "Camel REST Route",
			                       true);
	var restPrepareParams = new diagramBox(restRoute.x + horizontalGutter, 
			                               restRoute.y + restRoute.height - (simpleContainerHeight - 40), 
			                               180, 
			                               simpleBoxHeight,
			                               "20px Arial",
			                               "Gather Parameters");
	var restParseResponse = new diagramBox(restRoute.x + restRoute.width - 180 - horizontalGutter, 
			                               restRoute.y + restRoute.height - (simpleContainerHeight - 40),
			                               180, 
			                               simpleBoxHeight,
			                               "20px Arial",
			                               "Parse Response");
	
	var cxfv3Route = new diagramBox(camelBox.x + (camelBox.width/2) - 200, 
			                        cxfEndpoint.y + cxfEndpoint.height + verticalGutter, 
			                        400, 
			                        simpleContainerHeight,
			                        "30px Arial",
			                        "Camel CXF QAS v3 Route",
			                        true);
 	var cxfv3Endpoint = new diagramBox(cxfv3Route.x + horizontalGutter, 
 			                              cxfv3Route.y + cxfv3Route.height - (simpleContainerHeight - 40), 
			                              180, 
			                              simpleBoxHeight,
			                              "20px Arial",
			                              "Gather Parameters");
	var cxfv3ParseResponse = new diagramBox(cxfv3Route.x + cxfv3Route.width - 180 - horizontalGutter, 
			                              cxfv3Route.y + cxfv3Route.height - (simpleContainerHeight - 40),
			                              180, 
			                              simpleBoxHeight,
			                              "20px Arial",
			                              "Parse Response");

	var cxfv4Route = new diagramBox(camelBox.x + camelBox.width - horizontalGutter - 400, 
			                        cxfEndpoint.y + cxfEndpoint.height + verticalGutter, 
			                        400, 
			                        simpleContainerHeight,
			                        "30px Arial",
			                        "Camel CXF QAS v4 Route",
			                        true);

 	var cxfv4Endpoint = new diagramBox(cxfv4Route.x + horizontalGutter, 
                                       cxfv4Route.y + cxfv4Route.height - (simpleContainerHeight - 40), 
                                       180, 
                                       simpleBoxHeight,
                                       "20px Arial",
                                       "Gather Parameters");
	var cxfv4ParseResponse = new diagramBox(cxfv4Route.x + cxfv4Route.width - 180 - horizontalGutter, 
                                          cxfv4Route.y + cxfv4Route.height - (simpleContainerHeight - 40),
                                          180, 
                                          simpleBoxHeight,
                                          "20px Arial",
                                          "Parse Response");
	
	var commonRoute = new diagramBox((camelBox.x + camelBox.width) / 2 - 300,
			                         restRoute.y + restRoute.height + verticalGutter, 
			                         600, 
			                         simpleContainerHeight,
			                         "30px Arial",
			                         "Camel Common Route",
			                         true);
	var callToAddressLookupService = new diagramBox(commonRoute.x + horizontalGutter, 
			                                        commonRoute.y + commonRoute.height - (simpleContainerHeight - 40), 
			                                        250, 
			                                        simpleBoxHeight,
			                                        "20px Arial",
			                                        "Call to Address Lookup");
	var responseUnmarshallProcess = new diagramBox(commonRoute.x + commonRoute.width - 250 - horizontalGutter, 
			                                       commonRoute.y + commonRoute.height - (simpleContainerHeight - 40),
			                                       250, 
			                                       simpleBoxHeight,
			                                       "20px Arial",
			                                       "Unmarshall Response");
	
	var addressLookupService = new diagramBox((camelBox.x + camelBox.width) / 2 - 180, 
                                             camelBox.y + camelBox.height + verticalGutter,
                                             360, 
                                             simpleBoxHeight,
            	                             "30px Arial",
                                             "Address Lookup Service");
