package com.example.SeatBooking.Security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
public class SecurityConfig

{
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .httpBasic(configurer -> configurer.disable())
      .csrf(customizer -> customizer.disable())
      .cors(customizer -> customizer.configurationSource(this.corsConfig()))
      .authorizeRequests(auth -> auth.anyRequest().permitAll())
      .build();
  }

  private CorsConfigurationSource corsConfig() {
    CorsConfiguration configuration = new CorsConfiguration();
    List<String> allowOrigins = Arrays.asList("*");
    configuration.setAllowedOriginPatterns(allowOrigins);
    configuration.setAllowedMethods(singletonList("*"));
    configuration.setAllowedHeaders(singletonList("*"));
    //in case authentication is enabled this flag MUST be set, otherwise CORS requests will fail
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
