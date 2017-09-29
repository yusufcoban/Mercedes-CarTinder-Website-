package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Start {
    @RequestMapping("/")
    String home() {
        return "index";
    }
    
    @RequestMapping("/demo")
    String home2() {
        return "index2";
    }
    
    @RequestMapping("/repo")
    String home3() {
        return "index3";
    }
    
    
	
	
    
}