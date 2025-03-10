package com.brindavan.HotelCrmApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brindavan.HotelCrmApplication.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
