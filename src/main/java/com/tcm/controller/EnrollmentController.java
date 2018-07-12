package com.tcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcm.model.Enrollment;
import com.tcm.repo.EnrollmentRepository;
import com.tcm.repo.StudentRepository;
import com.tcm.repo.TeacherRepository;

@RestController
@RequestMapping(value = "/tcm")
public class EnrollmentController {

	@Autowired
	EnrollmentRepository repository;

	@Autowired
	StudentRepository studentrepository;

	@Autowired
	TeacherRepository teacherrepository;

	@PostMapping(value = "/createenrollment")
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
		Enrollment enrollmentObj = new Enrollment();
		enrollmentObj.setStudent(enrollment.getStudent());
		enrollmentObj.setTeacher(enrollment.getTeacher());
		enrollmentObj.setSubject(enrollment.getSubject());
		enrollmentObj.setStartDate(enrollment.getStartDate());
		enrollmentObj.setEndDate(enrollment.getEndDate());
		enrollmentObj.setHours(enrollment.getHours());
		enrollmentObj.setAmount(enrollment.getAmount());
		enrollmentObj.setPaymentType(enrollment.getPaymentType());
		enrollmentObj.setLocation(enrollment.getLocation());
		repository.save(enrollmentObj);
		return enrollment;
	}
	
	/*@GetMapping(value="/getEnrollmentByLastName/{lastName}" ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> getEnrollment(@PathVariable String lastName) {
		List<Enrollment> enrollment = repository.findByLastName(lastName);
		return enrollment;
	}*/
}
