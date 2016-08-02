package org.neusoft.DAO;

import org.hibernate.SessionFactory;
import org.neusoft.hb.entites.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDAO extends BaseDAO<Userinfo> {

	@Autowired
	public UserInfoDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
