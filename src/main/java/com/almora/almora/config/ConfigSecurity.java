package com.almora.almora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigSecurity {

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(
                                                                "/", "/index.html", "/login.html", "/register.html",
                                                                "/css/**", "/js/**", "/img/**")
                                                .permitAll()

                                                .requestMatchers("/admin.html").hasRole("ADMIN")
                                                .requestMatchers("/donante.html").hasRole("DONANTE")

                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login.html")
                                                .loginProcessingUrl("/login")
                                                .defaultSuccessUrl("/redirect", true)
                                                .failureUrl("/login.html?error=true")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login.html?logout=true"));

                return http.build();
        }
}