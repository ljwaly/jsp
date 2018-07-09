package com.ljw.repository.people;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentRepositoryImpl implements StudentExInterface{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int creatMyMethod() {

		String update =
				"UPDATE Student stu " +
				"SET stu.name='fff' " +
				"WHERE stu.studentId =1"
				;
		
		return em.createQuery(update).executeUpdate();
	}

}
