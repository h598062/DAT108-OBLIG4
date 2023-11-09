package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.controllers.DeltagerController;
import no.hvl.dat108.oblig4.controllers.LoginController;
import no.hvl.dat108.oblig4.controllers.PaameldingController;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.service.PaameldteService;
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

	@Autowired
	PassordService ps = new PassordService();

	@Autowired
	PaameldteService pss = new PaameldteService();


	// denne tester om spring boot applikasjon klarer å starte, og sjekker at autowired fungerer
	@Test
	void contextLoads() {
		assertNotNull(lc);
		assertNotNull(pc);
		assertNotNull(dc);
		assertNotNull(ps);
		assertNotNull(pss);
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
		String salt = ps.genererTilfeldigSalt();
		String passord = "passord";
		String hash = ps.hashMedSalt(passord, salt);
		assertTrue(ps.erKorrektPassord(passord, salt, hash));
	}

	@Test
	void testTidligereGenerertPassord() {
		String hash = "BC248D74DC5283A9EA7D67B750F809F2E474862DC298AD240E302B7C1331F34B";
		String salt = "3807EE1D3A686291FCCFEEA1BCCB8351";
		String passord = "superbestepassord123medæøå";
		assertTrue(ps.erKorrektPassord(passord, salt, hash));
	}

	@Test
	void testLagHashMedSammeSalt () {
		String hash = "BC248D74DC5283A9EA7D67B750F809F2E474862DC298AD240E302B7C1331F34B";
		String salt = "3807EE1D3A686291FCCFEEA1BCCB8351";
		String passord = "superbestepassord123medæøå";
		String hash2 = ps.hashMedSalt(passord, salt);
		assertEquals(hash, hash2);
	}
}
