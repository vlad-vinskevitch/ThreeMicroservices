package org.o7planning.hellospringboot;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {
	  @Autowired
	  private CustomerRepository repository;
	  
	  @Autowired
	  private UserService userService;
	  
	  @JsonProperty("Customer")
	  private List<Customer> Entries;
	  
	private Iterable<ReasponsLastName> ResponseInput (Map<String, Object> model)
	{
		Customer[] customer = new Customer[repository.findAll().size()];
		int i = 0;
		for(Customer name : repository.findAll())
		{
			customer[i] = name;
			i++;
	    }	
		
		ResponseEntity<ReasponsMiddleName[]> responseEntity = 
				   new RestTemplate().getForEntity(
				        "http://localhost:8200", ReasponsMiddleName[].class);
		ReasponsMiddleName[] saw = responseEntity.getBody();

		List<ReasponsLastName> reasponse = new ArrayList<ReasponsLastName>();
		i =0;
		for(ReasponsMiddleName name : saw)
		{
			reasponse.add(new ReasponsLastName(name.getId(),name.getFirstName(),name.getMidlleName(),customer[i].getLastName()));
			i++;
	    }		
		return reasponse;
	}
	  
	  
	@GetMapping
	public String main(Map<String, Object> model){
		
		Iterable<ReasponsLastName> customers = ResponseInput(model);
		model.put("customers",customers);
		return "main";
	}
	
	@GetMapping("/add")
	public String add(){
		return "add";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam String firstName, @RequestParam String middleName,
			@RequestParam String lastName,Map<String, Object> model) {
		
		Customer customer = new Customer(firstName,middleName,lastName);
		repository.save(customer);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/edit")
	public String showEditUser(Model model, @PathVariable String id) {
	    Customer user = null;

		user = userService.findById(id);
	    model.addAttribute("user", user);
	    return "edit";
	}
	 
	@PostMapping(value = {"/{userId}/edit"})
	public String updateUser(Model model,
	        @PathVariable String userId,
	        @ModelAttribute("user") Customer user){
	    	Customer user1 = user;
	    	user1.id =userId;
	        try {
				userService.update(user1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "redirect:/";

	}
	
	@GetMapping("/{id}/delete")
	public String DeleteUser(
	        Model model, @PathVariable String id) {
		Customer user = null;

	    user = userService.findById(id);

	    model.addAttribute("allowDelete", true);
	    model.addAttribute("user", user);
	    return "delete";
	}
	 
	@PostMapping("/{userId}/delete")
	public String deleteUserById(
	        Model model, @PathVariable String userId) {
	    try {
	        userService.deleteById(userId);
	        return "redirect:/";
	    } catch (Exception ex) {
	        String errorMessage = ex.getMessage();
	        model.addAttribute("errorMessage", errorMessage);
	        return "redirect:/";
	    }
	}
	@GetMapping("/{id}/user")
	public String user(Model model, @PathVariable String id){
		 
		Customer user = null;

		user = userService.findById(id);
		model.addAttribute("user", user);
		return "user";
	}

}