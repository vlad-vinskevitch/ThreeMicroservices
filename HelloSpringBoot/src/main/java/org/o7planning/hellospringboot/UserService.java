package org.o7planning.hellospringboot;

import org.o7planning.hellospringboot.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.o7planning.hellospringboot.CustomerRepository;
 
@Service
public class UserService {
    
    @Autowired
    private CustomerRepository userRepository;
    
    
    private boolean existsById(String id) {
        return userRepository.existsById(id);
    }
    
    public Customer findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public List<Customer> findAll(int pageNumber, int rowPerPage) {
        List<Customer> users = new ArrayList<>();
        Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage, 
                Sort.by("id").ascending());
        userRepository.findAll(sortedByLastUpdateDesc).forEach(users::add);
        return users;
    }
    
    
    public void update(Customer user) throws Exception {
        if (StringUtils.isEmpty(user.getFirstName())) {
            throw new Exception("Name is required");
        }
        if (StringUtils.isEmpty(user.getMiddleName())) {
            throw new Exception("Email is required");
        }
        if (StringUtils.isEmpty(user.getMiddleName())) {
            throw new Exception("Cannot find User with id: " + user.getLastName());
        }
        if (!existsById(user.setId())) {
            throw new Exception("Cannot find User with id: " + user.setId());
        }
        userRepository.save(user);
    }
    
    public void deleteById(String id) throws Exception {
        if (!existsById(id)) { 
            throw new Exception("Cannot find User with id: " + id);
        }
        else {
            userRepository.deleteById(id);
        }
    }
    
    public Long count() {
        return userRepository.count();
    }
}