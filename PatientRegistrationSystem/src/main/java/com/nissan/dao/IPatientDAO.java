package com.nissan.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Patient;

@Repository
public interface IPatientDAO extends JpaRepositoryImplementation<Patient, Integer> {

	
}
