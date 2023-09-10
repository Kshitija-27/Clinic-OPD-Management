package com.opd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.opd.entity.Doctor;
import com.opd.entity.Patient;
import com.opd.login.loginform;
import com.opd.service.DoctorService;

import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/index")
	@ResponseBody
	public String index() {
		return "Success";
	}

	@GetMapping("/alldoctors")
	@ResponseBody
	public List<Doctor> allDoctors(){
		return  doctorService.getAllDoctors();
	}

	@PostMapping("/addDoctor")
	@ResponseBody
	public String addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return "Added";
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id){
	doctorService.deleteById(id);
	return "Deleted Successfully";

	}
	   //controller to update dr by id
		@PutMapping("/updateById/{did}")
		@ResponseBody
		public String UpdateDrById(@PathVariable int did,@RequestBody Doctor doctor) {
			doctorService.updateDrById(did,doctor);
			return "Dr Updated Successfully";
		}
		
		@GetMapping("/findByUsername/{username}")
		public Doctor getUsername(@PathVariable String username) {
			System.out.println(username);
			return doctorService.getUsername(username);
			  
		}
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody loginform loginForm, HttpSession session) {
			String username = loginForm.getUsername();
			String password = loginForm.getPassword();

			if (doctorService.authenticate(username, password)) {
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
}
