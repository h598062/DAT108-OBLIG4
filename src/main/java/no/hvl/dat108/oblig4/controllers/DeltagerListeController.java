package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerListeController {

	@GetMapping("deltagerliste")
	public String getInnlogging(Model model) {
		return "deltagerliste";
	}
}