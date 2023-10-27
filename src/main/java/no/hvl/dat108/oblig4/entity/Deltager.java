package no.hvl.dat108.oblig4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deltager", schema = "dat108_oblig4")
public class Deltager {
	@Id
	@Column(name = "mobil")
	private String mobil;
	@Basic
	@Column(name = "hash")
	private String hash;
	@Basic
	@Column(name = "salt")
	private String salt;
	@Basic
	@Column(name = "fornavn")
	private String fornavn;
	@Basic
	@Column(name = "etternavn")
	private String etternavn;
	@Basic
	@Column(name = "kjonn")
	private String kjonn;

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Deltager that = (Deltager) o;

		if (mobil != null ? !mobil.equals(that.mobil) : that.mobil != null) {
			return false;
		}
		if (hash != null ? !hash.equals(that.hash) : that.hash != null) {
			return false;
		}
		if (salt != null ? !salt.equals(that.salt) : that.salt != null) {
			return false;
		}
		if (fornavn != null ? !fornavn.equals(that.fornavn) : that.fornavn != null) {
			return false;
		}
		if (etternavn != null ? !etternavn.equals(that.etternavn) : that.etternavn != null) {
			return false;
		}
		if (kjonn != null ? !kjonn.equals(that.kjonn) : that.kjonn != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = mobil != null ? mobil.hashCode() : 0;
		result = 31 * result + (hash != null ? hash.hashCode() : 0);
		result = 31 * result + (salt != null ? salt.hashCode() : 0);
		result = 31 * result + (fornavn != null ? fornavn.hashCode() : 0);
		result = 31 * result + (etternavn != null ? etternavn.hashCode() : 0);
		result = 31 * result + (kjonn != null ? kjonn.hashCode() : 0);
		return result;
	}
}
