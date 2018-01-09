package com.javaoutofbounds.pojo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestApiController {

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(method = RequestMethod.GET, value = "/student")
	public Student studentRecord(@RequestParam(value="name", defaultValue="SKP") String name) {
		return new Student(counter.incrementAndGet(), name,"Spring Boot" );
	}
}
