package com.RouteGaurd.app.configuration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import com.RouteGaurd.app.model.SuperAdmin;
import com.RouteGaurd.app.repositories.SuperAdminRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()) // Enable CORS
            .and()
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow preflight requests
                    .requestMatchers("/api/drivers/**").permitAll()
                    //.requestMatchers("/api/email/**").permitAll()
                    .requestMatchers("/api/customers/**").permitAll()
                    .requestMatchers("/api/vehicles/**").permitAll()
                    .requestMatchers("/api/trips/**").permitAll()
                    .requestMatchers("/api/superadmins/**").permitAll()
                    .requestMatchers("/api/admins/**").permitAll()
                    .requestMatchers("/api/registerDrivers/**").permitAll()
                    .requestMatchers("/api/registerCustomers/**").permitAll()
                    .anyRequest().authenticated() // Require authentication for other requests
            )
            .formLogin(formLogin -> formLogin.disable()) // Disable form login
            .httpBasic(); // Enable HTTP Basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            org.springframework.security.core.userdetails.User.withUsername("admin")
                .password("{noop}password")
                .roles("USER")
                .build()
        );
    }
    
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
  
}



























//package com.RouteGaurd.app.configuration;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////    	http
////        .authorizeRequests()
////        .requestMatchers("/drivers").hasRole("USER")
////        .anyRequest().authenticated()
////        .and()
////        .httpBasic();
//
//        http
//            .csrf(csrf -> csrf.disable())
//            //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/api/drivers/**").permitAll()
//                   // .requestMatchers("/api/driver-licenses/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .formLogin(formLogin -> formLogin.disable())
//            .httpBasic();
//        
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            org.springframework.security.core.userdetails.User.withUsername("admin")
//                .password("{noop}password")
//                .roles("USER")
//                .build()
//        );
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://localhost:3000");
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}







//import org.apache.catalina.filters.CorsFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
////import org.springframework.web.filter.CorsFilter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
////                    .requestMatchers("/api/admin/**").hasRole("ADMIN") // Only ADMIN role can access admin endpoints
////                    .requestMatchers("/api/customers/**").hasRole("USER") // USER role can access customer endpoints
//                    //.requestMatchers("/api/trips/**").permitAll() // Allow access to trips endpoints without authentication
//                    .requestMatchers("/api/goods/**").hasRole("ADMIN") // Allow access to drivers endpoints without authentication
//                    //.requestMatchers("/api/vehicles/**").hasRole("USER") // USER role can access vehicle endpoints
////                    .requestMatchers("/api/driver-licenses/**").hasRole("USER") // USER role can access driver license endpoints
////                    .requestMatchers("/api/superadmins/**").hasRole("SUPERADMIN") // Only SUPERADMIN role can access superadmin endpoints
////                    .requestMatchers("/api/goods/**").hasRole("ADMIN") // USER role can access goods endpoints
//                    .anyRequest().authenticated() // Require authentication for all other requests
//            )
//            .formLogin(formLogin -> formLogin.disable()) // Disable form login
//            .httpBasic(); // Enable HTTP Basic authentication
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            org.springframework.security.core.userdetails.User.withUsername("admin")
//                .password("{noop}adminpassword")
//                .roles("ADMIN")
//                .build(),
//            org.springframework.security.core.userdetails.User.withUsername("user")
//                .password("{noop}userpassword")
//                .roles("USER")
//                .build(),
//            org.springframework.security.core.userdetails.User.withUsername("superadmin")
//                .password("{noop}superadminpassword")
//                .roles("SUPERADMIN")
//                .build()
//        );
//    }
//    
//    @Bean
//    public FilterRegistrationBean coresFilter() {
//    	UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
//    	CorsConfiguration corsConfiguration = new CorsConfiguration();
//    	corsConfiguration.setAllowCredentials(true);
//    	corsConfiguration.addAllowedOriginPattern("*");
//    	corsConfiguration.addAllowedHeader("Authorization");
//    	corsConfiguration.addAllowedHeader("Content-Type");
//    	corsConfiguration.addAllowedHeader("Accept");
//    	corsConfiguration.addAllowedMethod("POST");
//    	corsConfiguration.addAllowedMethod("GET");
//    	corsConfiguration.addAllowedMethod("DELETE");
//    	corsConfiguration.addAllowedMethod("PUT");
//    	corsConfiguration.addAllowedMethod("OPTIONS");
//    	corsConfiguration.setMaxAge(3600L);
//    	
//    	source.registerCorsConfiguration("/**", corsConfiguration);
//    	
//    	FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter());
//    	return bean;
//    }
//}
//package com.RouteGaurd.app.configuration;
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.apache.catalina.filters.CorsFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/api/drivers/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .formLogin(formLogin -> formLogin.disable())
//            .httpBasic();
//
//        return http.build();
//    }
//    
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            org.springframework.security.core.userdetails.User.withUsername("admin")
//                .password("{noop}password")
//                .roles("USER")
//                .build()
//        );
//    }
//    
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .anyRequest().authenticated()
//           .and()
//            .httpBasic();
//    }
//
//    
//    
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("*")); // Allow all origins
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow these methods
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept")); // Allow these headers
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//    
//    @Bean
//  public FilterRegistrationBean coresFilter() {
//  	UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
//  	CorsConfiguration corsConfiguration = new CorsConfiguration();
//  	corsConfiguration.setAllowCredentials(true);
//  	corsConfiguration.addAllowedOriginPattern("*");
//  	corsConfiguration.addAllowedHeader("Authorization");
//  	corsConfiguration.addAllowedHeader("Content-Type");
//  	corsConfiguration.addAllowedHeader("Accept");
//  	corsConfiguration.addAllowedMethod("POST");
//  	corsConfiguration.addAllowedMethod("GET");
//  	corsConfiguration.addAllowedMethod("DELETE");
//  	corsConfiguration.addAllowedMethod("PUT");
//  	corsConfiguration.addAllowedMethod("OPTIONS");
//  	corsConfiguration.setMaxAge(3600L);
//  	
//  	source.registerCorsConfiguration("/**", corsConfiguration);
//  	
//  	FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter());
//  	return bean;
//  }
//
// }
//

































////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.builders.WebSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
////            .authorizeRequests(authorizeRequests ->
////                authorizeRequests
////                    .requestMatchers("/api/vehicles/**").permitAll() // Allow access to the drivers endpoint
////                    .anyRequest().authenticated() // Require authentication for other requests
////            )
////            .formLogin(formLogin -> formLogin.disable()) // Disable form login
////            .httpBasic(); // Enable HTTP Basic authentication
////
////        return http.build();
////    }
////
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            org.springframework.security.core.userdetails.User.withUsername("admin")
//                .password("{noop}password")
//                .roles("USER")
//                .build()
//        );
//    }
//}
//

