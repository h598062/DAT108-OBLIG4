package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerController {

	@GetMapping("deltagerliste")
	public String getDeltagerListe(Model model) {
		return "deltagerliste";
	}

	@GetMapping("/")
	public String rootPaamelding(Model model) {
		return "paamelding";
	}

	@GetMapping("paamelding")
	public String getPaamelding(Model model) {
		return "paamelding";
	}

	@GetMapping("paameldt")
	public String getPaameldt(Model model) {
		return "paameldt";
	}

	@GetMapping("innlogging")
	public String getInnlogging(Model model) {
		return "innlogging";
	}
}
