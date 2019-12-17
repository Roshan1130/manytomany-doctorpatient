package com.johnhopkins.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.johnhopkins.entities.PatientEntity;

public class PatientRepository {
	
	private SessionFactory sessionFactory;
	
	public void savePatientAppointment(PatientEntity patient) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
