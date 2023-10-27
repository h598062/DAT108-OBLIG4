package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping(value = "hello", produces = "text/plain")
	@ResponseBody
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("hellojsp")
	public String helloJSP(Model model, @RequestParam(value = "myName", defaultValue = "World") String name) {
		System.out.println("HelloController: " + name);
		model.addAttribute("name", name);
		return "hello";
	}
}
