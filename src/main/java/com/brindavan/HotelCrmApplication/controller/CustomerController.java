package com.brindavan.HotelCrmApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brindavan.HotelCrmApplication.model.Customer;
import com.brindavan.HotelCrmApplication.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "Customer deleted successfully.";
	}

	@DeleteMapping("/delete/all")
	public String deleteCustomer() {
		customerService.deleteAllCustomer();
		return "Customers deleted successfully.";
	}

	@GetMapping("/room/{roomNumber}")
	public List<Customer> getCustomersByRoomNumber(@PathVariable String roomNumber) {
		return customerService.getCustomersByRoomNumber(roomNumber);
	}
}
