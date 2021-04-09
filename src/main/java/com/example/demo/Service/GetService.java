package com.example.demo.Service;

import com.example.demo.Bean.CsrfBean;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@Service
public class GetService {

    Logger logger = LoggerFactory.getLogger(GetService.class);

    public String welcomeSerivce(){
        return "Welcome.\n";
    }


    public CsrfBean getCsrfToken(HttpServletRequest request){
        CsrfBean csrfBean = new CsrfBean();
        CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
        csrfBean.setCsrfToken(token.getToken());
        return csrfBean;
    }
}
