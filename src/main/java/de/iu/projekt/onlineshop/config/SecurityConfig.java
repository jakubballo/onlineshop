package de.iu.projekt.onlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity.authorizeHttpRequests(auth -> auth
				.requestMatchers("/","/produkte","/produkte/**","/kategorien","/registrieren","/login","/h2-console/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll()
						)
				.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
				.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
				.logout(logout -> logout.logoutSuccessUrl("/"))
				.build();
	}
}
