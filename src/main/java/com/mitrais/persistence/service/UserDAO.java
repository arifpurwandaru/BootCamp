package com.mitrais.persistence.service;

import java.util.List;

import com.mitrais.persistence.entity.MUser;

public interface UserDAO extends CommonDAO{
	public List<MUser> getAll();
	
	public MUser findByUserId(String userId);
}
