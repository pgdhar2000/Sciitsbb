package com.sciits.blockbuster.services;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.exception.BlockbusterException;

public interface CoreService {
	
	 public Response getCountries() throws BlockbusterException;
	 public Response getAddressType() throws BlockbusterException;
	 public Response getRoles() throws BlockbusterException;

}
