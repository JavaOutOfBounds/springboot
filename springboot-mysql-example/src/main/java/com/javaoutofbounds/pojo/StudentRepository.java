package com.javaoutofbounds.pojo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByContact(String contact);

}
