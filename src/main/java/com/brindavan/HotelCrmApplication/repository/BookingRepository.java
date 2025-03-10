package com.brindavan.HotelCrmApplication.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.brindavan.HotelCrmApplication.model.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long> {
	

}

