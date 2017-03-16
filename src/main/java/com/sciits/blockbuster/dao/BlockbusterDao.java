package com.sciits.blockbuster.dao;

import com.sciits.blockbuster.exception.BlockbusterException;

public interface BlockbusterDao {
	public String isValidIp(String ip) throws BlockbusterException;
}
