package com.library.librarypurchaseservice.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Controller
public class CookieController {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMissingParameterException(MissingServletRequestParameterException ex) {
        return "Required parameter or cookie is missing: " + ex.getParameterName();
    }


    @RequestMapping(value = "/setCookie")
    public void cookie(HttpServletResponse response) throws IOException {
        Cookie cookie=new Cookie("cookieName",(int)(Math.random()*100000)+"");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect( "/");
    }
}
