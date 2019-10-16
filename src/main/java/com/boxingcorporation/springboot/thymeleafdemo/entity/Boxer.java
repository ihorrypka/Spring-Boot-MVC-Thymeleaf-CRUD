package com.boxingcorporation.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="boxer")
public class Boxer {

	// define fields
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="is required")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="is required")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="is required")
	@Column(name="nationality")
	private String nationality;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Column(name="total_fights")
	private Integer totalFights;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Column(name="wins")
	private Integer wins;
	
	@NotBlank(message="is required")
	@Column(name="twitter")
	private String twitter;
	
	// define constructors
	
	public Boxer() {
		
	}

	public Boxer(int id, String firstName, String lastName, String nationality, 
				Integer totalFights, Integer wins, String twitter) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.totalFights = totalFights;
		this.wins = wins;
		this.twitter = twitter;
	}

	public Boxer(String firstName, String lastName, String nationality, 
				Integer totalFights, Integer wins, String twitter) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.totalFights = totalFights;
		this.wins = wins;
		this.twitter = twitter;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getTotalFights() {
		return totalFights;
	}

	public void setTotalFights(Integer totalFights) {
		this.totalFights = totalFights;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	// define toString
	
	@Override
	public String toString() {
		return "Boxer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationality + ", totalFights=" + totalFights + ", wins=" + wins + ", twitter=" + twitter + "]";
	}		
	
}
