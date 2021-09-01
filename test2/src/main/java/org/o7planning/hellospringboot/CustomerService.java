package org.o7planning.hellospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	 @Autowired
	    private CustomerRepository departmentRepository;

	    public Customer save(Customer department) {
	        
	        return departmentRepository.save(department);
	    }

	    public Customer findUserById(String departmentId) {
	      
	        return departmentRepository.findById(departmentId).get();
	    }
}
