package com.nissan.service;

import java.util.List;

import com.nissan.model.Gender;

public interface IGenderService {

	//add gender
	Gender addGender(Gender gender);
	
	//list all details in gender entity
	List<Gender> viewAllDetails();
}
