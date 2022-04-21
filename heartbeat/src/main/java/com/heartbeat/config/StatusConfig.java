package com.heartbeat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.heartbeat.service.HeartBeatService;

@Configuration
@EnableScheduling
public class StatusConfig {
    
  @Autowired
  HeartBeatService heartBeatService;
  Logger LOGGER = LoggerFactory.getLogger(StatusConfig.class);
  @Scheduled(fixedRate = 300000)
  public void scheduleFixedStatusLog() {
    System.out.println("In config");
   String status = heartBeatService.checkApplicationStatus();
   LOGGER.info(status);
  }
  
}
