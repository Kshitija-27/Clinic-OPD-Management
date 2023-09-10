package com.opd.dto;

import java.time.LocalTime;

public class ScheduleDetails {
    private int s_id;
    private String dayOfWeek;
    private LocalTime startTime;  // Change data type to LocalTime
    private LocalTime endTime;    // Change data type to LocalTime
    private boolean Availability;
    private String doctorFirstName;
    private String doctorLastName;

public ScheduleDetails(int s_id, String dayOfWeek, LocalTime startTime, LocalTime endTime, boolean availability,
				String doctorFirstName, String doctorLastName) {
			super();
			this.s_id = s_id;
			this.dayOfWeek = dayOfWeek;
			this.startTime = startTime;
			this.endTime = endTime;
			this.Availability = availability;
			this.doctorFirstName = doctorFirstName;
			this.doctorLastName = doctorLastName;
		}
		public int getS_id() {
			return s_id;
		}
		public void setS_id(int s_id) {
			this.s_id = s_id;
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
		public boolean getAvailability() {
			return Availability;
		}
		public void setAvailability(boolean availability) {
			this.Availability = availability;
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
		@Override
		public String toString() {
			return "ScheduleDetails [s_id=" + s_id + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
					+ ", endTime=" + endTime + ", availability=" + Availability + ", doctorFirstName=" + doctorFirstName
					+ ", doctorLastName=" + doctorLastName + "]";
		}

		
}
