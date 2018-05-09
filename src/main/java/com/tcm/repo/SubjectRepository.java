package com.tcm.repo;

import org.springframework.data.repository.CrudRepository;

import com.tcm.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}