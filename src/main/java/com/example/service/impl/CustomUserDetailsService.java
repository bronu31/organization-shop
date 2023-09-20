package com.example.service.impl;

import com.example.details.CustomUserDetails;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {

@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        System.out.println("user");
        System.out.println(username);
        System.out.println("user");
        System.out.println();
     user=userRepository.findByEmail(username);
    // user=userRepository.findByName(username);
        System.out.println(user.getEmail());
        System.out.println(passwordEncoder.matches("5",user.getPassword()));
        System.out.println(user.toString());
    if (user==null) {throw new UsernameNotFoundException("User not found");}
        System.out.println("aaaaa");
        return new CustomUserDetails(user);
    }
}
