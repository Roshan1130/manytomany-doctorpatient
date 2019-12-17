package com.johnhopkins.mains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnhopkins.entities.DoctorEntity;
import com.johnhopkins.entities.PatientEntity;
import com.johnhopkins.repositories.DoctorRepository;
import com.johnhopkins.repositories.PatientRepository;

public class InsertPatientWithDoctors {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		DoctorRepository dr = (DoctorRepository) ctx.getBean("doctorRepository");
		PatientRepository pr = (PatientRepository) ctx.getBean("patientRepository");
		
		
		DoctorEntity d1 = dr.getByName("Dr. USCIS");
		//DoctorEntity d2 = dr.getByName("Dr. Ramtel");
		
		List<DoctorEntity> doctors = new ArrayList<DoctorEntity>();
		doctors.add(d1);
		//doctors.add(d2);
		PatientEntity p =new PatientEntity();
		p.setPatientName("Mani Vai");
		p.setAddress("9345 lee highway");
		p.setPhone("+6937847333");
		p.setDoctors(doctors);
		
		pr.savePatientAppointment(p);
		System.out.println("Done");
		
	}

}
