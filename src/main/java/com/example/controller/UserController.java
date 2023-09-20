package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "/register";
    }
    @PostMapping("/register_temp")
    String tempRegister(@ModelAttribute("user") User user){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
       // user.setName(user.getEmail());
        user.setBalance(0.0f);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        userService.saveUser(user);
        return "redirect:/login";

    }
    @GetMapping("/login")
    public String loginPage(){

        return "/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout(); // Выполнить выход из системы
        return "redirect:/login"; // Перенаправить на страницу логина после выхода
    }
}
