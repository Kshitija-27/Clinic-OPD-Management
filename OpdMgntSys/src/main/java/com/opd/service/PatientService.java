package com.opd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.opd.entity.Doctor;
import com.opd.entity.Patient;
import com.opd.repository.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;

	public List<Patient> allPatients() {
		return patientRepo.findAll();
	}

	public void savePatient(Patient patient) {
				patientRepo.save(patient);
	}

	public Optional<Patient> searchById(int id) {
		return patientRepo.findById(id);
	}

	 public ResponseEntity<String> updatePatient(int id, Patient updatedPatient) {
	        Optional<Patient> optionalPatient = patientRepo.findById(id);

	        if (optionalPatient.isPresent()) {
	            Patient existingPatient = optionalPatient.get();
	            // Update the patient's information with the provided data
	            existingPatient.setFirstname(updatedPatient.getFirstname());
	            existingPatient.setLastname(updatedPatient.getLastname());
	            existingPatient.setUsername(updatedPatient.getUsername());
	            existingPatient.setContact(updatedPatient.getContact());
	            existingPatient.setMedHistory(updatedPatient.getMedHistory());
	            existingPatient.setInsrDetail(updatedPatient.getInsrDetail());

	            // Save the updated patient
	            patientRepo.save(existingPatient);

	            return ResponseEntity.status(HttpStatus.OK).body("Patient updated successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
	        }
	    }

	public boolean authenticate(String username, String password) {
		List<Patient> p = patientRepo.findByUsername(username);
		Patient patient = p.get(0);
		if (patient.getPassword() != password)
			return true;
		else
			return false;

	}

	//service to find patient bby username
	public Patient getUsername(String username) {
	    List<Patient> patients = patientRepo.findByUsername(username);

	    if (!patients.isEmpty()) {
	        return patients.get(0);
	    } else {
	        return null; 
	    }
	}

	public void deletById(int id) {
		System.out.println("Patient deleted success");
		patientRepo.deleteById(id);
	}


}