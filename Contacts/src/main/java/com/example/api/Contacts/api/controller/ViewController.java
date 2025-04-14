package com.example.api.Contacts.api.controller;

import com.example.api.Contacts.api.model.User;
import com.example.api.Contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    private final UserService userService;

    @Autowired
    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("login", users);
        return "login"; 
    }
    
    @GetMapping("/signup")
    public String viewSignUp(Model model) {
    	List<User> users = userService.getAllUsers();
    	model.addAttribute("signup", users);
    	return "signup";
    }
}
