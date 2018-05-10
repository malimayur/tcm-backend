package com.tcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcm.model.Teacher;
import com.tcm.repo.TeacherRepository;

@RestController
@RequestMapping(value="/tcm")
public class TeacherController {

	@Autowired
	TeacherRepository repository;

	@GetMapping(value="/teacher",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Teacher> getAll() {
		List<Teacher> list = new ArrayList<>();
		Iterable<Teacher> teacher = repository.findAll();
		teacher.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/createteacher")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		Teacher teacherObj = new Teacher();
		teacherObj.setFirstName(teacher.getFirstName());
		teacherObj.setLastName(teacher.getLastName());
		teacherObj.setAddress(teacher.getAddress());
		teacherObj.setPhone(teacher.getPhone());
		teacherObj.setEmail(teacher.getEmail());
		repository.save(teacherObj);
		return teacher;
	}

	@GetMapping(value="/findteacherbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Teacher> findByLastName(@PathVariable String lastName) {
		List<Teacher> teacher = repository.findByLastName(lastName);
		return teacher;
	}
	
	@DeleteMapping(value="/teacher/{id}")
	public void deleteCustomer(@PathVariable long id){
		repository.delete(id);
	}
}
