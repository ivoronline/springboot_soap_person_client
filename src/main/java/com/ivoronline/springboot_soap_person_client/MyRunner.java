package com.ivoronline.springboot_soap_person_client;

import com.ivoronline.soap.GetPersonResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

  //===============================================================================
  // RUN
  //===============================================================================
  @Override
  public void run(String... args) throws Exception {

    //POINTS TO GENERATED CLASSES
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
                    marshaller.setContextPath("com.ivoronline.soap");

    //CONFIGURE CLIENT
    PersonClient client = new PersonClient();
                 client.setDefaultUri  ("http://localhost:8080/ws");  //SERVICE URL
                 client.setMarshaller  (marshaller);
                 client.setUnmarshaller(marshaller);

    //SEND REQUEST
    GetPersonResponse response = client.getPerson(1);

    //PRINT RESPONSE
    System.out.println(response.getName());

  }

}
