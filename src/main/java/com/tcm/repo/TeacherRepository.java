package com.tcm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tcm.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	List<Teacher> findByLastName(String lastName);
}