package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IGenderDAO;
import com.nissan.model.Gender;

@Service
public class GenderServiceImplementation implements IGenderService {

	@Autowired
	IGenderDAO genderDAO;
	
	@Override
	public Gender addGender(Gender gender) {
		return genderDAO.save(gender);
	}

	@Override
	public List<Gender> viewAllDetails() {
		return genderDAO.findAll();
	}

}
