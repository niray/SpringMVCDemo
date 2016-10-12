package com.niray.controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class BaseMultiController {

    protected ModelAndView toView(final String url, final Map<String, Object> map) {
        ModelAndView view = new ModelAndView(url);
        return view;
    }
}