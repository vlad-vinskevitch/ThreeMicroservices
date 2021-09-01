package org.o7planning.hellospringboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class testController {
    @Autowired
	private CustomerRepository repository;
	@Autowired
	private CustomerService service;

	
	@GetMapping
	public ReasponsFirstName[] main1(Map<String, Object> model){		
		Iterable<Customer> customers = repository.findAll();
		List<ReasponsFirstName> reasponse = new ArrayList<ReasponsFirstName>();
		for(Customer name : customers)
		{
			reasponse.add(new ReasponsFirstName(name.setId(),name.getFirstName()));
	    }
		return reasponse.toArray(new ReasponsFirstName[0]);
	}
}
