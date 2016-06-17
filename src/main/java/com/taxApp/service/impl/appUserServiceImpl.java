package com.taxApp.service.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxApp.model.appUser;
import com.taxApp.service.appUserService;


@Service
public class appUserServiceImpl implements appUserService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int insertAppUser(appUser _user) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory
                .getCurrentSession()
                .save(_user);
		
	}

	@Transactional
	public appUser findUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		return (appUser) sessionFactory
                .getCurrentSession()
                .createCriteria(appUser.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
		
	}

	@Transactional
	public appUser findUserById(int id) {
		// TODO Auto-generated method stub
		
		return (appUser) sessionFactory
                .getCurrentSession()
                .createCriteria(appUser.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
		
	}
	

}
