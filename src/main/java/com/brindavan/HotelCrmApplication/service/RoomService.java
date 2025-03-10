package com.brindavan.HotelCrmApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindavan.HotelCrmApplication.exception.ResourceNotFoundException;
import com.brindavan.HotelCrmApplication.model.Room;
import com.brindavan.HotelCrmApplication.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with ID " + id + " not found"));
    }

    public boolean isRoomAvailable(Long roomNumber) {
        return roomRepository.findByRoomNumberAndIsAvailable(roomNumber, true).isPresent();
    }

    public void markRoomAsBooked(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room with ID " + roomId + " not found"));
        room.setAvailable(true);
        roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Room with ID " + id + " not found");
        }
        roomRepository.deleteById(id);
    }
}