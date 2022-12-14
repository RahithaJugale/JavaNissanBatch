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

import com.nissan.model.Professor;
import com.nissan.service.IProfessorService;

@RestController
@RequestMapping("api/")
public class ProfessorController {

	@Autowired
	IProfessorService professorService;
	
	// add new Professor
	@PostMapping("professors")
	public Professor addProfessor(@RequestBody Professor professor) {
		return professorService.addProfessor(professor);
	}

	// remove professor
	@DeleteMapping("professors/{_professorId}")
	public Professor removeProfessor(@PathVariable Integer _professorId) {
		return professorService.removeProfessor(_professorId);
	}

	// search by professor ID
	@GetMapping("professors/{_professorId}")
	public Professor searchProfessorById(@PathVariable Integer _professorId) {
		return professorService.searchProfessorById(_professorId);
	}

	// list all professors
	@GetMapping("professors")
	public List<Professor> listAllProfessors() {
		return professorService.listAllProfessors();
	}

	// update salary
	@PutMapping("professors/{_professorId}/{salary}")
	public Professor updateSalary(@PathVariable("_professorId") Integer _professorId, @PathVariable("salary") Double salary) {
		return professorService.updateSalary(_professorId, salary);
	}

}
