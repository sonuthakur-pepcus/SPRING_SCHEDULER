package com.heartbeat.cotroller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heartbeat.service.HeartBeatService;

@RestController
public class HeartBeat {

  @Autowired
  HeartBeatService heartBeatService;

  @GetMapping("/log")
  public String makeApiCallSimple(ServletRequest request, ServletResponse response) {
   
    return heartBeatService.checkApplicationStatus();
  }
}
