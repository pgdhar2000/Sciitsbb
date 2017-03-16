package com.sciits.blockbuster.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.dao.CoreDao;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.services.CoreService;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	CoreDao coredao;
	
	@Override
	public Response getCountries() throws BlockbusterException {
		return coredao.getCountries();
	}

	@Override
	public Response getAddressType() throws BlockbusterException {
		return coredao.getAddressType();
	}
	
	@Override
	public Response getRoles() throws BlockbusterException {
		return coredao.getRoles();
	}

}
