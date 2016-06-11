package org.neusoft.DAO;

import org.hibernate.SessionFactory;
import org.neusoft.hb.entites.Studentandsubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentAndSubjectDAO extends BaseDAO<Studentandsubject> {
	@Autowired
	public StudentAndSubjectDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
