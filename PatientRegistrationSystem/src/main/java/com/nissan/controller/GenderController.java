package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Gender;
import com.nissan.service.IGenderService;

@RestController
@RequestMapping("api/")
public class GenderController {
	
	@Autowired
	IGenderService genderService;
	
	//adding gender
	@PostMapping("genders")
	public Gender addGender(@RequestBody Gender gender) {
		return genderService.addGender(gender);
	}
	
	//listing all genders
	@GetMapping("genders")
	public List<Gender> viewAllDetails() {
		return genderService.viewAllDetails();
	}

}
