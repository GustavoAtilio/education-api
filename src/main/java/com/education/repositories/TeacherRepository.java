package com.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.models.TeacherModel;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
	public TeacherModel findByNameAndLastName(String name, String lastName);
}
