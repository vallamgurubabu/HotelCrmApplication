package com.brindavan.HotelCrmApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brindavan.HotelCrmApplication.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberAndIsAvailable(Long roomNumber, boolean isAvailable);
}
