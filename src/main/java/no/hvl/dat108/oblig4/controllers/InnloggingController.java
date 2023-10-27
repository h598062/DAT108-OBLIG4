package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InnloggingController {

	@GetMapping("innlogging")
	public String getInnlogging(Model model) {
		return "innlogging";
	}
}
