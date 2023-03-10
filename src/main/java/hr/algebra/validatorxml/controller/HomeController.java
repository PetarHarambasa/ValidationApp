package hr.algebra.validatorxml.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.URL;

import static hr.algebra.validatorxml.controller.AuthenticationController.user;
import static hr.algebra.validatorxml.utils.JwtUtil.validateToken;

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
    static public RedirectView getApiData(@RequestBody String JwtToken) {
        //Change every time you port forward mockoon data with ngrok
        String url = "https://71e9-94-250-167-253.eu.ngrok.io/arkCreatures/json";
        String redirectUrl = "/api/json?url=" + url;
        validateToken(JwtToken, user);
        System.out.println("JWT Token validated successful");
        return new RedirectView(redirectUrl);
    }

    @GetMapping(value = "/api/json")
    @ResponseBody
    public String getJson(@RequestParam("url") String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new URL(url));
        return objectMapper.writeValueAsString(jsonNode);
    }
}
