package com.dao;

import javax.ejb.Remote;

@Remote
public interface LoginDAOLocal {
	public boolean checkUser(String username, String password);
}
