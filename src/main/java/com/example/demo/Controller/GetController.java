package com.example.demo.Controller;

import com.example.demo.Bean.CsrfBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Service.GetService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


@RestController
public class GetController {

    @Autowired
    GetService getService;

    Logger logger = LoggerFactory.getLogger(GetController.class);


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welecome(){
        return getService.welcomeSerivce();
    }

    @RequestMapping(value="/getCsrfToken", method=RequestMethod.GET)
    public @ResponseBody
    CsrfBean getCsrfToken(HttpServletRequest request) {

        return getService.getCsrfToken(request);
    }


}
