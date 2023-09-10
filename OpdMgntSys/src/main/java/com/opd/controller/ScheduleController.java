package com.opd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.opd.dto.AppointmentDetails;
import com.opd.dto.ScheduleDetails;
import com.opd.entity.Schedule;

import com.opd.service.ScheduleService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/allSchedule")
	public List<Schedule> allSchedule(){
		return scheduleService.allSchedule();
	}
	
	@PostMapping("/addSchedule")
	public String addScheduleFromRequest(@RequestBody Schedule schedule) {
	    return scheduleService.addSchedule(schedule);
	}
	
	@GetMapping("/allScheduleDetails")
	public List<ScheduleDetails> allAppByName(){
		
		return scheduleService.allScheduleDetails();
	}
	@GetMapping("/scheduleByDrId/{did}")
	public List<ScheduleDetails> scheduleById(@PathVariable int did) {
		
		return scheduleService.scheduleById(did);
}
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return scheduleService.deleteById(id);
	}
	 @PutMapping("/editSchedule/{doctorId}/{scheduleId}")
	    public void editSchedule(
	            @PathVariable int doctorId,
	            @PathVariable int scheduleId,
	            @RequestBody Schedule updatedSchedule
	    ) {
	        scheduleService.editSchedule(doctorId, scheduleId, updatedSchedule);
	    }
}