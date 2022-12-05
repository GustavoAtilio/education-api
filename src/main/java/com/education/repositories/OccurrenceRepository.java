package com.education.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.education.models.OccurrenceModel;
import com.education.models.StudentModel;

public interface OccurrenceRepository extends JpaRepository<OccurrenceModel, Long>  {
	
	
	public List<OccurrenceModel>  findByStudent(StudentModel student);
}
