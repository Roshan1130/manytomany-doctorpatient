package com.johnhopkins.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.johnhopkins.entities.DoctorEntity;

public class DoctorRepository {
	
	private SessionFactory sessionFactory;

	public DoctorEntity getByName(String dname) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select d from DoctorEntity d where d.doctorName =:name");
		query.setParameter("name", dname);
		List<DoctorEntity> products = query.list();
		session.getTransaction().commit();
		session.close();
		return products.get(0);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
