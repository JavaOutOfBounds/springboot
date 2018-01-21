package com.javaoutofbounds.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class SpringbootConsumeRestExampleApplication {

	@Value("${endpoint}")
	String endpoint;

	RestTemplate restTemplate;

	public SpringbootConsumeRestExampleApplication() {
		restTemplate = new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumeRestExampleApplication.class, args);
	}

	/**
	 *  Exposed GET http://localhost:8080/api/studentDetails for testing purpose
	 *  To be called from getForObject() and getForEntity()
	 */
	@GetMapping("/studentDetails")
	public StudentDetails helloUser() {
		return createStudentRecord();
	}
	/**
	 *  Exposed POST http://localhost:8080/api/studentDetails for testing purpose
	 *  To be called from postForObject() and postForEntity()
	 */
	@PostMapping("/studentDetails")
	public StudentDetails helloUser(@RequestBody StudentDetails inputRequest) {
		return inputRequest;
	}

	private StudentDetails createStudentRecord() {
		final StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId("101");
		studentDetails.setName("Peter");
		studentDetails.setMarks(80);
		return studentDetails;
	}

	/**
	 * restTemplate.getForObject() Example
	 * Below method exposed as REST GET API which consumes HTTP GET /api/studentDetails endPoint defined above
	 */
	@GetMapping("/getForObjectOperation")
	public StudentDetails getForObjectOperation() {

		final StudentDetails responseBody = restTemplate.getForObject(
				endpoint, StudentDetails.class);
		return responseBody;
	}

	/**
	 * restTemplate.getForEntity() Example
	 * Below method exposed as REST GET API which consumes HTTP GET /api/studentDetails endPoint defined above
	 */
	@GetMapping("/getForEntityOperation")
	public StudentDetails getForEntityOperation() {

		final ResponseEntity<StudentDetails> responseEntity = restTemplate.getForEntity(
				endpoint, StudentDetails.class);
		return responseEntity.getBody();
	}

	/**
	 * restTemplate.getForEntity() Example
	 * Below method is exposed as REST POST API which consumes HTTP POST /api/studentDetails endPoint defined above
	 * The method accepts the POST body, maps to inputRequest and post it to service endPoint
	 */
	@PostMapping("/postForObjectOperation")
	public StudentDetails postForObjectOperation(@RequestBody StudentDetails inputRequest) {

		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("username", "password"));

		final StudentDetails responseBody = restTemplate.postForObject(endpoint, inputRequest, StudentDetails.class);
		return responseBody;
	}

	/**
	 * restTemplate.getForEntity() Example
	 * Below method is exposed as REST GET API which consumes HTTP POST /api/studentDetails endPoint defined above
	 * Here we create a new request and post it to service endPoint
	 */
	@GetMapping("/postForEntityOperation")
	public StudentDetails postForEntityOperation() {

		final ResponseEntity<StudentDetails> responseEntity = restTemplate.postForEntity(endpoint, createStudentRecord() ,StudentDetails.class);
		return responseEntity.getBody();
	}

}
