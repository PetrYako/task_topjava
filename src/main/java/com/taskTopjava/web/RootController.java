package com.taskTopjava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

    @GetMapping("/")
    public ModelAndView root() {
        return new ModelAndView("redirect:" + "restaurants");
    }
}
