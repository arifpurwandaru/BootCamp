package com.mitrais.persistence.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.persistence.entity.MUser;

@Service
public class UserDAOImpl extends CommonDAOImpl implements UserDAO{
	
	@Autowired
	private EntityManager em;

	@Override
	public List<MUser> getAll() {
		return em.createQuery("select o from MUser o", MUser.class).getResultList();
	}

	@Override
	public MUser findByUserId(String userId) {
		List<MUser> list =  em.createQuery("select o from MUser o where o.userId= :userId",MUser.class)
				.setParameter("userId", userId).getResultList();
		return list!=null&& !list.isEmpty()?list.get(0):null;
	}

}
