package com.opd.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppDetailsByPid {
	private int doctorid;
	 private int appointmentId;
	    private LocalDate appointmentDate;
	    private LocalTime appointmentTime;
	    private String appointmentStatus;
	    private String doctorFirstName;
	    private String doctorLastName;
	    private String doctorSpecialization;
		public AppDetailsByPid() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AppDetailsByPid(int doctorid, int appointmentId, LocalDate appointmentDate, LocalTime appointmentTime,
				String appointmentStatus, String doctorFirstName, String doctorLastName, String doctorSpecialization) {
			super();
			this.doctorid = doctorid;
			this.appointmentId = appointmentId;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
			this.appointmentStatus = appointmentStatus;
			this.doctorFirstName = doctorFirstName;
			this.doctorLastName = doctorLastName;
			this.doctorSpecialization = doctorSpecialization;
		}
		public int getDoctorid() {
			return doctorid;
		}
		public void setDoctorid(int doctorid) {
			this.doctorid = doctorid;
		}
		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public LocalTime getAppointmentTime() {
			return appointmentTime;
		}
		public void setAppointmentTime(LocalTime appointmentTime) {
			this.appointmentTime = appointmentTime;
		}
		public String getAppointmentStatus() {
			return appointmentStatus;
		}
		public void setAppointmentStatus(String appointmentStatus) {
			this.appointmentStatus = appointmentStatus;
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
		public String getDoctorSpecialization() {
			return doctorSpecialization;
		}
		public void setDoctorSpecialization(String doctorSpecialization) {
			this.doctorSpecialization = doctorSpecialization;
		}
		@Override
		public String toString() {
			return "AppDetailsByPid [doctorid=" + doctorid + ", appointmentId=" + appointmentId + ", appointmentDate="
					+ appointmentDate + ", appointmentTime=" + appointmentTime + ", appointmentStatus="
					+ appointmentStatus + ", doctorFirstName=" + doctorFirstName + ", doctorLastName=" + doctorLastName
					+ ", doctorSpecialization=" + doctorSpecialization + "]";
		}
		
	    
	    
}
