package io.justinthelaw.portfolio.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

  private final String SITE_UP = "UP!";
  private final String SITE_DOWN = "DOWN!";
  private final String INCORRECT_URL = "DOES NOT EXIST!";

  @GetMapping("/check")
  public String checkURL(@RequestParam String url) {
    String returnMessage = "";
    try {
      URL urlObject = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      if (responseCode < 200 || responseCode >= 400) {
        returnMessage = SITE_DOWN;
      } else {
        returnMessage = SITE_UP;
      }
    } catch (MalformedURLException e) {
      returnMessage = INCORRECT_URL;
    } catch (IOException e) {
      returnMessage = SITE_DOWN;
    }
    return returnMessage;
  }
}
