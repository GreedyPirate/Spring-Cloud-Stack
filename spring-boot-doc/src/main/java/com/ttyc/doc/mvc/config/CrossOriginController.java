package com.ttyc.doc.mvc.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
public class CrossOriginController {

    @GetMapping("cross")
    @CrossOrigin(origins = "http://cross.com")
    public String cross(){
        return "cross origin";
    }
}
