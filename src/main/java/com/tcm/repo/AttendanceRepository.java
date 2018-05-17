package com.tcm.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tcm.model.Attendance;

@RepositoryRestResource(collectionResourceRel = "attendance", path = "attendance")
public interface AttendanceRepository extends PagingAndSortingRepository<Attendance, Long> {
	List<Attendance> findByLastName(String lastName);
}