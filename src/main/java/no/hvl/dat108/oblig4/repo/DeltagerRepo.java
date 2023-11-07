package no.hvl.dat108.oblig4.repo;

import no.hvl.dat108.oblig4.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepo extends JpaRepository<Deltager, Integer> {

	Deltager findByMobil(String mobil);
}
