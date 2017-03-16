/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services;

import org.springframework.web.bind.annotation.RequestParam;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.model.MbcTbl;
import com.sciits.blockbuster.exception.BlockbusterException;

public interface IncorporationService {
	
	 public Response addIncorporation(MbcTbl mbcDetails) throws BlockbusterException;
	// public Response addIncorporation(MbcTbl mbcDetails, String participantFirstName,  String  participantLastName,  int participantCountryId,
	//	 String prinicpalFirstName,  String  prinicpalLastName,  int prinicpalCountryId	 ) throws BlockbusterException;   
	 public Response getCountries() throws BlockbusterException;
	 
	 public Response getBusinessPurposes() throws BlockbusterException;
	 
	 public Response getRegistredAgents() throws BlockbusterException;
	 
	 public Response getIncorporationDetails(Long mbcId) throws BlockbusterException;
	 
	 public Response getIncorporations() throws BlockbusterException;
}
