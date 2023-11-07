package no.hvl.dat108.oblig4.controllers;

import jakarta.validation.Valid;
import no.hvl.dat108.oblig4.service.PaameldteService;
import no.hvl.dat108.oblig4.service.PassordService;
import no.hvl.dat108.oblig4.entity.Deltager;
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

	@PostMapping("paamelding")
	public String postPaamelding(
			@Valid @ModelAttribute("deltager") Deltager deltager, RedirectAttributes ra, BindingResult bindingResult, @RequestParam String passord) {
		if (bindingResult.hasErrors()) {
			String feilmeldinger = bindingResult.getAllErrors()
			                                    .stream()
			                                    .map(e -> e.getDefaultMessage())
			                                    .reduce("", (f, e) -> f + e + "<br>");
			ra.addFlashAttribute("feilmeldinger", feilmeldinger);
			ra.addFlashAttribute("feilmelding", "Feil i skjema");
			System.out.println("asjdklasd");
			return "redirect:paamelding";
		}
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(passord, salt);
		deltager.setSalt(salt);
		deltager.setHash(hash);
		paameldteService.leggTilDeltager(deltager);
		ra.addFlashAttribute("deltager", deltager);

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
