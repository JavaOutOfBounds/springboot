package com.javaoutofbounds.pojo;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootCamelRestdslApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCamelRestdslApiApplication.class, args);
	}

	@Component
	class StudentRoute extends RouteBuilder {

		@Override
		public void configure() {
			restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.json);

			rest("/student").produces("application/json")
			.get("/hello/{name}")
			.route().transform().simple("Hello ${header.name}, Welcome to JavaOutOfBounds.com")
			.endRest()
			.get("/records/{name}").to("direct:records");

			from("direct:records")
			.process(new Processor() {

				final AtomicLong counter = new AtomicLong();

				@Override
				public void process(Exchange exchange) throws Exception {

					final String name = exchange.getIn().getHeader("name",String.class);
					exchange.getIn().setBody(new Student(counter.incrementAndGet(),name,"Camel + SpringBoot"));
				}
			});
		}
	}
}
