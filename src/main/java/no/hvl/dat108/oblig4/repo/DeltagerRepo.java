package no.hvl.dat108.oblig4.repo;

import no.hvl.dat108.oblig4.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeltagerRepo extends JpaRepository<Deltager, Integer> {

	/**
	 * Legg til en ny deltager i database
	 *
	 * @param deltager deltageren som skal lagres
	 *
	 * @return den lagrede deltageren
	 */
	//Deltager save(Deltager deltager);

	/**
	 * Hent ut en deltager med gitt mobilnummer fra databasen
	 *
	 * @param mobil mobilnummeret til deltageren som skal hentes
	 *
	 * @return deltageren
	 */
	Deltager findByMobil(String mobil);

	/**
	 * Henter alle deltagerne fra databasen.
	 *
	 * @return alle deltagerne
	 */
	//List<Deltager> findAll();

	/**
	 * Sletter en deltager med gitt mobilnummer fra databasen
	 *
	 * @param mobil mobilnummeret til deltageren som skal slettes
	 */
	void deleteDeltagerByMobil(String mobil);
}
