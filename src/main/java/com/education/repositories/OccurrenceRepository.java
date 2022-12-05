package com.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.models.OccurrenceModel;

public interface OccurrenceRepository extends JpaRepository<OccurrenceModel, Long>  {}
