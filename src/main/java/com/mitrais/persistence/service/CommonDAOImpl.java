package com.mitrais.persistence.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

public class CommonDAOImpl implements CommonDAO{

	@Autowired
	public EntityManager em;

	@Override
	@Transactional
	public Object save(Object o) throws DataIntegrityViolationException{
		em.persist(o);
		return o;
	}

	@Override
	@Transactional
	public Object update(Object o) {
		em.merge(o);
		return o;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void delete(String id, Class cls) {
		em.joinTransaction();
		em.createQuery(String.format("delete from %s o where o.id= :idx", cls.getName())).setParameter("idx", id).executeUpdate();
	}


	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public void delete(Long id, Class cls) {
		em.joinTransaction();
		em.createQuery(String.format("delete from %s o where o.id= :idx", cls.getName())).setParameter("idx", id).executeUpdate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object get(String id, Class cls) {
		return em.find(cls, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object get(Long id, Class cls) {
		return em.find(cls, id);
	}

	
}
