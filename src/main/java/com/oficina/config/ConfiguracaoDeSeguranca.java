package com.oficina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.oficina.service.SegurancaUsuarioService;

@Configuration
@EnableWebSecurity

// segurança nos métodos dos controllers
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracaoDeSeguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SegurancaUsuarioService usuarioService;
	
	// autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("%%%%%%%%%%%%%%% TESTE");

		http.authorizeRequests()
		    .antMatchers("/veiculos").permitAll()
		    
		    //.antMatchers("/login/").permitAll()
		    //.anyRequest().hasRole("ADMIN")
			.antMatchers("/resources/static/**","/css/**","/js/**","/img/**","/webjars/**").permitAll()
		    // libera os arquivos estáticos
		    //.antMatchers("/resources/static/**").permitAll()
			.antMatchers().denyAll()
		    // verifica a autenticação para todos os requests
		    .anyRequest().authenticated()
		    .and()
		       // se não tiver logado, encaminha para o form de login
		       .formLogin()
		          .loginPage("/login").permitAll()
		    .and()
		          .logout()
		            .logoutRequestMatcher(new AntPathRequestMatcher("/logout") );   
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService);
	}
}