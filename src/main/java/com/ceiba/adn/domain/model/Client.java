package com.ceiba.adn.domain.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clients")
public class Client{
	
	@Id
	@Column(length = 10)
	private long identification;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Column(unique = true)
	private String telephone;
		
	public Client(long identification, String name, String lastName, String telephone) {
		this.identification = identification;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
	}	

	public Client() {		
	}	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
