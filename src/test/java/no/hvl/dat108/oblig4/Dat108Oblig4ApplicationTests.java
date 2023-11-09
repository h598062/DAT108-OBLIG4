package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.controllers.DeltagerController;
import no.hvl.dat108.oblig4.controllers.LoginController;
import no.hvl.dat108.oblig4.controllers.PaameldingController;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.service.PassordService;
import no.hvl.dat108.oblig4.util.LoginUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Dat108Oblig4ApplicationTests {

	@Autowired
	LoginController lc = new LoginController();

	@Autowired
	PaameldingController pc = new PaameldingController();

	@Autowired
	DeltagerController dc = new DeltagerController();


	// denne tester om spring boot applikasjon klarer å starte
	@Test
	void contextLoads() {
		assertNotNull(lc);
		assertNotNull(pc);
		assertNotNull(dc);
	}


	@Test
	void sjekkMobilTrue() {
		List<Deltager> liste = new ArrayList<>();
		Deltager deltager = new Deltager();
		deltager.setMobil("12345678");
		liste.add(deltager);

		boolean resultat = LoginUtil.sjekkMobil(liste, "12345678");

		assertTrue(resultat);
	}

	@Test
	void sjekkMobilFalse() {
		List<Deltager> liste = new ArrayList<>();
		Deltager deltager = new Deltager();
		deltager.setMobil("12345678");
		liste.add(deltager);

		boolean resultat = LoginUtil.sjekkMobil(liste, "1234567");

		assertFalse(resultat);
	}

	@Test
	void testPassordService() {
		PassordService p = new PassordService();
		String salt = p.genererTilfeldigSalt();
		String passord = "passord";
		String hash = p.hashMedSalt(passord, salt);
		assertTrue(p.erKorrektPassord(passord, salt, hash));
	}
}
