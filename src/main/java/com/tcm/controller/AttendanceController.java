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

import com.tcm.model.Attendance;
import com.tcm.repo.AttendanceRepository;
import com.tcm.repo.StudentRepository;

@RestController
@RequestMapping(value="/tcm")
public class AttendanceController {

	@Autowired
	AttendanceRepository repository;
	
	@Autowired
	StudentRepository studentrepository;

	@PostMapping(value="/createattendance")
	public Attendance createAttendance(@RequestBody Attendance attendance) {
		Attendance attendanceObj = new Attendance();
		attendanceObj.setStudent(attendance.getStudent());
		attendanceObj.setTeacher(attendance.getTeacher());
		attendanceObj.setDate(attendance.getDate());
		attendanceObj.setInTime(attendance.getInTime());
		attendanceObj.setOutTime(attendance.getOutTime());
		repository.save(attendanceObj);
		return attendance;
	}
	
	/*@GetMapping(value="/getAttendanceByLastName/{lastName}" ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Attendance> getAttendance(@PathVariable String lastName) {
		List<Attendance> attendance = repository.findByLastName(lastName);
		return attendance;
	}*/
}
