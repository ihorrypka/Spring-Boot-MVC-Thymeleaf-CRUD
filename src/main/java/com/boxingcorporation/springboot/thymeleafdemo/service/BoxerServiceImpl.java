package com.boxingcorporation.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import com.boxingcorporation.springboot.thymeleafdemo.dao.BoxerRepository;
import com.boxingcorporation.springboot.thymeleafdemo.entity.Boxer;

@Service
public class BoxerServiceImpl implements BoxerService {

	private BoxerRepository boxerRepository;
	
	@Autowired
	public BoxerServiceImpl(BoxerRepository theBoxerRepository) {
		boxerRepository = theBoxerRepository;
	}
	
	@Override
	public List<Boxer> findAll() {
	
		return boxerRepository.findAllByOrderByLastNameAsc();
		
	}

	@Override
	public Boxer findById(int theId) {
		
		Optional<Boxer> result = boxerRepository.findById(theId);
		
		Boxer theBoxer = null;
		
		if (result.isPresent()) {
			theBoxer = result.get();
		}
		else {
			// we didn't find the boxer
			throw new RuntimeException("Did not find boxer id - " + theId);
		}
		
		return theBoxer;
		
	}

	@Override
	public void save(Boxer theBoxer) {
		
		boxerRepository.save(theBoxer);
		
	}

	@Override
	public void deleteById(int theId) {
		
		boxerRepository.deleteById(theId);
		
	}

	@Override
	public List<Boxer> searchBy(String theFirstName, String theLastName) {

		return boxerRepository.
				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
						theFirstName, theLastName);
	}

}
