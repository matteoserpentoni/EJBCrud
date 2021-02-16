package com.dao;

import com.model.Login;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginDAO implements LoginDAOLocal {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean checkUser(String userName, String password) {

		List<Login> s = (List<Login>) em
				.createQuery(
						"select e from Login e where e.userName='" + userName + "' and e.password='" + password + "'")
				.getResultList();
		System.out.println("is list empty ? " + s.isEmpty() + " for " + userName + " and " + password);

		if (!s.isEmpty())
			return true;
		else
			return false;
	}
}