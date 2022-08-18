package com.example.carrentalsystem.controller;

import javax.servlet.http.HttpSession;

import com.example.carrentalsystem.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.carrentalsystem.service.UserService;

@Controller
@RequestMapping("/profile")
public class PrivateController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String profile(Authentication auth, HttpSession session) {
        //Username in the session
        String username = auth.getName();
        if(session.getAttribute("user")==null) {
            UserEntity user = userService.findByUsername(username);
            user.setPassword(null);
            session.setAttribute("user", user);
        }

        return "profile";
    }
}
