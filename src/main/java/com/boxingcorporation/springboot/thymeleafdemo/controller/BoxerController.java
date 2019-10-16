package com.boxingcorporation.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxingcorporation.springboot.thymeleafdemo.entity.Boxer;
import com.boxingcorporation.springboot.thymeleafdemo.service.BoxerService;

@Controller
@RequestMapping("/boxers")
public class BoxerController {
	
	private BoxerService boxerService;
	
	@Autowired
	public BoxerController(BoxerService theBoxerService) {
		boxerService = theBoxerService;
	}
	
	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listBoxers(Model theModel) {
		
		// get boxers from db
		List<Boxer> theBoxers = boxerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("boxers", theBoxers);
		
		return "boxers/list-boxers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Boxer theBoxer = new Boxer();
		
		theModel.addAttribute("boxer", theBoxer);
		
		return "boxers/boxer-form";
		
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("boxerId") int theId,
									Model theModel) {
		
		// get the boxer from the service
		Boxer theBoxer = boxerService.findById(theId);
		
		// set boxer as a model attribute to pre-populate the form
		theModel.addAttribute("boxer", theBoxer);
		
		// send over to our form
		return "boxers/boxer-form";
	}
	
	
	@PostMapping("/save")
	public String saveBoxer(
			@ModelAttribute("boxer") @Valid Boxer theBoxer,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "boxers/boxer-form";
		}
		else {
			
			// save the boxer
			boxerService.save(theBoxer);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/boxers/list";
		}
			
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("boxerId") int theId) {
		
		// delete the boxer
		boxerService.deleteById(theId);
		
		// redirect to /boxers/list
		return "redirect:/boxers/list";
		
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 @RequestParam("lastName") String theLastName,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all boxers
		
		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			
			return "redirect:/boxers/list";
			
		}
		else {
			
			// else, search by first name and last name
			List<Boxer> theBoxers = 
					boxerService.searchBy(theFirstName, theLastName);
			
			// add to the spring model
			theModel.addAttribute("boxers", theBoxers);
			
			// send to list-boxers
			
			return "boxers/list-boxers";
			
		}
		
	}
	
}
