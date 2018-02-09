package com.javaoutofbounds.pojo;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javaoutofbounds.pojo.model.HelloStudentRequest;
import com.javaoutofbounds.pojo.model.HelloStudentResponse;

@Endpoint
public class StudentEndpoint {

	private final String NAME_SPACE_URI = "http://www.javaoutofbounds.com";

	@ResponsePayload
	@PayloadRoot(namespace = NAME_SPACE_URI, localPart = "helloStudentRequest")
	public HelloStudentResponse getStudentDetails(@RequestPayload HelloStudentRequest studentRequest) {

		final HelloStudentResponse studentResponse = new HelloStudentResponse();
		studentResponse.setOutputResult("Hello "+studentRequest.getInputName()+", Welcome to JavaOutOfBounds.com");
		return studentResponse;
	}
}
