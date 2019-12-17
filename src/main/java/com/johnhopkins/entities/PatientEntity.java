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

@Entity
@Table(name="patients")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@Column (name="patientName")
	private String patientName;
	
	@Column (name = "phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="patients_doctors", joinColumns = {@JoinColumn(name="patientId")}, inverseJoinColumns = {@JoinColumn(name="doctorId")})
	private List<DoctorEntity> doctors;

	public List<DoctorEntity> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorEntity> doctors) {
		this.doctors = doctors;
	}


	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PatientEntity [patientId=" + patientId + ", patientName=" + patientName + ", phone=" + phone
				+ ", address=" + address + ", doctors=" + doctors + "]";
	}
	
	
	
	
}
