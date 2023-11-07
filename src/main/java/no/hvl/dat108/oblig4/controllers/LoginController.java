package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("login")
	public String getLogin(Model model) {
		return "innlogging";
	}

	@PostMapping("login")
	public String postLogin(Model model) {
		return "redirect:deltagerliste";
	}

	@PostMapping("logut")
	public String postUtlogging() {
		return "redirect:login";
	}
}
