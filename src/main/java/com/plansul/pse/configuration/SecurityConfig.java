package com.plansul.pse.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	AuthenticationProvider authenticationProvider;
	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	//    public SecurityConfiguration(
	//        JwtAuthenticationFilter jwtAuthenticationFilter,
	//        AuthenticationProvider authenticationProvider
	//    ) {
	//        this.authenticationProvider = authenticationProvider;
	//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	//    }

	private static final String[] AUTH_WHITELIST = {
			"/api/v1/auth/**",
			"/v3/api-docs/**",
			"/v3/api-docs.yaml",
			"/swagger-ui/**",
			"/swagger-ui.html",
			"/swagger-ui/index.html",
			"/auth/**"
	};

	



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.csrf(AbstractHttpConfigurer::disable)
		.cors(cors -> cors.configurationSource(corsConfigurationSource()))
		.authorizeHttpRequests(
				request -> request
				.requestMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll()
				.requestMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
				.requestMatchers("/v3/api-docs/**", "/swagger-ui/**","/auth/**").permitAll()
				.anyRequest().authenticated()
				)
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowedOrigins(List.of("*"));
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", config);

		return source;

	}

}
