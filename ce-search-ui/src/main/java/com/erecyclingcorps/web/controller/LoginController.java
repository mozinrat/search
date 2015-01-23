package com.erecyclingcorps.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author parora
 **/

@Controller
public class LoginController {

    private static final String LOGIN_PAGE = "login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return LOGIN_PAGE;
    }

}