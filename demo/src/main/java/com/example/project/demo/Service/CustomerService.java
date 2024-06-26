package com.example.project.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.demo.DTO.ResponseDTO;
import com.example.project.demo.DTO.ResponseDTOUtil;
import com.example.project.demo.Entity.Customer;
import com.example.project.demo.Repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public ResponseEntity<ResponseDTO> addCustomer(Customer customer) {
		try {
			customer = customerRepository.save(customer);
			ResponseDTO responseDTO = ResponseDTOUtil.buildSuccessResponse(customer);
			return ResponseEntity.ok(responseDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTOUtil.buildFailureResponse();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
		}
	}
	
	public ResponseEntity<ResponseDTO> getAllCustomers() {
		try {
			List<Customer> customers = customerRepository.findAll();
			ResponseDTO responseDTO = ResponseDTOUtil.buildSuccessResponse(customers);
			return ResponseEntity.ok(responseDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTOUtil.buildFailureResponse();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
		}
	}
}
