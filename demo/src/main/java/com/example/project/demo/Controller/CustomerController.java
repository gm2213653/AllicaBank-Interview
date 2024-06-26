package com.example.project.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.demo.DTO.ResponseDTO;
import com.example.project.demo.Entity.Customer;
import com.example.project.demo.Service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/addCustomer")
	public ResponseEntity<ResponseDTO> addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<ResponseDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}

}
