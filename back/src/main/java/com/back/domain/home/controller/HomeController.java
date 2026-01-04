package com.back.domain.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Slf4j
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String main() {
    InetAddress localHost = null;

    try {
      localHost = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Runs in any environment");
    // log.info("Runs in any environment");
    log.debug("Run in dev/prod environments");

    return "main(version : 1.0.0), hostname : %s".formatted(localHost.getHostName());
  }
}
