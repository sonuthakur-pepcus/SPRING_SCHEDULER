package com.heartbeat.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class HeartBeatServiceImplementation   implements HeartBeatService{

  @Override
  public String checkApplicationStatus() {
    String status = "";
    try {
      String link_url = "http://localhost:8080/employees/";
      URL obj1 = new URL(link_url); // URL Connection Created...
      HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection(); // Http URL Connection Created...                                                                         
      int r_code = con1.getResponseCode(); // it is use to get the status code from HTTP response message                                           
      System.out.println("http://localhost:8080/employees/getall");
      System.out.println("Connection Response Code : " + r_code);
      
      if(r_code == HttpURLConnection.HTTP_OK) // HTTP_OK : HTTP Status-Code
      {
        status = "Application is up and running. Status code: " + r_code; // 200: OK                                                               
      }
      else {
        status = "problem in running application. Status code:  " + r_code; 
      }
      con1.disconnect();
      System.out.println("Connection Disconnect... ");
    } catch (Exception e) {
      e.printStackTrace();
      status = "unable to connect " + e.getMessage();
    }
    return status;
  }

}
