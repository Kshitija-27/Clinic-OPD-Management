package com.opd.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opd.dto.AppDetailsByDid;
import com.opd.dto.AppDetailsByPid;
import com.opd.dto.AppointmentDetails;
import com.opd.entity.Appointment;
import com.opd.entity.Doctor;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {


	@Query("SELECT COUNT(a.app_date) FROM Appointment a WHERE a.app_date = :date")
	int countAppBydate(@Param("date") LocalDate date);
	List<Appointment> findByDoctor(Optional<Doctor> doctor);

	@Query("SELECT new com.opd.dto.AppointmentDetails(a.a_id, a.app_date, a.app_time, a.status, p.firstname, p.lastname, d.firstname, d.lastname) " +
		       "FROM Appointment a " +
		       "JOIN a.patient p " +
		       "JOIN a.doctor d")
		List<AppointmentDetails> getAppointmentDetailsWithDoctor();

	@Query("SELECT new com.opd.dto.AppDetailsByPid(d.d_id,a.a_id, a.app_date, a.app_time, a.status, d.firstname, d.lastname, d.specialization) FROM Appointment a JOIN a.patient p JOIN a.doctor d WHERE p.p_id = :id")
	List<AppDetailsByPid> getAppByPid(@Param("id") int id);

	@Query("SELECT NEW com.opd.dto.AppDetailsByDid(a.a_id, p.firstname AS patientFirstName, p.lastname AS patientLastName, a.status, a.app_date, a.app_time) FROM Appointment a JOIN a.doctor d JOIN a.patient p WHERE d.id = :doctorId")
	List<AppDetailsByDid> getAppByDr(@Param("doctorId") int doctorId);

	}