package com.brindavan.HotelCrmApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindavan.HotelCrmApplication.exception.ResourceNotFoundException;
import com.brindavan.HotelCrmApplication.model.Admin;
import com.brindavan.HotelCrmApplication.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
       return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + id));
    }

    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new ResourceNotFoundException("Admin not found with ID: " + id);
        }
        adminRepository.deleteById(id);
    }

	public void deleteAllAdmin() {
		adminRepository.deleteAll();
	}
}