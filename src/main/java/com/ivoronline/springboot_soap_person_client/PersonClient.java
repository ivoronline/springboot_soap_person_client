package com.ivoronline.springboot_soap_person_client;

import com.ivoronline.soap.GetPersonRequest;
import com.ivoronline.soap.GetPersonResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PersonClient extends WebServiceGatewaySupport {

  //==========================================================================
  // GET PERSON
  //==========================================================================
  //Input Parameters are used to create Request Object
  public GetPersonResponse getPerson(Integer id) {

    //SPECIFY WSDL URL
    String wsdlURL  = "http://localhost:8080/ws/person";

    //SPECIFY ENDPOINT
    String endpoint = "http://ivoronline.com/soap/GetPersonRequest"; //Namespace + localPart

    //CREATE REQUEST OBJECT
    GetPersonRequest getPersonRequest = new GetPersonRequest();
                     getPersonRequest.setId(id);

    //EXECUTE REQUEST. GET RESPONSE OBJECT
    GetPersonResponse response = (GetPersonResponse) getWebServiceTemplate()
      .marshalSendAndReceive(wsdlURL, getPersonRequest, new SoapActionCallback(endpoint));

    //RETURN RESPONSE OBJECT
    return response;

  }

}