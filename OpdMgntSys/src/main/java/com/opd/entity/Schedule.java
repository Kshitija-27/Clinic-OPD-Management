package com.opd.entity;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;

	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "d_id")
	private Doctor doctor;

	private String dayOfWeek;

	private LocalTime startTime;
	private LocalTime endTime;

	private boolean Availability;

	public Schedule() {
		super();
	}

	public Schedule(Doctor doctor, String dayOfWeek, LocalTime startTime, LocalTime endTime, boolean availability) {
		super();
		this.doctor = doctor;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.Availability = availability;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public boolean isAvailability() {
		return Availability;
	}

	public void setAvailability(boolean availability) {
		this.Availability = availability;
	}

	@Override
	public String toString() {
		return "Schedule [s_id=" + s_id + ", doctor=" + doctor + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", Availability=" + Availability + "]";
	}

	

}
