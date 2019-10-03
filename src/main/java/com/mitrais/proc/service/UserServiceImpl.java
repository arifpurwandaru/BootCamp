package com.mitrais.proc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.exception.DAOException;
import com.mitrais.persistence.entity.MUser;
import com.mitrais.persistence.service.UserDAO;


@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDAO dao;
	
	
	@Override
	public MUser save(MUser user) throws DAOException {
		try {
			return (MUser) dao.save(user);
		}catch(Exception e) {
			throw new DAOException("[define your code here]",e.getMessage());
		}
	}

	@Override
	public List<MUser> getAll() throws DAOException {
		try {
			return dao.getAll();
		}catch(Exception e) {
			throw new DAOException("[define your code here]",e.getMessage());
		}
	}

	@Override
	public MUser update(MUser user) throws DAOException {
		try {
			return (MUser) dao.update(user);
		}catch(Exception e) {
			throw new DAOException("[define your code here]",e.getMessage());
		}
	}

	@Override
	public boolean deleteUser(String id) throws DAOException {
		try {
			dao.delete(id, MUser.class);
			return true;
		}catch(Exception e) {
			throw new DAOException("[define your code here]",e.getMessage());
		}
	}

	@Override
	public MUser get(String userId) throws DAOException {
		try {
			return dao.findByUserId(userId);
		}catch(Exception e) {
			throw new DAOException("[define your code here]",e.getMessage());
		}
	}

}
