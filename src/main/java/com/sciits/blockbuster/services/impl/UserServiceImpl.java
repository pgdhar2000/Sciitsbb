/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.UserDao;
import com.sciits.blockbuster.dao.model.UserDetails;
import com.sciits.blockbuster.dao.model.UserLoginTbl;
import com.sciits.blockbuster.dao.model.UserSecondaryAuthorizationDetails;
import com.sciits.blockbuster.dao.model.UserSignupTbl;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.ChangePassword;
import com.sciits.blockbuster.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger log=Logger.getLogger(UserServiceImpl.class);
	String logTag=null;
	@Autowired
	UserDao userDao;

	@Override
	public boolean isUserExist(String userName) throws BlockbusterException {
		logTag="isUserExist()";
		log.info("Entering into"+logTag+" with userName: "+userName);
		return userDao.isUserExist(userName);
	}

	@Override
	public Response addUser(UserDetails user) throws BlockbusterException {
		logTag="addUser()";
		log.info("Entering into"+logTag+"with user details.");
		return userDao.addUser(user);
	}

	@Override
	public Response loginUser(UserLoginTbl userLoginTbl) throws BlockbusterException {
		logTag="loginUser()";
		log.info("Entering into"+logTag+"with user details.");
		return userDao.loginUser(userLoginTbl);
	}

	@Override

	public Response getUsers(Long userDetailsId) throws BlockbusterException {
		return userDao.getUsers(userDetailsId);
	}

	@Override
	public Response getUser(Long userDetailsId) throws BlockbusterException {
		logTag="getUser()";
		log.info("Entering into"+logTag+" with userDetailsId: "+userDetailsId);
		return userDao.getUser(userDetailsId);
		
	}

	@Override
	public Response updateUser(UserDetails user) throws BlockbusterException {
		logTag="updateUser()";
		log.info("Entering into"+logTag+" with user details.");
		return userDao.updateUser(user);
	}

	@Override
	public Response deleteUser(Long userDetailsId) throws BlockbusterException {
		logTag="deleteUser()";
		log.info("Entering into"+logTag+" with userDetailsId: "+userDetailsId);
		return userDao.deleteUser(userDetailsId);
	}

	@Override
	public Response upload(CommonsMultipartFile userPhoto,Long userDetailsId) throws BlockbusterException {
		logTag="upload()";
		log.info("Entering into"+logTag+" with userPhoto and userDetailsId: "+userDetailsId);
		return userDao.upload(userPhoto,userDetailsId);
	}

	@Override
	public UserDetails getUserDetails(Long userDetailsId) throws BlockbusterException {
		logTag="getUserDetails()";
		log.info("Entering into"+logTag+" with userDetailsId: "+userDetailsId);
		return userDao.getUserDetails(userDetailsId);
	}

	@Override
	public Response changePassword(ChangePassword changePassword ,Long userDetailsId ) throws BlockbusterException {
		logTag="changePassword()";
		log.info("Entering into"+logTag+" with password: "+changePassword+" userDetailsId: "+userDetailsId);
		return userDao.changePassword(changePassword ,userDetailsId);
	}

	@Override
	public Response firstTimeLoginChangePassword(ChangePassword changePassword ,Long userDetailsId ) throws BlockbusterException {
		logTag="firstTimeLoginChangePassword()";
		log.info("Entering into"+logTag+" with password: "+changePassword+" userDetailsId: "+userDetailsId);
		return userDao.firstTimeLoginChangePassword(changePassword ,userDetailsId);
	}
	
	@Override
	public Response activateUser(Long userDetailsId) throws BlockbusterException {
		logTag="activateUser()";
		log.info("Entering into"+logTag+" with userDetailsId: "+userDetailsId);
		return userDao.activateUser(userDetailsId);
	}

	@Override
	public Response resetPassword(Long userDetailsId) throws BlockbusterException {
		return userDao.resetPassword(userDetailsId);
	}
	@Override
	public Response getSecondaryAuthorizationDetailsQuesions() throws BlockbusterException {
		return userDao.getSecondaryAuthorizationDetailsQuesitions();
	}
	@Override
	public Response getUserSecondaryAuthorizationDetails(Long userDetailsId) throws BlockbusterException {
		return userDao.getUserSecondaryAuthorizationDetails(userDetailsId);
	}
	@Override
	public Response saveUserSecondaryAuthorizationDetails(UserSecondaryAuthorizationDetails userSecondaryAuthorizationDetails) throws BlockbusterException {
		return userDao.saveUserSecondaryAuthorizationDetails(userSecondaryAuthorizationDetails);
	}
	@Override
	public Response updateUserSecondaryAuthorizationDetails(UserSecondaryAuthorizationDetails userSecondaryAuthorizationDetails) throws BlockbusterException {
		return userDao.updateUserSecondaryAuthorizationDetails(userSecondaryAuthorizationDetails);
	}

	@Override
	public String getEmailAddresses(Long roleId) throws BlockbusterException {
		return userDao.getEmailAddresses(roleId);
	}

	@Override
	public Response userSignup(UserSignupTbl userSignupTbl) throws BlockbusterException {
		logTag="userSignup()";
		log.info("Entering into"+logTag+"with user details.");
		return userDao.userSignup(userSignupTbl);
	}
}
