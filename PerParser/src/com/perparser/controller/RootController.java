package com.perparser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    @RequestMapping(value = "/PerParser", method = RequestMethod.GET)
    public String root() {
    	System.out.print("asdasdasdas");
        return "index";
    }
}
