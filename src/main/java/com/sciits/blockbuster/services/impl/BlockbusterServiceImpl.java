/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sciits.blockbuster.dao.BlockbusterDao;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.services.BlockbusterService;

@Service
public class BlockbusterServiceImpl implements BlockbusterService {
	
	@Autowired
	BlockbusterDao blockbusterDao;
	
	@Override
	public String isValidIp(String ip) throws BlockbusterException {
		return blockbusterDao.isValidIp(ip);
	}
}
