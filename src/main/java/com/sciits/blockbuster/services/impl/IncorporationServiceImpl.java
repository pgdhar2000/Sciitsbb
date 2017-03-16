/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.IncorporationDao;
import com.sciits.blockbuster.dao.model.MbcTbl;
import com.sciits.blockbuster.dao.model.ParticipantShareholderTbl;
import com.sciits.blockbuster.dao.model.PrincipalShareholderTbl;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.services.IncorporationService;

@Service
public class IncorporationServiceImpl implements IncorporationService {
	
	@Autowired
	IncorporationDao incorporationDao ;

	@Override
	 public Response addIncorporation(MbcTbl mbcDetails)throws BlockbusterException {
		return incorporationDao.addIncorporation(mbcDetails);
	}

	@Override
	public Response getCountries() throws BlockbusterException {
		return incorporationDao.getCountries();
	}

	@Override
	public Response getBusinessPurposes() throws BlockbusterException {
		return incorporationDao.getBusinessPurposes();
	}

	@Override
	public Response getRegistredAgents() throws BlockbusterException {
		return incorporationDao.getRegistredAgents();
	}

	@Override
	public Response getIncorporationDetails(Long mbcId) throws BlockbusterException {
		return incorporationDao.getIncorporationDetails(mbcId);
	}

	@Override
	public Response getIncorporations() throws BlockbusterException {
		return incorporationDao.getIncorporations();
	}
}
