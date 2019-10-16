package com.boxingcorporation.springboot.thymeleafdemo.service;

import java.util.List;

import com.boxingcorporation.springboot.thymeleafdemo.entity.Boxer;

public interface BoxerService {
	
	public List<Boxer> findAll();
	
	public Boxer findById(int theId);
	
	public void save(Boxer theBoxer);
	
	public void deleteById(int theId);
	
	public List<Boxer> searchBy(String theFirstName, String theLastName);

}
