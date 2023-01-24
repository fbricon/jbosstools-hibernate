package org.gen;

// Generated Mar 5, 2015 8:03:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Country generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COUNTRY", schema = "PUBLIC", catalog = "SAKILA")
public class Country implements java.io.Serializable {

	private short countryId;
	private String country;
	private Date lastUpdate;
	private Set<City> cities = new HashSet<City>(0);
	private Set<City> cities_1 = new HashSet<City>(0);

	public Country() {
	}

	public Country(short countryId, String country, Date lastUpdate) {
		this.countryId = countryId;
		this.country = country;
		this.lastUpdate = lastUpdate;
	}

	public Country(short countryId, String country, Date lastUpdate,
			Set<City> cities, Set<City> cities_1) {
		this.countryId = countryId;
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.cities = cities;
		this.cities_1 = cities_1;
	}

	@Id
	@Column(name = "COUNTRY_ID", unique = true, nullable = false)
	public short getCountryId() {
		return this.countryId;
	}

	public void setCountryId(short countryId) {
		this.countryId = countryId;
	}

	@Column(name = "COUNTRY", nullable = false, length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE", nullable = false, length = 23)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities_1() {
		return this.cities_1;
	}

	public void setCities_1(Set<City> cities_1) {
		this.cities_1 = cities_1;
	}

}
