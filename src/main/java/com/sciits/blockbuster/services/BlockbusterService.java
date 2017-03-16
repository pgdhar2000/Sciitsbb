package com.sciits.blockbuster.services;

import com.sciits.blockbuster.exception.BlockbusterException;

public interface BlockbusterService {
	
	public String isValidIp(String ip) throws BlockbusterException;

}
