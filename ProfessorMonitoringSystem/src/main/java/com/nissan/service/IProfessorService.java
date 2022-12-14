package com.nissan.service;

import java.util.List;

import com.nissan.model.Professor;

public interface IProfessorService {

	//add new Professor
	Professor addProfessor(Professor professor);
	
	//remove professor
	Professor removeProfessor(Integer _professorId);
	
	//search by professor ID
	Professor searchProfessorById(Integer _professorId);
	
	//list all professors
	List<Professor> listAllProfessors();
	
	//update salary
	Professor updateSalary(Integer _professorId, Double salary);
}
