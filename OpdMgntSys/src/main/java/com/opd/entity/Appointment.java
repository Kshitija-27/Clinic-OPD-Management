package com.opd.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a_id;

	@ManyToOne
	@JoinColumn(name = "p_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "d_id")
	private Doctor doctor;
	
	private LocalDate app_date;

	private LocalTime app_time;

	private String status;
	
	@OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Reminder> reminder;

	@OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Queue> queue;

	public Appointment() {
		super();
	}

	public Appointment(Patient patient, Doctor doctor, LocalDate app_date, LocalTime app_time, String status) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.app_date = app_date;
		this.app_time = app_time;
		this.status = status;
	}

	
	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getApp_date() {
		return app_date;
	}

	public void setApp_date(LocalDate app_date) {
		this.app_date = app_date;
	}

	public LocalTime getApp_time() {
		return app_time;
	}

	public void setApp_time(LocalTime app_time) {
		this.app_time = app_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Reminder> getReminder() {
		return reminder;
	}

	public void setReminder(List<Reminder> reminder) {
		this.reminder = reminder;
	}

	public List<Queue> getQueue() {
		return queue;
	}

	public void setQueue(List<Queue> queue) {
		this.queue = queue;
	}

	@Override
	public String toString() {
		return "Appointment [a_id=" + a_id + ", patient=" + patient + ", doctor=" + doctor + ", app_date=" + app_date
				+ ", app_time=" + app_time + ", status=" + status + "]";
	}

}
