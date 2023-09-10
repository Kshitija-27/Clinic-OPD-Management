package com.opd.repository;

import com.opd.dto.AppDetailsByPid;
import com.opd.dto.ScheduleDetails;
import com.opd.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
	@Query("SELECT NEW com.opd.dto.ScheduleDetails(s.s_id, s.dayOfWeek, s.startTime, s.endTime, s.Availability, d.firstname AS doctorFirstName, d.lastname AS doctorLastName) " +
			"FROM Schedule s " +
			"JOIN s.doctor d")
    List<ScheduleDetails> getScheduleDetails();
	
	@Query("SELECT NEW com.opd.dto.ScheduleDetails(s.s_id, s.dayOfWeek, s.startTime, s.endTime, s.Availability, d.firstname AS doctorFirstName, d.lastname AS doctorLastName) " +
	        "FROM Schedule s " +
	        "JOIN s.doctor d " +
	        "WHERE d.id = :did")
	List<ScheduleDetails> getScheduleDetByDr(@Param("did") int did);



}
	