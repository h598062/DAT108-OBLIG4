package no.hvl.dat108.oblig4.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {

	private static final int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, String username) {

		loggUtBruker(request.getSession());

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
		session.setAttribute("username", username);
	}

	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("username") != null && session.getAttribute("cart") != null;
	}

}
