/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.AuthenticationDao;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.UserAuthDetails;
import com.sciits.blockbuster.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	public static final Logger log=Logger.getLogger(AuthenticationServiceImpl.class);
	String logTag=null;
	@Autowired
	AuthenticationDao authenticationDao;

	/*@Override
	public boolean isValidAuthcode(String authCode) throws BlockbusterException {
		logTag="isValidAuthcode()";
		log.info("Entering into "+logTag+" with authCode :"+authCode);
		return authenticationDao.isValidAuthcode(authCode);
	}*/

	@Override
	public Response logoutUser(String authCode) throws BlockbusterException {
		logTag="logoutUser()";
		log.info("Entering into "+logTag+" with authCode :"+authCode);
		return authenticationDao.logoutUser(authCode);
	}

	/*@Override
	public Long getUserDetailsId(String authCode) throws BlockbusterException {
		logTag="getUserDetailsId()";
		log.info("Entering into "+logTag+" with authCode: "+authCode);
		return authenticationDao.getUserDetailsId(authCode);
	}*/

	@Override
	public UserAuthDetails getUserAuthDetails(String authCode) throws BlockbusterException {
		return authenticationDao.getUserAuthDetails(authCode);
	}


}
