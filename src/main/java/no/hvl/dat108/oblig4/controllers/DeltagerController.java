package no.hvl.dat108.oblig4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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

	@PostMapping("paamelding")
	public String submitPaamelding(Model model, @RequestParam(value = "fornavn") String fornavn,
	                               @RequestParam(value = "etternavn") String etternavn,
	                               @RequestParam(value = "mobil") String mobil,
	                               @RequestParam(value = "passord") String passord,
	                               @RequestParam(value = "passordRepetert") String passordRepetert,
	                               @RequestParam(value = "kjonn") String kjonn) {
		System.out.printf("%s %s %s %s %s %s%n",fornavn, etternavn, mobil, passord, passordRepetert, kjonn);
		Map<String, String> map = Map.of("fornavn", fornavn, "etternavn", etternavn, "mobil", mobil,
				"kjonn", kjonn);
		model.addAttribute("p", map);
		return "paameldt";
	}
}
