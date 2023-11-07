package no.hvl.dat108.oblig4.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.entity.Deltager;

import java.util.List;

public class LoginUtil {

	private static final int MAX_INTERACTIVE_INTERVAL = 10 * 60;

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {

		loggUtBruker(request.getSession());

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
		session.setAttribute("bruker", deltager);
	}

	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("bruker") != null;
	}

	/**
	 * Sjekker om en deltager med gitt mobilnummer finnes i listen over påmeldte.
	 *
	 * @param deltagere Liste over deltagerne som skal sjekkes
	 * @param mobil     Mobilnummeret til deltageren som skal sjekkes
	 *
	 * @return true om deltageren finnes, ellers false
	 */
	public static boolean sjekkMobil(List<Deltager> deltagere, String mobil) {
		if (mobil == null || mobil.trim()
		                          .isEmpty()) {
			return false;
		}
		if (deltagere == null || deltagere.isEmpty()) {
			return false;
		}
		return deltagere.stream()
		                .anyMatch(d -> d.getMobil()
		                                .equals(mobil));
	}

}
