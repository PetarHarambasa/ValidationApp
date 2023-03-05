package hr.algebra.validatorxml.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @GetMapping("/error")
    String errorJWTToken(HttpServletRequest request) {
        return "errorJWTToken";
    }
    @PostMapping("/error")
    String errorValidation(HttpServletRequest request) {
        return "errorValidation";
    }
}
