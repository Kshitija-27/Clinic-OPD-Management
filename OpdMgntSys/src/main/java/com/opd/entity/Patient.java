package com.opd.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	private String firstname;
	private String lastname;
	@Column(unique = true)
	private String username;

	private String password;
	@Column(length = 10, unique = true)
	private String Contact;

	private String MedHistory;
	private String InsrDetail;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Appointment> appointments;

	public Patient() {
		super();
	}

	public Patient(String firstname, String lastname, String contact, String medHistory, String insrDetail) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.Contact = contact;	
		this.MedHistory = medHistory;
		this.InsrDetail = insrDetail;
	}

	
	
	public Patient(String firstname, String lastname, String username, String password, String contact,
			String medHistory, String insrDetail) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.Contact = contact;
		this.MedHistory = medHistory;
		this.InsrDetail = insrDetail;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		this.Contact = contact;
	}

	public String getMedHistory() {
		return MedHistory;
	}

	public void setMedHistory(String medHistory) {
		this.MedHistory = medHistory;
	}

	public String getInsrDetail() {
		return InsrDetail;
	}

	public void setInsrDetail(String insrDetail) {
		this.InsrDetail = insrDetail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [p_id=" + p_id + ", firstname=" + firstname + ", lastname=" + lastname + ", Contact=" + Contact
				+ ", MedHistory=" + MedHistory + ", InsrDetail=" + InsrDetail + "]";
	}

	

}