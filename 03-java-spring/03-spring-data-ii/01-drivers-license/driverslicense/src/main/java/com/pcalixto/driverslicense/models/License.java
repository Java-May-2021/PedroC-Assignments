package com.pcalixto.driverslicense.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity()
@Table(name="hmk_java030301_licenses")
public class License {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 2)
	private String state;

	// @Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Expiration cannot be nothing")
	private Date expiration;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id", nullable=false)
	@NotNull(message="Person cannot be nothing")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public License() {
		
	}

	public License(String state, Date expiration) {
		this.state = state;
		this.expiration = expiration;
	}
}
