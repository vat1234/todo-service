package com.mycomp.todo.service.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        // remove csrf and state in session because in jwt we do not need them
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(new JwtAuthorizationFilter(authenticationManager()))
        // add jwt filters (1. authentication, 2. authorization)
        .authorizeRequests()
        // configure access rules
        .anyRequest().authenticated();
  }
}
