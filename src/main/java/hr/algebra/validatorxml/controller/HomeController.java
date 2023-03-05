package hr.algebra.validatorxml.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.algebra.validatorxml.model.Creatures;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Controller
public class HomeController {
    @GetMapping("/validateXSD")
    public String getXSDValidationPage() {
        return "validateXSD";
    }

    @GetMapping("/validateRNG")
    public String getRNGValidationPage() {
        return "validateRNG";
    }

    @GetMapping("/auth/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/api/json", produces = "application/json")
    static public RedirectView getApiData(@RequestBody String JwtToken) throws IOException {
        //Change every time you port forward mockoon data with ngrok
        String url = "https://34ad-94-250-167-253.eu.ngrok.io/arkCreatures/json";
        String redirectUrl = "/api/json?url=" + url;
        return new RedirectView(redirectUrl);
    }

    @GetMapping(value = "/api/json")
    @ResponseBody
    public String getJson(@RequestParam("url") String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Use a library like Jackson to parse the JSON data from the URL
        JsonNode jsonNode = objectMapper.readTree(new URL(url));

        // Convert the parsed JSON data back to a string and return it
        return objectMapper.writeValueAsString(jsonNode);
    }
}
