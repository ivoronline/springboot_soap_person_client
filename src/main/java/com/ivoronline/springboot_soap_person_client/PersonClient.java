package com.ivoronline.springboot_soap_person_client;

import com.ivoronline.soap.GetPersonRequest;
import com.ivoronline.soap.GetPersonResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class PersonClient extends WebServiceGatewaySupport {

  //PROPERTIES
  String wsURL    = "http://localhost:8080/ws";
  String wsdlURL  = "http://localhost:8080/ws/person";
  String endpoint = "http://ivoronline.com/soap/GetPersonRequest"; //Namespace + localPart

  //==========================================================================
  // GET PERSON
  //==========================================================================
  //Input Parameters are used to create Request Object which is marshalled into XML Request.
  //SOAP Envelope, Header and Body are added around generated XML Request.
  public GetPersonResponse getPerson(Integer id) throws URISyntaxException, IOException {

    //CREATE REQUEST OBJECT
    GetPersonRequest getPersonRequest = new GetPersonRequest();
                     getPersonRequest.setId(id);

    //POINT MARSHALLER TO GENERATED CLASSES
    Jaxb2Marshaller  marshaller = new Jaxb2Marshaller();
                     marshaller.setContextPath("com.ivoronline.soap");

    //CONFIGURE CLIENT
    setDefaultUri  (wsURL);
    setMarshaller  (marshaller);
    setUnmarshaller(marshaller);

    //SEND REQUEST
    WebServiceTemplate template = getWebServiceTemplate();
    GetPersonResponse  response = (GetPersonResponse) template.marshalSendAndReceive(wsdlURL, getPersonRequest);

    //RETURN RESPONSE OBJECT
    return response;

  }

}