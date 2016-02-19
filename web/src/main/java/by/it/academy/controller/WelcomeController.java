/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 023 23.05.2014
 */
package by.it.academy.controller;

import by.it.academy.pojos.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage() {

        Person person = new Person();
        person.setName("Name");
        person.setSurname("Surname");
        person.setAge(101);



        return "welcome";
    }

    @RequestMapping(value = "/login-fail", method = RequestMethod.GET)
    @RequestWrapper
    public String loginFail(ModelAndView model, @RequestParam(value = "login-fail") String error ) {
        if ("error".equals(error)) {
            model.addObject("error", "Authentication error");
        }

        return "welcome";
    }
}



