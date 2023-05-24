package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/prova")
public class MyController {

	@GetMapping("/")
	@ResponseBody
	public String sayHello() {
		
		return "<h1>Prova!</h1>";
	}
	
	@GetMapping("/ciao")
	@ResponseBody
	public String sayHelloIta() {
		
		return "<h1>Ciao, Mondo!</h1>";
	}
	
	@GetMapping("/hola")
	public String sayHelloSp(Model model,
			@RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/user/{id}")
	public String sayHelloToId(Model model,
			@PathVariable("id") int id) {
		
		model.addAttribute("name", "Guybrush " + id);
		
		return "index";
	}
}
