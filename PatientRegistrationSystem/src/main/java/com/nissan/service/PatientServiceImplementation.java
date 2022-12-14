package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IPatientDAO;
import com.nissan.model.Patient;

@Service
public class PatientServiceImplementation implements IPatientService {

	@Autowired
	IPatientDAO patientDAO;
	
	//list all patients
	@Override
	public List<Patient> listAllPatients() {
		return patientDAO.findAll();
	}

	//add new Patient
	@Override
	@Transactional
	public Patient addNewPatient(Patient patient) {
		return patientDAO.save(patient);
	}

	//update Patient
	@Override
	@Transactional
	public Patient updatePatient(Patient patient) {
		return patientDAO.save(patient);
	}

	@Override
	@Transactional
	public Patient deletePatient(Integer _patientId) {
		Patient patient = patientDAO.getById(_patientId);
		patient.setIsActive(false);
		return patientDAO.save(patient);
	}

}
