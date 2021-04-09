package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.*;

import org.springframework.security.web.csrf.CsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**")
//                .permitAll();

        http
                .requiresChannel()
                .anyRequest()
                .requiresSecure()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());


//        http.csrf().disable();
    }


////    @Override
//    protected  void configure(HttpSecurity httpSecurity) throws Exception {
//        CsrfTokenResponseHeaderBindingFilterConfig csrfTokenFilter = new CsrfTokenResponseHeaderBindingFilterConfig();
//        CustomAccessDeniedHandler accessDeniedHandler = new CustomAccessDeniedHandler();
//        httpSecurity.addFilterAfter(csrfTokenFilter, CsrfFilter.class)
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//
//    }
//
//    /**
//     * Build csrf Token repo
//     * @return
//     */
//    private CsrfTokenRepository csrfTokenRepository()
//    {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setSessionAttributeName("_csrf");
//        logger.info("add _csrf value");
//        return repository;
//    }
//
//    /**
//     * custom handle with invalid csrf Token
//     */
//    static class CustomAccessDeniedHandler implements AccessDeniedHandler {
//        public void handle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           AccessDeniedException accessDeniedException)
//                throws IOException, ServletException {
//            response.getWriter().write("access deny");
//        }
//    }


}
