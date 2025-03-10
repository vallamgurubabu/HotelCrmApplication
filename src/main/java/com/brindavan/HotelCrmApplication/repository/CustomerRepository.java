package com.brindavan.HotelCrmApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brindavan.HotelCrmApplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("SELECT DISTINCT c FROM Customer c " + "JOIN Booking b ON c.id = b.customerId "
			+ "JOIN Room r ON r.roomNumber = b.roomId " + 
			"WHERE r.roomNumber = :roomNumber")
	List<Customer> findCustomerByRoomNumber(@Param("roomNumber") String roomNumber);

}
