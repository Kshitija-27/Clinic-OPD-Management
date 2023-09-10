package com.opd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

	List<Patient> findByUsername(String username);
}
