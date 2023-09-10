package com.opd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.opd.entity.Doctor;
import com.opd.entity.Schedule;
import com.opd.repository.DoctorRepo;
import com.opd.repository.ScheduleRepo;

import jakarta.persistence.EntityManager;

import com.opd.dto.ScheduleDetails;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private DoctorRepo doctorRepo;
//
//    public void addSchedule(Schedule schedule) {
//        // Ensure the associated doctor exists
//        Optional<Doctor> optionalDoctor = doctorRepo.findById(schedule.getDoctor().getD_id());
//        if (optionalDoctor.isEmpty()) {
//            throw new IllegalArgumentException("Doctor not found with ID: " + schedule.getDoctor().getD_id());
//        }
//
//        schedule.setDoctor(optionalDoctor.get());
//
//        // Save the Schedule
//        scheduleRepo.save(schedule);
//    }

    public String addSchedule(Schedule schedule) {
		Doctor d = doctorRepo.getById(schedule.getDoctor().getD_id());
		schedule.setDoctor(d);
		scheduleRepo.save(schedule);
		return "schdule added scucessfully";
	}
    public List<Schedule> allSchedule() {
        return scheduleRepo.findAll();
    }

    public List<ScheduleDetails> allScheduleDetails() {
        return scheduleRepo.getScheduleDetails();
    }

    public List<ScheduleDetails> scheduleById(int did) {
        return scheduleRepo.getScheduleDetByDr(did);
    }
    public void editSchedule(int doctorId, int scheduleId, Schedule updatedSchedule) {
        // Ensure the associated doctor exists
        Optional<Doctor> optionalDoctor = doctorRepo.findById(doctorId);

        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            List<Schedule> doctorSchedules = doctor.getSchedule();

            // Find and update the schedule based on both doctorId and scheduleId
            for (Schedule schedule : doctorSchedules) {
                if (schedule.getS_id() == scheduleId) {
                    // Update the fields of the existing schedule with the new values
                    schedule.setDayOfWeek(updatedSchedule.getDayOfWeek());
                    schedule.setStartTime(updatedSchedule.getStartTime());
                    schedule.setEndTime(updatedSchedule.getEndTime());
                    schedule.setAvailability(updatedSchedule.isAvailability());

                    // Save the updated schedule
                    scheduleRepo.save(schedule);
                    return; // Exit the loop since we found and updated the schedule
                }
            }

            // If the schedule is not found, you can handle it accordingly (e.g., throw an exception).
            throw new IllegalArgumentException("Schedule not found for Doctor with ID: " + doctorId + " and Schedule ID: " + scheduleId);
        } else {
            throw new IllegalArgumentException("Doctor not found with ID: " + doctorId);
        }
    
}
    public String deleteById(int id) {
    	scheduleRepo.deleteById(id);
		return "Schedule Delete Success";
	}
    }



