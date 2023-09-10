package com.opd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opd.dto.AppDetailsByDid;
import com.opd.dto.AppDetailsByPid;
import com.opd.dto.AppointmentDetails;
import com.opd.entity.Appointment;
import com.opd.service.AppointmentService;

@CrossOrigin
@Controller
@RequestMapping("/appointment")
@ResponseBody
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/index")
	public String index() {
		return "Success";
	}

	// view all appointment
	@GetMapping("/allAppointments")
	public List<Appointment> getAll() {
		return appointmentService.getAllApp();
	}

	// book appointment api
	@PostMapping("/bookApp")
	public String bookApp(@RequestBody Appointment appointment) {

		appointmentService.addAppointment(appointment);
		return "Appointment Booked";
	}

	// get all appointments by patient id...
	@GetMapping("/appByPid")
	public List<Appointment> appByPid(int pid) {

		return appointmentService.appByPid(pid);

	}

	// get all appointments by doctor id...
	@GetMapping("/appByDid/{did}")
	public List<Appointment> appByDid(@PathVariable int did) {

		return appointmentService.appByDid(did);

	}

	// change appointment status using app id
	@PutMapping("/updateStatus/{appid}/{newStatus}")
	public String updateStatus(@PathVariable int appid, @PathVariable String newStatus) {
		String status = appointmentService.updateStatus(appid, newStatus);
		return status;
	}
//get dates for booking appointment according to doctor schedule
	@GetMapping("/drAvailableDays/{d_id}")
	public List<LocalDate> availableDays(@PathVariable int d_id) {
		return appointmentService.availableDays(d_id);

	}
//appointment of same person by name 
	@GetMapping("/allAppByName")
	public List<AppointmentDetails> allAppByName() {
		return appointmentService.allAppByName();
	}

	@GetMapping("/patient/{id}")
	public List<AppDetailsByPid> getAppointmentsByPatientId(@PathVariable int id) {
		return appointmentService.getAppointmentsByPatientId(id);
	}

	@DeleteMapping("/deleteById/{aid}")
	public String deleteAppById(@PathVariable int aid) {

		return appointmentService.deleteAppById(aid);
	}

	// controller to update appointment date and time
	@PutMapping("/upateDateAndTime/{aid}/{appdate}/{apptime}")
	public Appointment updateDateAndTime(@PathVariable int aid, @PathVariable LocalDate appdate,
			@PathVariable LocalTime apptime) {
		return appointmentService.updateDateAndTime(aid, appdate, apptime);

	}

	@GetMapping("/allAppByDr/{doctorId}")
	public List<AppDetailsByDid> getAppointmentsByDoctorId(@PathVariable int doctorId) {
		return appointmentService.getAppointmentsByDoctorId(doctorId);
	}

//	 @PutMapping("/updateDateTime/{appid}/{newDate}/{newTime}")
//	    public String updateDateTime(@PathVariable int appid,
//	                                 @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate newDate,
//	                                 @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime newTime) {
//	        String status = appointmentService.updateDateTime(appid, newDate, newTime);
//	        return status;
//	    }

}