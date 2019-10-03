package com.mitrais.proc.service;

import java.util.List;

import com.mitrais.exception.DAOException;
import com.mitrais.persistence.entity.MUser;

public interface UserService {
	public MUser save(MUser user) throws DAOException;
	
	public List<MUser> getAll() throws DAOException;
	
	public MUser update(MUser user) throws DAOException;
	
	public boolean deleteUser(String userId) throws DAOException;
	
	public MUser get(String userId) throws DAOException;
}
