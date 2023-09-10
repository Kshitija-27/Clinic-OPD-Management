package com.opd.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppDetailsByDid {
    private int a_id;
    private String patientFirstName;
    private String patientLastName;
    private String status;
    private LocalDate appDate;
    private LocalTime appTime;
	
    public AppDetailsByDid() {
		super();
	}

	public AppDetailsByDid(int a_id, String patientFirstName, String patientLastName, String status, LocalDate appDate,
			LocalTime appTime) {
		super();
		this.a_id = a_id;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.status = status;
		this.appDate = appDate;
		this.appTime = appTime;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

	public LocalTime getAppTime() {
		return appTime;
	}

	public void setAppTime(LocalTime appTime) {
		this.appTime = appTime;
	}

	@Override
	public String toString() {
		return "AppDetailsByDid [a_id=" + a_id + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", status=" + status + ", appDate=" + appDate + ", appTime=" + appTime + "]";
	}
	
}