package com.oficina.config;
/*

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.oficina.security.ComercialUserDetailsService;



@SuppressWarnings("unused")
//@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	 private ComercialUserDetailsService comercialUserDetailsService;
	 
	 /*
	  @Override
	  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .userDetailsService(comercialUserDetailsService)
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            // Para qualquer requisição (anyRequest) é preciso estar 
	            // autenticado (authenticated).
	            .anyRequest().authenticated()
	        .and()
	        .formLogin() // <<< de HTTP Basic para formulário
	        // Aqui dizemos que temos uma página customizada.
	        	.loginPage("/") 
		        // Mesmo sendo a página de login, precisamos avisar
		        // ao Spring Security para liberar o acesso a ela.
		        .permitAll();
	  }
	  
}

*/
