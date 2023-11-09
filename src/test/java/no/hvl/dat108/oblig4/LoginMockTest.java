package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.controllers.LoginController;
import no.hvl.dat108.oblig4.entity.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepo;
import no.hvl.dat108.oblig4.service.PassordService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginMockTest {

	@Mock
	DeltagerRepo mockedDeltagerRepo;

	@Mock
	PassordService mockedPassordService;

	@InjectMocks
	LoginController loginController;

	static Deltager d;

	static String mobil = "12345678";
	static String passord = "superbestepassord123medæøå";

	@BeforeAll
	static void setup() {
		d = new Deltager();
		d.setMobil(mobil);
		d.setHash("BC248D74DC5283A9EA7D67B750F809F2E474862DC298AD240E302B7C1331F34B");
		d.setSalt("3807EE1D3A686291FCCFEEA1BCCB8351");
		d.setFornavn("Ola");
		d.setEtternavn("Nordmann");
		d.setKjonn("mann");
	}

	@Test
	void testLoginMedFeilMobil() {

		when(mockedDeltagerRepo.findById(mobil)).thenReturn(Optional.empty());

		RedirectAttributes ra = new RedirectAttributesModelMap();

		String redirect = loginController.postLogin(ra, new MockHttpServletRequest(), passord, mobil);

		assertEquals(
				"Ugyldig brukernavn og/eller passord",
				ra.getFlashAttributes()
				  .get("feilmelding"));
		assertEquals("redirect:login", redirect);
	}

	@Test
	void testLoginMedRiktigMobilFeilPassord() {

		when(mockedDeltagerRepo.findById(mobil)).thenReturn(Optional.of(d));
		when(mockedPassordService.erKorrektPassord(passord, d.getSalt(), d.getHash())).thenReturn(false);

		RedirectAttributes ra = new RedirectAttributesModelMap();

		String redirect = loginController.postLogin(ra, new MockHttpServletRequest(), passord, mobil);

		assertEquals(
				"Ugyldig brukernavn og/eller passord",
				ra.getFlashAttributes()
				  .get("feilmelding"));
		assertEquals("redirect:login", redirect);
	}

	@Test
	void testLoginMedRiktigMobilRiktigPassord() {

		when(mockedDeltagerRepo.findById(mobil)).thenReturn(Optional.of(d));
		when(mockedPassordService.erKorrektPassord(passord, d.getSalt(), d.getHash())).thenReturn(true);

		RedirectAttributes ra = new RedirectAttributesModelMap();

		String redirect = loginController.postLogin(ra, new MockHttpServletRequest(), passord, mobil);

		assertNull(ra.getFlashAttributes()
		             .get("feilmelding"));
		assertEquals("redirect:deltagerliste", redirect);
	}
}
