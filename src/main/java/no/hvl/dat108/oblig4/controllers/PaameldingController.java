package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import no.hvl.dat108.oblig4.repo.DeltagerRepo;
import no.hvl.dat108.oblig4.service.PaameldteService;
import no.hvl.dat108.oblig4.service.PassordService;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaameldingController {

	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	private PassordService passordService;

	@Autowired
	private DeltagerRepo deltagerRepo;

	@GetMapping("/")
	public String getIndex() {
		return "redirect:paamelding";
	}

	@PostMapping("paamelding")
	public String postPaamelding(
			@Valid @ModelAttribute("deltager") Deltager deltager, RedirectAttributes ra,
			BindingResult bindingResult, @RequestParam String passord,
			HttpServletRequest request) {
		ra.addFlashAttribute("deltager", deltager);
		if (bindingResult.hasErrors()) {
			String feilmeldinger = bindingResult.getAllErrors()
			                                    .stream()
			                                    .map(e -> e.getDefaultMessage())
			                                    .reduce("", (f, e) -> f + e + "<br>");
			ra.addFlashAttribute("feilmeldinger", feilmeldinger);
			return "redirect:paamelding";
		}
		if (deltagerRepo.findById(deltager.getMobil()).isPresent()) {
			ra.addFlashAttribute("feilmeldinger", "Mobilnummeret er allerede registrert");
			return "redirect:paamelding";
		}
		if (passord.length() < 5) {
			ra.addFlashAttribute("feilmeldinger", "Passordet må være minst 5 tegn");
			return "redirect:paamelding";
		}
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(passord, salt);
		deltager.setSalt(salt);
		deltager.setHash(hash);
		LoginUtil.loggInnBruker(request, deltager);
		//paameldteService.leggTilDeltager(deltager);
		deltagerRepo.save(deltager);
		return "redirect:paameldt";
	}

	@GetMapping("paamelding")
	public String getPaamelding(Model model) {
		return "paamelding";
	}

	@GetMapping("paameldt")
	public String getPaameldt(Model model) {
		return "paameldt";
	}
}
