package com.opd.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDetails {
	private int a_id;
	private LocalDate app_date;
	private LocalTime app_time;
	private String status;
	private String patient_firstname;
	private String patient_lastname;
	private String doctor_firstname;
	private String doctor_lastname;
	public AppointmentDetails(int a_id, LocalDate app_date, LocalTime app_time, String status, String patient_firstname,
			String patient_lastname, String doctor_firstname, String doctor_lastname) {
		super();
		this.a_id = a_id;
		this.app_date = app_date;
		this.app_time = app_time;
		this.status = status;
		this.patient_firstname = patient_firstname;
		this.patient_lastname = patient_lastname;
		this.doctor_firstname = doctor_firstname;
		this.doctor_lastname = doctor_lastname;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
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
	public String getPatient_firstname() {
		return patient_firstname;
	}
	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}
	public String getPatient_lastname() {
		return patient_lastname;
	}
	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}
	public String getDoctor_firstname() {
		return doctor_firstname;
	}
	public void setDoctor_firstname(String doctor_firstname) {
		this.doctor_firstname = doctor_firstname;
	}
	public String getDoctor_lastname() {
		return doctor_lastname;
	}
	public void setDoctor_lastname(String doctor_lastname) {
		this.doctor_lastname = doctor_lastname;
	}
	@Override
	public String toString() {
		return "AppointmentDetails [a_id=" + a_id + ", app_date=" + app_date + ", app_time=" + app_time + ", status="
				+ status + ", patient_firstname=" + patient_firstname + ", patient_lastname=" + patient_lastname
				+ ", doctor_firstname=" + doctor_firstname + ", doctor_lastname=" + doctor_lastname + "]";
	}

	
}
