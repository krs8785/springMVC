package com.taxApp.service.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxApp.model.AppUser;
import com.taxApp.service.AppUserService;


@Service
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int insertAppUser(AppUser _user) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory
                .getCurrentSession()
                .save(_user);
		
	}

	@Transactional
	public AppUser findUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		return (AppUser) sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
		
	}

	@Transactional
	public AppUser findUserById(int id) {
		// TODO Auto-generated method stub
		
		return (AppUser) sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
		
	}
	

}
