package com.javaoutofbounds.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	/**
	 * Adds New Record to MySQL db_StudentRecords database
	 *
	 */
	@GetMapping("/create")
	@ResponseBody
	public String createStudentRecord(@RequestParam String name, @RequestParam String contact) {

		final Student student = new Student();
		student.setName(name);
		student.setContact(contact);
		studentRepository.save(student);

		return "Record Created Successfully!";
	}

	/**
	 * Reads All records from MySQL db_StudentRecords database
	 *
	 */
	@GetMapping("/read")
	@ResponseBody
	public Iterable<Student> readAllStudentRecords() {

		return studentRepository.findAll();
	}

	/**
	 * Update specified records to MySQL db_StudentRecords database
	 *
	 */
	@GetMapping("/update")
	@ResponseBody
	public String updateStudentRecord(@RequestParam Integer id, @RequestParam String name,
			@RequestParam String contact) {

		final Student student = studentRepository.findOne(id);
		student.setName(name);
		student.setContact(contact);
		studentRepository.save(student);

		return "Record Updated Successfully!";
	}

	/**
	 * Deletes specified records from MySQL db_StudentRecords database
	 *
	 */
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudentRecord(@RequestParam Integer id) {

		studentRepository.delete(id);

		return "Record Deleted Successfully!";
	}

	/**
	 * Custom query to find records using contactNumber from MySQL db_StudentRecords database
	 *
	 */
	@GetMapping("/findByContactNumber")
	@ResponseBody
	public Student findRecordByContactNumber(@RequestParam String contact) {

		final Student student = studentRepository.findByContact(contact);
		return student;
	}
}
