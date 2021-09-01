package org.o7planning.hellospringboot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


@RestController
public class testController {
	  @Autowired
	  private CustomerRepository repository;
	  @Autowired
	  private CustomerService service;
	   @JsonProperty("Customer")
	    private List<Customer> Entries;
	  
		@GetMapping
		public ReasponsMiddleName[] main(Map<String, Object> model){
			
			Customer[] customer = new Customer[repository.findAll().size()];
			int i = 0;
			for(Customer name : repository.findAll())
			{
				customer[i] = name;
				i++;
		    }	
			
			ResponseEntity<ReasponsFirstName[]> responseEntity = 
					   new RestTemplate().getForEntity(
					        "http://localhost:8100", ReasponsFirstName[].class);
			ReasponsFirstName[] saw = responseEntity.getBody();
			//Entries =  (List<Customer>) responseEntity.getBody();

			List<ReasponsMiddleName> reasponse = new ArrayList<ReasponsMiddleName>();
			i =0;
			for(ReasponsFirstName name : saw)
			{
				reasponse.add(new ReasponsMiddleName(name.getId(),name.getFirstName(),customer[i].getMiddleName()));
				i++;
		    }		
			return reasponse.toArray(new ReasponsMiddleName[0]);
		}
}
