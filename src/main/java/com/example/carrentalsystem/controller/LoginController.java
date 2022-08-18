package com.example.carrentalsystem.controller;

import javax.validation.Valid;

import com.example.carrentalsystem.model.UserEntity;
import com.example.carrentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController{
    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String Login(Model model){
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @GetMapping("/auth/register")
    public String registroForm(Model model){
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/auth/register")
    public String register(@Valid @ModelAttribute UserEntity user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/register";
        }else{
            model.addAttribute("user",userService.register(user));
        }
        return "redirect:/auth/login";
    }
}