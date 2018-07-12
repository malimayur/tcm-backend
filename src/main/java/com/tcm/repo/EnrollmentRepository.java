package com.tcm.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tcm.model.Enrollment;

@RepositoryRestResource(collectionResourceRel = "enrollment", path = "enrollment")
public interface EnrollmentRepository extends PagingAndSortingRepository<Enrollment, Long> {
	//List<Enrollment> findByLastName(String lastName);
}