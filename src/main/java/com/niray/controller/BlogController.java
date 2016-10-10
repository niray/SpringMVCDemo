package com.niray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mac on 16/10/10.
 */
@Controller
public class BlogController {

    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
    public String listOfBlog() {
        return "blog/blogs";
    }
}
