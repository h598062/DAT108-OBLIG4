package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.service.PaameldteService;
import no.hvl.dat108.oblig4.service.PassordService;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@Autowired
	private PassordService passordService;

	@Autowired
	private PaameldteService paameldteService;

	@GetMapping("login")
	public String getLogin(Model model) {
		return "innlogging";
	}

	@PostMapping("login")
	public String postLogin(
			RedirectAttributes ra, HttpServletRequest request, @RequestParam String passord, @RequestParam String mobil) {

		System.out.println("mobil: " + mobil);
		System.out.println("passord: " + passord);
		if (LoginUtil.sjekkMobil(paameldteService.hentDeltagere(), mobil)) {
			ra.addFlashAttribute("feilmelding", "Finner ikke bruker med dette mobilnummeret");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}
		// deltager finnes
		Deltager deltager = paameldteService.getDeltager(mobil);
		if (passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
			ra.addFlashAttribute("feilmelding", "Passord er feil");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}
		// passord er korrekt

		LoginUtil.loggInnBruker(request, deltager);


		return "redirect:deltagerliste";
	}

	@PostMapping("logut")
	public String postUtlogging() {
		return "redirect:login";
	}
}
