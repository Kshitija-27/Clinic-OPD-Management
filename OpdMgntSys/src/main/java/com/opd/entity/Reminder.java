package com.opd.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_id;

	@ManyToOne
	@JoinColumn(name = "a_id")
	private Appointment appointment;

	private String r_type;

	private LocalDate date;

	public Reminder() {
		super();
	}

	public Reminder(int r_id, Appointment appointment, String r_type, LocalDate date) {
		super();
		this.r_id = r_id;
		this.appointment = appointment;
		this.r_type = r_type;
		this.date = date;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reminder [r_id=" + r_id + ", appointment=" + appointment + ", r_type=" + r_type + ", date=" + date
				+ "]";
	}

}
