package com.brindavan.HotelCrmApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindavan.HotelCrmApplication.exception.ResourceNotFoundException;
import com.brindavan.HotelCrmApplication.model.Customer;
import com.brindavan.HotelCrmApplication.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
	}

	public void deleteCustomer(Long id) {
		if (!customerRepository.existsById(id)) {
			throw new ResourceNotFoundException("Customer not found with ID: " + id);
		}
		customerRepository.deleteById(id);
	}

	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}
	
	public List<Customer> getCustomersByRoomNumber(String roomNumber) {
        return customerRepository.findCustomerByRoomNumber(roomNumber);
    }
}
