package com.ttyc.spring.base.controller;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class CustomerErrorController extends BasicErrorController {

    public CustomerErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @RequestMapping(value = "${server.error.path:/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity error (){
        return null;
    }
}
