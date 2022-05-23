package com.springboot.webapplication.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyErrorController implements ErrorController{
	@RequestMapping(value = "/error")
	public String handleError() {
		return "My Error!";
	}
}
