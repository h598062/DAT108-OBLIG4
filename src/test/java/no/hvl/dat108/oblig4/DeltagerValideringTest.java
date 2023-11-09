package no.hvl.dat108.oblig4;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.hvl.dat108.oblig4.entity.Deltager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeltagerValideringTest {

	private Validator validator = Validation.buildDefaultValidatorFactory()
	                                        .getValidator();

	@ParameterizedTest
	@ValueSource(strings = {"Arne", "Hans", "Lars-P"})
	void gyldigeFornavn(String navnFraListe) {
		Deltager deltager = new Deltager();
		deltager.setFornavn(navnFraListe);
		assertTrue(erGyldigEgenskap(deltager, "fornavn"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "A", "23"})
	void ugyldigeFornavn(String navnFraListe) {
		Deltager deltager = new Deltager();
		deltager.setFornavn(navnFraListe);
		assertFalse(erGyldigEgenskap(deltager, "fornavn"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"lalala", "Aallal", "Hans", "Lars-P"})
	void gyldigeEtternavn(String navnFraListe) {
		Deltager deltager = new Deltager();
		deltager.setEtternavn(navnFraListe);
		assertTrue(erGyldigEgenskap(deltager, "etternavn"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "A", "23"})
	void ugyldigeEtternavn(String navnFraListe) {
		Deltager deltager = new Deltager();
		deltager.setFornavn(navnFraListe);
		assertFalse(erGyldigEgenskap(deltager, "fornavn"));
	}

	/***********************************************************************/

	private boolean erGyldigEgenskap(Deltager deltager, String egenskap) {
		return !validator.validate(deltager)
		                 .stream()
		                 .map(v -> v.getPropertyPath()
		                            .toString())
		                 .collect(Collectors.toSet())
		                 .contains(egenskap);
	}
}
