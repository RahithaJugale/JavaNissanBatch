package com.nissan.service;

import java.util.List;

import com.nissan.model.Patient;

public interface IPatientService {

	//list all patients
	List<Patient> listAllPatients();
	
	//add new patient
	Patient addNewPatient(Patient patient);
	
	//update patient
	Patient updatePatient(Patient patient);
	
	//delete patient
	Patient deletePatient(Integer _patientId);
}
