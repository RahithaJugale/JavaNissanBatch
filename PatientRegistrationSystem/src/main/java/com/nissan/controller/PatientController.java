package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Patient;
import com.nissan.service.IPatientService;

@RestController
@RequestMapping("api/")
public class PatientController {

	@Autowired
	IPatientService patientService;
	
	//list all patients
	@GetMapping("patients")
	public List<Patient> listAllPatients() {
		return patientService.listAllPatients();
	}
	
	//add new patient
	@PostMapping("patients")
	public Patient addNewPatient(@RequestBody Patient patient) {
		return patientService.addNewPatient(patient);
	}
	
	//update patient
	@PutMapping("patients/{_patientId}")
	public Patient updatePatient(@PathVariable Integer _patientId, @RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}
	
	//delete patient
	@DeleteMapping("patients/{_patientId}")
	public Patient deletePatient(@PathVariable Integer _patientId) {
		return patientService.deletePatient(_patientId);
	}
	
}
