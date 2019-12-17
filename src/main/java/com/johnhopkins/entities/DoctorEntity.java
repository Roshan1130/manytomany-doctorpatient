package com.johnhopkins.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
doctorId int auto_increment not null,
doctorName varchar(30) not null,
speciality varchar(25),
type varchar(20),*/

@Entity
@Table (name="doctors")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	
	@Column(name="doctorName")
	private String doctorName;
	
	@Column (name="speciality")
	private String speciality;
	
	@Column (name="type")
	private String type;

	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="patients_doctors", joinColumns= {@JoinColumn(name="doctorId")}, inverseJoinColumns =
	{@JoinColumn(name="patientId")})
	private List<PatientEntity> patients;

	public List<PatientEntity> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientEntity> patients) {
		this.patients = patients;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
