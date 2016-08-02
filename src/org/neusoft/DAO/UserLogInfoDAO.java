package org.neusoft.DAO;

import org.hibernate.SessionFactory;
import org.neusoft.hb.entites.Userloginfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserLogInfoDAO extends BaseDAO<Userloginfo> {
	@Autowired
	public UserLogInfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
