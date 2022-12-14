package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IProfessorDAO;
import com.nissan.model.Professor;

@Service
public class ProfessorServiceImplementation implements IProfessorService {

	@Autowired
	IProfessorDAO professorDAO;
	//add new Professor
	@Transactional
	public Professor addProfessor(Professor professor) {
		return professorDAO.save(professor);
	}

	//remove professor
	@Transactional
	public Professor removeProfessor(Integer _professorId) {
		Professor professor = professorDAO.getProfessorById(_professorId);
		professor.setIsActive(false);
		return professor;
	}

	//search by professor ID
	public Professor searchProfessorById(Integer _professorId) {
		return professorDAO.getProfessorById(_professorId);
	}

	//list all professors
	public List<Professor> listAllProfessors() {
		return professorDAO.findAll();
	}

	//update salary
	@Transactional
	public Professor updateSalary(Integer _professorId, Double salary) {
		Professor professor = professorDAO.getProfessorById(_professorId);
		professor.setSalary(salary);
		return professorDAO.save(professor);
	}

}
