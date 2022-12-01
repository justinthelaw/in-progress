package io.justinthelaw.portfolio.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

  private final String SITE_UP = "UP!";
  private final String SITE_DOWN = "DOWN!";
  private final String INCORRECT_URL = "DOES NOT EXIST!";

  @GetMapping("/check")
  @CrossOrigin(origins = "http://localhost:3000")
  public CheckResponse checkURL(@RequestParam String url) {
    String returnMessage = "";
    int responseCode = 404;
    try {
      if (!url.contains("https://") && !url.isEmpty()) {
        url = "https://" + url;
      }
      URL urlObject = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
      connection.setRequestMethod("GET");
      responseCode = connection.getResponseCode();
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
    return new CheckResponse(responseCode, returnMessage);
  }
}
