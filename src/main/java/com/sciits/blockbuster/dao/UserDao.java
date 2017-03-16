/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.model.UserDetails;
import com.sciits.blockbuster.dao.model.UserDetailsTbl;
import com.sciits.blockbuster.dao.model.UserLoginTbl;
import com.sciits.blockbuster.dao.model.UserSecondaryAuthorizationDetails;
import com.sciits.blockbuster.dao.model.UserSignupTbl;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.ChangePassword;

public interface UserDao  {
	
	public boolean isUserExist(String userName) throws BlockbusterException;

	public Response addUser(UserDetails user) throws BlockbusterException;

	public Response loginUser(UserLoginTbl userLoginTbl) throws BlockbusterException;

	public Response getUsers(Long userDetailsId) throws BlockbusterException;

	public Response getUser(Long userDetailsId) throws BlockbusterException;

	public Response updateUser(UserDetails user) throws BlockbusterException;

	public Response deleteUser(Long userDetailsId) throws BlockbusterException;
	
	public Response activateUser(Long userDetailsId) throws BlockbusterException;
	
	public Response upload(CommonsMultipartFile userPhoto,Long userDetailsId) throws BlockbusterException;
	
    public UserDetails getUserDetails(Long userDetailsId) throws BlockbusterException;
    
    public Response changePassword(ChangePassword changePassword ,Long userDetailsId) throws BlockbusterException;
    
    public Response firstTimeLoginChangePassword(ChangePassword changePassword ,Long userDetailsId) throws BlockbusterException;

    public Response resetPassword(Long userDetailsId) throws BlockbusterException;
    
    public Response getSecondaryAuthorizationDetailsQuesitions() throws BlockbusterException;
    
    public Response getUserSecondaryAuthorizationDetails(Long userDetailsId) throws BlockbusterException;
    
    public Response saveUserSecondaryAuthorizationDetails(UserSecondaryAuthorizationDetails userSecondaryAuthorizationDetails) throws BlockbusterException;
    
    public Response updateUserSecondaryAuthorizationDetails(UserSecondaryAuthorizationDetails userSecondaryAuthorizationDetails) throws BlockbusterException;
    
    public String getEmailAddresses(Long roleId) throws BlockbusterException;
    
    public Response userSignup(UserSignupTbl signupTbl) throws BlockbusterException;
}
