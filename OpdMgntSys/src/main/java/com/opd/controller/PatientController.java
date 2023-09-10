package com.opd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opd.entity.Patient;
import com.opd.login.loginform;
import com.opd.service.PatientService;

import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/index")
	
	public String index() {
		return "You are welcomed";
	}

	@GetMapping("/allpatients")
	
	public List<Patient> getAllPatients() {
		return patientService.allPatients();
	}

	@PostMapping("/addPatient")
	public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
	    if (patient != null) {
	        patientService.savePatient(patient);
	        System.err.println("Patient added successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid patient data");
	    }
	}


	@GetMapping("/searchPatient/{id}")
	
	public Optional<Patient> searchById(@PathVariable int id) {
		System.out.println("Patient Searched successfully");
		return patientService.searchById(id);
	}

	@PutMapping("/updatePatient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }
	//controller to find patient by username
	
	@GetMapping("/findByUsername/{username}")
		public Patient getUsername(@PathVariable String username) {
			System.out.println(username);
			return patientService.getUsername(username);
			  
		}
	
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody loginform loginForm, HttpSession session) {
			String username = loginForm.getUsername();
			String password = loginForm.getPassword();

			if (patientService.authenticate(username, password)) {
				// Authentication successful
				// Store user information in the session
				session.setAttribute("username", username);

				// Return a success message or other data
				Map<String, String> response = new HashMap<>();
				response.put("message", "Login successful");
		        response.put("username", username);

				return ResponseEntity.ok(response);
			} else {
				// Authentication failed
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
			}
		}
		
		@DeleteMapping("/deleteById/{id}")
		public String deleteById(@PathVariable int id) {
			patientService.deletById(id);
			return "Deleted";
		}

}
