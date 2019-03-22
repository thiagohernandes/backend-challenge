package com.invillia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.invillia.jwt.JWTAuthenticationFilter;
import com.invillia.jwt.JWTLoginFilter;
import com.invillia.model.User;
import com.invillia.service.UserService;

/*
 * Web Security Configuration - Filter
 * @since 22-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		for(User u : userService.allUsersList()) {
			auth.inMemoryAuthentication()
			.withUser(u.getName())
			.password("{noop}" + u.getPassword())
			.roles("ADMIN");
		}
	}
}
