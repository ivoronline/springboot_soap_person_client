package com.ivoronline.springboot_soap_person_client;

import com.ivoronline.soap.GetPersonResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

  //===============================================================================
  // RUN
  //===============================================================================
  @Override
  public void run(String... args) throws Exception {

    //SEND REQUEST
    PersonClient      client   = new PersonClient();
    GetPersonResponse response = client.getPerson(1);

    //PRINT RESPONSE
    System.out.println(response.getName());

  }

}
