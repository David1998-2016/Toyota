package com.toyota.renovacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PagesController {

  @RequestMapping("/")
  public String irRaceBienvenido() {
    return "index";
  }
  @RequestMapping("/login")
	public String menu() {
		return "log-in";
	}

}
