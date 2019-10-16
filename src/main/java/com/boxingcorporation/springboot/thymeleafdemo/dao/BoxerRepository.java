package com.boxingcorporation.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boxingcorporation.springboot.thymeleafdemo.entity.Boxer;

public interface BoxerRepository extends JpaRepository<Boxer, Integer> {
	
	// add a method to sort by last name
	public List<Boxer> findAllByOrderByLastNameAsc();
	
	// add a method to search by first name and last name
	public List<Boxer> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
									String theFirstName, String theLastName);

}
