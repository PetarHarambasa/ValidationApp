package hr.algebra.validatorxml.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
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
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/api", produces = "application/json")
    static public RedirectView getApiData(@RequestBody String JwtToken) {
        //Change every time you port forward mockoon data with ngrok
        String url = "https://f672-141-138-26-185.eu.ngrok.io/arkCreatures/json";
        String redirectUrl = "/api/json?url=" + url;
        validateToken(JwtToken, user);
        System.out.println("JWT Token validated successful");
        return new RedirectView(redirectUrl);
    }

    @GetMapping(value = "/api")
    @ResponseBody
    public String getJson(@RequestParam("url") String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new URL(url));
        return objectMapper.writeValueAsString(jsonNode);
    }

    @GetMapping("/cleanSession")
    public String cleanSession(SessionStatus sessionStatus, HttpSession session) {
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
