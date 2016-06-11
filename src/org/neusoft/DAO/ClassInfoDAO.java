package org.neusoft.DAO;

import org.hibernate.SessionFactory;
import org.neusoft.hb.entites.Classinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ClassInfoDAO extends BaseDAO<Classinfo> {
	@Autowired
	public ClassInfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
