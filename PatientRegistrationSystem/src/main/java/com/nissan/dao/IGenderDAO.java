package com.nissan.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Gender;

@Repository
public interface IGenderDAO extends JpaRepositoryImplementation<Gender, Integer>{

}
