/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sciits.blockbuster.dao.BlockbusterDao;
import com.sciits.blockbuster.exception.BlockbusterException;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class BlockbusterDaoImpl implements BlockbusterDao {
	Logger log = Logger.getLogger(BlockbusterDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	
	//========================================================================
	
	protected Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	//========================================================================
	
	public void closeSession(Session session) {
		session.close();
	}
	
	//========================================================================
	
	@Override
	public String isValidIp(String ip) throws BlockbusterException {
		// TODO Auto-generated method stub
		return null;
	}

	// ========================================================================
}