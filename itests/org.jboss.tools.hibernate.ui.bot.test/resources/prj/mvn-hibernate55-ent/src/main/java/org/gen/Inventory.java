package org.gen;

// Generated Mar 5, 2015 8:03:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Inventory generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "INVENTORY", schema = "PUBLIC", catalog = "SAKILA")
public class Inventory implements java.io.Serializable {

	private int inventoryId;
	private Film film;
	private Store store;
	private Date lastUpdate;
	private Set<Rental> rentals = new HashSet<Rental>(0);
	private Set<Rental> rentals_1 = new HashSet<Rental>(0);

	public Inventory() {
	}

	public Inventory(int inventoryId, Film film, Store store, Date lastUpdate) {
		this.inventoryId = inventoryId;
		this.film = film;
		this.store = store;
		this.lastUpdate = lastUpdate;
	}

	public Inventory(int inventoryId, Film film, Store store, Date lastUpdate,
			Set<Rental> rentals, Set<Rental> rentals_1) {
		this.inventoryId = inventoryId;
		this.film = film;
		this.store = store;
		this.lastUpdate = lastUpdate;
		this.rentals = rentals;
		this.rentals_1 = rentals_1;
	}

	@Id
	@Column(name = "INVENTORY_ID", unique = true, nullable = false)
	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILM_ID", nullable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STORE_ID", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE", nullable = false, length = 23)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals_1() {
		return this.rentals_1;
	}

	public void setRentals_1(Set<Rental> rentals_1) {
		this.rentals_1 = rentals_1;
	}

}
