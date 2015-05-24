package edu.usc.lunchnlearn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wfleming on 5/22/15.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printIndex(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome to Lunch-n-Learn");
        return "index";
    }

}
