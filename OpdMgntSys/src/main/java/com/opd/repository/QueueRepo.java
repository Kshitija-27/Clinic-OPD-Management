package com.opd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opd.dto.QueueDetails;
import com.opd.entity.Queue;

@Repository
public interface QueueRepo extends JpaRepository<Queue, Integer> {
	
	@Query("SELECT NEW com.opd.dto.QueueDetails(q.appointment.patient.firstname, q.appointment.patient.lastname, q.appointment.doctor.firstname, q.appointment.doctor.lastname, q.appointment.app_date, q.q_number, q.appointment.app_time, q.q_status, q.q_id) FROM Queue q WHERE q.appointment.app_date= :date")
	List<QueueDetails> getQueue(@Param("date")LocalDate date);

	@Query("SELECT NEW com.opd.dto.QueueDetails(q.appointment.patient.firstname, q.appointment.patient.lastname, q.appointment.doctor.firstname, q.appointment.doctor.lastname, q.appointment.app_date, q.q_number, q.appointment.app_time, q.q_status, q.q_id) FROM Queue q")
	List<QueueDetails> getAllQueueDetails();
}
