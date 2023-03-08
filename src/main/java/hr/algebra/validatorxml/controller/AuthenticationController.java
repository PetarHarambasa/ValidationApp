package hr.algebra.validatorxml.controller;


import hr.algebra.validatorxml.model.User;
import hr.algebra.validatorxml.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

import static hr.algebra.validatorxml.controller.HomeController.getApiData;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;
    public static User user;

    @PostMapping("/login")
    public RedirectView authenticateUser(@RequestParam String username, String password){
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (username.equals("admin") && password.equals("admin")) {
            String token = jwtUtil.generateToken(user);
            System.out.println("JWT token for admin: " + token);
            return getApiData(token);
        } else {
            return null;
        }
    }
}
