package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.repo.DeltagerRepo;
import no.hvl.dat108.oblig4.service.PaameldteService;
import no.hvl.dat108.oblig4.service.PassordService;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeltagerController {

	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	private PassordService passordService;

	@Autowired
	private DeltagerRepo deltagerRepo;

	@GetMapping("deltagerliste")
	public String getDeltagerListe(HttpSession session, Model model, RedirectAttributes ra) {
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("feilmelding", "Du må være logget inn for å se deltagerlisten");
			return "redirect:login";
		}
		//model.addAttribute("deltagere", paameldteService.hentDeltagere());
		model.addAttribute("deltagere", deltagerRepo.findAll());

		return "deltagerliste";
	}


}
