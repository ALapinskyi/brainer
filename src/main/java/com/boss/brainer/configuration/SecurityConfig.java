package com.boss.brainer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http

                .requestMatchers()
                .requestMatchers(request -> !"/api".equals(request.getServletPath()))
                //.antMatchers("/**")
                //.antMatchers("/api/**" )
                .antMatchers("/oauth/authorize")
                .and()
                .authorizeRequests()
                .antMatchers("/hello").authenticated()
                //.antMatchers("/api/**").authenticated()
                .and()
                .formLogin().permitAll();
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
        auth.parentAuthenticationManager(authenticationManagerBean() )
                .inMemoryAuthentication()
                .withUser("john")
                .password("123")
                .roles("USER");
    } */


    @Override
    public void configure(WebSecurity web) throws Exception {

        /*web
                .ignoring()
                .antMatchers("/");*/

    }

    /*private static class BasicRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            //String auth = request.getHeader("Authorization");
            String path = request.getServletPath();
            return !"/api".equals(path) /*|| (auth != null && auth.startsWith("Bearer"))*/;
    //    }
    //}
}
