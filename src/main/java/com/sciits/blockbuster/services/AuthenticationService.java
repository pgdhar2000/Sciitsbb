/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.UserAuthDetails;

public interface AuthenticationService {
	//public boolean isValidAuthcode(String authCode) throws BlockbusterException;
	
    public Response logoutUser(String authCode) throws BlockbusterException;
    
    //public Long getUserDetailsId(String authCode) throws BlockbusterException;
    
    public UserAuthDetails getUserAuthDetails(String authCode) throws BlockbusterException;
}
