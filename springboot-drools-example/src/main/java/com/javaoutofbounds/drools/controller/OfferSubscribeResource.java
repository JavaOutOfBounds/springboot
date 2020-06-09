package com.javaoutofbounds.drools.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javaoutofbounds.drools.beans.Subscribe;
/*
 * @Author javaoutofbound
 */

@RestController
public class OfferSubscribeResource {
	@Autowired
	private KieContainer kieContainer;

	@PostMapping("/products/subscriptions")
	public Subscribe offerSync(@RequestBody Subscribe clientSubscribe) {
		System.out.println("Client request to Subscribe for Amazon offers   : " + clientSubscribe.toString());
		// StatelessKieSession session =kieContainer.newStatelessKieSession();// 
		// "ksessionAmazonOffer" which is defined inside kmodule.xml
		KieSession ksession = kieContainer.newKieSession("ksessionAmazonOffer");//Stateful session
		ksession.insert(clientSubscribe);// Storage the facts into working memory
		ksession.fireAllRules();// Execution of rules using rule engine
		System.out.println("Client Subscribed for Amazon offers if Sync flag is true  : " + clientSubscribe.toString());
		return clientSubscribe;

	}

}
