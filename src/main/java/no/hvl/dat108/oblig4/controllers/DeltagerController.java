package no.hvl.dat108.oblig4.controllers;

import no.hvl.dat108.oblig4.PaameldteService;
import no.hvl.dat108.oblig4.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeltagerController {

	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	private PassordService passordService;

	@GetMapping("deltagerliste")
	public String getDeltagerListe(Model model) {
		model.addAttribute("deltagere", paameldteService.hentDeltagere());
		return "deltagerliste";
	}


}
