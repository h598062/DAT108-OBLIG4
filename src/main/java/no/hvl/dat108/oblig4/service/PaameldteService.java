package no.hvl.dat108.oblig4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import no.hvl.dat108.oblig4.entity.Deltager;

@Service
public class PaameldteService {
	private final List<Deltager> paameldte = new ArrayList<>();

	public void leggTilDeltager(Deltager deltager) {
		paameldte.add(deltager);
	}

	public List<Deltager> hentDeltagere() {
		return paameldte;
	}

}
