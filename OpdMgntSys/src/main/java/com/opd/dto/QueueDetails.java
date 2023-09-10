package com.opd.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class QueueDetails {
	private String patientFirstName;
	private String patientLastName;
	private String doctorFirstName;
	private String doctorLastName;
	private LocalDate appdate;
	private int queuenumber;
	private LocalTime appTime;
	private String status;
	private int id;

	public QueueDetails() {
		super();
	}

	public QueueDetails(String patientFirstName, String patientLastName, String doctorFirstName, String doctorLastName,
			LocalDate appdate, int queuenumber, LocalTime appTime, String status, int id) {
		super();
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
		this.appdate = appdate;
		this.queuenumber = queuenumber;
		this.appTime = appTime;
		this.status = status;
		this.id = id;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	public LocalDate getAppdate() {
		return appdate;
	}

	public void setAppdate(LocalDate appdate) {
		this.appdate = appdate;
	}

	public int getQueuenumber() {
		return queuenumber;
	}

	public void setQueuenumber(int queuenumber) {
		this.queuenumber = queuenumber;
	}

	public LocalTime getAppTime() {
		return appTime;
	}

	public void setAppTime(LocalTime appTime) {
		this.appTime = appTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
