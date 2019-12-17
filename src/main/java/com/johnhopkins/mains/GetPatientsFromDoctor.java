package com.johnhopkins.mains;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnhopkins.entities.DoctorEntity;
import com.johnhopkins.entities.PatientEntity;
import com.johnhopkins.repositories.DoctorRepository;
import com.johnhopkins.repositories.PatientRepository;  

public class GetPatientsFromDoctor {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		DoctorRepository dr = (DoctorRepository) ctx.getBean("doctorRepository");
		PatientRepository pr = (PatientRepository) ctx.getBean("patientRepository");
		
		DoctorEntity d1 = dr.getByName("Dr. USCIS");
		List<PatientEntity> patients = d1.getPatients();
		
		for(PatientEntity p: patients) {
			System.out.println(p.toString());
		}
}
}
