package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepo;
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

import java.util.Optional;

@Controller
public class LoginController {

	@Autowired
	private PassordService passordService;

	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	DeltagerRepo deltagerRepo;

	@GetMapping("login")
	public String getLogin(Model model) {
		/* Test bruker for liste implementajson
		if (paameldteService.isFirst()) {
			Deltager d = new Deltager();
			d.setSalt(passordService.genererTilfeldigSalt());
			d.setHash(passordService.hashMedSalt("passord", d.getSalt()));
			d.setFornavn("Ola");
			d.setEtternavn("Nordmann");
			d.setMobil("12345678");
			d.setKjonn("mann");
			paameldteService.leggTilDeltager(d);
			paameldteService.setFirst(false);
		}
		*/
		return "innlogging";
	}

	@PostMapping("login")
	public String postLogin(
			RedirectAttributes ra, HttpServletRequest request, @RequestParam String passord, @RequestParam String mobil) {
		if (LoginUtil.erBrukerInnlogget(request.getSession())) {
			return "redirect:deltagerliste";
		}
		Optional<Deltager> deltagerOptional = deltagerRepo.findById(mobil);
		if (deltagerOptional.isEmpty()) {
			ra.addFlashAttribute("feilmelding", "Ugyldig brukernavn og/eller passord");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}

		Deltager deltager = deltagerOptional.get();

		/* Gammel liste implementasjon
		if (!LoginUtil.sjekkMobil(paameldteService.hentDeltagere(), mobil)) {
			ra.addFlashAttribute("feilmelding", "Finner ikke bruker med dette mobilnummeret");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}
		Deltager deltager = paameldteService.getDeltager(mobil);
		*/
		// deltager finnes
		if (!passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
			ra.addFlashAttribute("feilmelding", "Ugyldig brukernavn og/eller passord");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}
		// passord er korrekt

		LoginUtil.loggInnBruker(request, deltager);


		return "redirect:deltagerliste";
	}

	@PostMapping("logut")
	public String postUtlogging(RedirectAttributes ra, HttpServletRequest request) {
		LoginUtil.loggUtBruker(request.getSession());
		ra.addFlashAttribute("feilmelding", "Du er nå logget ut");
		return "redirect:login";
	}
}
