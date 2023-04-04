package com.planetpreserve.restfulapi.SpringSecurity.basic;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class BasicAuthSecurityConfiguration {
	
	@Bean
	// Rename to securityFilterChain
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// Spring Security Chain
		// Intercept and authenticate all requests
		http.csrf().disable()
		.authorizeHttpRequests( auth -> auth
				.requestMatchers("/planet-preserve/login-check=authentication/{username}/{password}")
				.permitAll()
				.requestMatchers("/planet-preserve/signup")
				.permitAll()
				.anyRequest()
				.authenticated());
		// Form Auth
		// -- http.formLogin();
		// Disable sessions
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// Basic Auth
		http.httpBasic();
		// Disable Csrf
		// Build object and return it else return null
		return http.build();
	}
	
	// UserDetails Bean In memory
	// {noop} no encoding
	@Bean
	public UserDetailsService userDetailService() {
		// In memory user
		User user = (User) User.withUsername("dariusG")
				.password("{noop}814015Db!")
				.roles("USER")
				.build();
		
		// In memory admin
		User admin = (User) User.withUsername("admin")
				.password("{noop} 814015Mo!")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	// Password Hashing using BcryptPasswordEncoder
	@Bean
	public BCryptPasswordEncoder passowordEncoder() {
		return new BCryptPasswordEncoder(16);
	}
	
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.DERBY)
//				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//				.build();
//	}
}
