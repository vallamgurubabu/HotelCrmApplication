package com.brindavan.HotelCrmApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.brindavan.HotelCrmApplication.exception.ResourceNotFoundException;
import com.brindavan.HotelCrmApplication.model.Booking;
import com.brindavan.HotelCrmApplication.model.Customer;
import com.brindavan.HotelCrmApplication.repository.BookingRepository;
import com.brindavan.HotelCrmApplication.repository.CustomerRepository;
import com.brindavan.HotelCrmApplication.repository.RoomRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoomRepository roomRepository;

	public Booking addBooking(Booking booking) {
		customerRepository.findById(booking.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Customer not found with ID: " + booking.getCustomerId()));
		roomRepository.findById(booking.getRoomId())
				.orElseThrow(() -> new ResourceNotFoundException("Room with ID " + booking.getRoomId() + " not found"));

		return bookingRepository.save(booking);
	}

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
	}

	public void deleteBooking(Long id) {
		if (!bookingRepository.existsById(id)) {
			throw new ResourceNotFoundException("Booking not found with ID: " + id);
		}
		bookingRepository.deleteById(id);
	}
	
}