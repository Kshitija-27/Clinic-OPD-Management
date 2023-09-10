package com.opd.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd.dto.AppDetailsByDid;
import com.opd.dto.AppDetailsByPid;
import com.opd.dto.AppointmentDetails;
import com.opd.entity.Appointment;
import com.opd.entity.Doctor;
import com.opd.entity.Queue;
import com.opd.entity.Reminder;
import com.opd.entity.Schedule;
import com.opd.repository.AppointmentRepo;
import com.opd.repository.DoctorRepo;
import com.opd.repository.QueueRepo;
import com.opd.repository.ReminderRepo;
import com.opd.repository.ScheduleRepo;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private ReminderRepo reminderRepo;

	@Autowired
	private QueueRepo queueRepo;

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private ScheduleRepo scheduleRepo;

	public List<Appointment> getAllApp() {
		return appointmentRepo.findAll();
	}

	public void addAppointment(Appointment appointment) {
		// adding data in reminder table while creating appointment
		Reminder reminder = new Reminder();
		reminder.setDate(appointment.getApp_date());
		reminder.setR_type("SMS");
		reminder.setAppointment(appointment);
		appointment.setStatus("pending");
		appointmentRepo.save(appointment);
		reminderRepo.save(reminder);
		calculateAndSaveQueueNumber(appointment);
	}

	private void calculateAndSaveQueueNumber(Appointment appointment) {

		LocalDate appointmentDate = appointment.getApp_date();
//		List<Appointment> list= appointmentRepo.findByapp_date(appointmentDate);
//		int queueNumber1=list.size()+1;
//		System.out.println(queueNumber1);
		int queueNumber = appointmentRepo.countAppBydate(appointmentDate);

		Queue queue = new Queue();
		queue.setAppointment(appointment);
		queue.setQ_number(queueNumber);
		queue.setQ_status("Waiting");

		queueRepo.save(queue);

	}

	public List<Appointment> appByPid(int pid) {

		List<Appointment> apptList = new ArrayList<>();
		LocalDate now = LocalDate.now();
		return null;
	}

	public List<Appointment> appByDid(int did) {

		Optional<Doctor> doctor = doctorRepo.findById(did);
		List<Appointment> apptList = appointmentRepo.findByDoctor(doctor);
//		LocalDate now= LocalDate.now();
//		List<Appointment> finalApptList= new ArrayList<>();
		return apptList;
	}

	public String updateStatus(int appid, String newStatus) {
		Appointment app = appointmentRepo.getById(appid);
		app.setStatus(newStatus);
		appointmentRepo.save(app);
		return "Appointment status updated";
	}

	// method to get list of dates on particular week day
	public static List<LocalDate> listOfdate(String weekday) {
		List<LocalDate> dates = new ArrayList<>();
		DayOfWeek desiredWeekDay = DayOfWeek.valueOf(weekday);

		LocalDate currdate = LocalDate.now();
		while (dates.size() < 1) {
			if (currdate.getDayOfWeek() == desiredWeekDay) {
				dates.add(currdate);
			}
			currdate = currdate.plusDays(1);
		}

		return dates;

	}

	// get doctor available days
	public List<LocalDate> availableDays(int d_id) {

		List<Schedule> l1 = doctorRepo.getById(d_id).getSchedule();
		List<String> weekdays = new ArrayList<>();
		for (Schedule schedule : l1) {
			weekdays.add(schedule.getDayOfWeek().toUpperCase());
		}

		List<LocalDate> Dates = new ArrayList<>();
		for (String weekday : weekdays) {
			Dates.addAll(listOfdate(weekday));
		}

		return Dates;
	}

	public List<AppointmentDetails> allAppByName() {
		return appointmentRepo.getAppointmentDetailsWithDoctor();
	}

	public List<AppDetailsByPid> getAppointmentsByPatientId(int id) {
		return appointmentRepo.getAppByPid(id);
	}

	// delete appointment by id service
	public String deleteAppById(int aid) {
		appointmentRepo.deleteById(aid);
		return "Appointment Deleted";
	}

	// service to update appointment date and time
	public Appointment updateDateAndTime(int aid, LocalDate appdate, LocalTime apptime) {
		Optional<Appointment> findById = appointmentRepo.findById(aid);
		Appointment app = findById.get();
		app.setApp_date(appdate);
		app.setApp_time(apptime);
		appointmentRepo.save(app);
		return app;
	}
	 public List<AppDetailsByDid> getAppointmentsByDoctorId(int doctorId) {
	        return appointmentRepo.getAppByDr(doctorId);
	    }
//	public String updateDateTime(int appid, LocalDate newDate, LocalTime newTime) {
//	    Appointment app = appointmentRepo.getById(appid);
//	    
//	    // Update the date and time if provided
//	    if (newDate != null) {
//	        app.setApp_date(newDate);
//	    }
//	    if (newTime != null) {
//	        app.setApp_time(newTime);
//	    }
//	    
//	    appointmentRepo.save(app);
//	    
//	    return "Appointment date and time updated";
//	}

}