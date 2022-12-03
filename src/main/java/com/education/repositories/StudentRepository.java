package com.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.models.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {}
