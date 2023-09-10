package com.opd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd.entity.Doctor;
import com.opd.entity.Patient;
import com.opd.repository.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;

	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}

	public void addDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
	}

	public void deleteById(int id) {
		doctorRepo.deleteById(id);
	}
	// service to update dr by id
		public void updateDrById(int did, Doctor doctor) {

			Doctor d = doctorRepo.getById(did);
			d.setContact(doctor.getContact());
			d.setFirstname(doctor.getFirstname());
			d.setLastname(doctor.getLastname());
			d.setSpecialization(doctor.getSpecialization());
			
			doctorRepo.save(d);
		}
		public boolean authenticate(String username, String password) {
			List<Doctor> d = doctorRepo.findByUsername(username);
			Doctor doctor = d.get(0);
			if (doctor.getpassword() != password)
				return true;
			else
				return false;

		}
		
		
		public Doctor getUsername(String username) {
		    List<Doctor> doctors = doctorRepo.findByUsername(username);

		    if (!doctors.isEmpty()) {
		        return doctors.get(0);
		    } else {
		        return null; 
		    }
		}

}