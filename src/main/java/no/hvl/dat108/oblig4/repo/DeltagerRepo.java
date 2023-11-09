package no.hvl.dat108.oblig4.repo;

import no.hvl.dat108.oblig4.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeltagerRepo extends JpaRepository<Deltager, String> {
}
