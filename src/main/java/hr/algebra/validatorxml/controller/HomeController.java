package hr.algebra.validatorxml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
