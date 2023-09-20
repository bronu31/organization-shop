package com.example.config;


import com.example.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        System.out.println("provider");
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("ooooo");

        http//.csrf().disable()
                .authorizeHttpRequests(authz->authz
                .antMatchers("/register_temp").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/**").authenticated()

        )
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .permitAll())
                .formLogin(form ->form.loginPage("/login").permitAll()
                .defaultSuccessUrl("/organizations")


                ).authenticationProvider(authenticationProvider())
        //).formLogin(withDefaults())
                //.logout((logout) -> logout.logoutSuccessUrl("/login"))
                ;


        return http.build();
    }

    /*public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        System.out.println("config");
        /*managerBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select name,email,password from users")
                .authoritiesByUsernameQuery("select name,role from users");

        System.out.println("yes");*/
       // managerBuilder.authenticationProvider(authenticationProvider());
  //  }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }*/


}

