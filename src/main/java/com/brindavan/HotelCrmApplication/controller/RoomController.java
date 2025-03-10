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

import com.brindavan.HotelCrmApplication.model.Room;
import com.brindavan.HotelCrmApplication.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@PostMapping("/add")
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@GetMapping("/all")
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

	@GetMapping("/{id}")
	public Room getRoomById(@PathVariable Long id) {
		return roomService.getRoomById(id);
	}

	@GetMapping("/check-availability/{roomNumber}")
	public boolean checkRoomAvailability(@PathVariable Long roomNumber) {
		return roomService.isRoomAvailable(roomNumber);
	}

	@PostMapping("/book/{roomId}")
	public String bookRoom(@PathVariable Long roomId) {
		roomService.markRoomAsBooked(roomId);
		return "Room booked successfully.";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
		return "Room deleted successfully.";
	}

}
