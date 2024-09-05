package com.RouteGaurd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.exception.ResourceNotFoundException;
import com.RouteGaurd.app.model.SuperAdmin;
import com.RouteGaurd.app.repositories.SuperAdminRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
@Service
public class SuperAdminService {
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private SuperAdminRepository superAdminRepository;

    public SuperAdmin createSuperAdmin(SuperAdmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    public List<SuperAdmin> getAllSuperAdmins() {
        return superAdminRepository.findAll();
    }

    public SuperAdmin getSuperAdminById(Long id) {
        return superAdminRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SuperAdmin not found with id " + id));
    }

    public SuperAdmin updateSuperAdmin(Long id, SuperAdmin superAdminDetails) {
        SuperAdmin superAdmin = getSuperAdminById(id);
        // update fields
        return superAdminRepository.save(superAdmin);
    }

    public void deleteSuperAdmin(Long id) {
        SuperAdmin superAdmin = getSuperAdminById(id);
        superAdminRepository.delete(superAdmin);
    }

//	public boolean authenticateSuperAdmin(Long id, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean authenticateSuperAdmin(Long id, String password) {
    	
    
        SuperAdmin superAdmin = superAdminRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SuperAdmin not found with id " + id));
        
        return password.equals(superAdmin.getPassword());
    }
    
    public String generateToken(String userId) {
        
        String secretKey = "route-gaurd";

        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000)) // 10 days
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
    }

}
