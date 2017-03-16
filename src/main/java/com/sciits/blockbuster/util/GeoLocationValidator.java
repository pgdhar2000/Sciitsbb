/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.util;

import com.sciits.blockbuster.dao.BlockbusterDao;
import com.sciits.blockbuster.exception.BlockbusterException;

public class GeoLocationValidator {

  private static GeoLocationValidator instance = null;
  private BlockbusterDao blockbusterDao = null;

  // ========================================================================

  private GeoLocationValidator() {
  }

  // ========================================================================

  public static synchronized GeoLocationValidator getInstance() {

    if (instance == null) {
      instance = new GeoLocationValidator();
    }
    return instance;
  }

  // ========================================================================
  
  public void setBlockbusterDao(BlockbusterDao blockbusterDao) {
	  this.blockbusterDao = blockbusterDao;
  }
  
  //========================================================================

  private Long getIpNumber(String ipAddress) throws BlockbusterException {
	Long ipNumber = 0L; 
	if(ipAddress != null && ipAddress.trim().length() > 0) {
		String ipSplit[] = ipAddress.split("\\.");
		if(ipSplit != null && ipSplit.length >= 4) {
			ipNumber = (Long.parseLong(ipSplit[3]) 
					+ (Long.parseLong(ipSplit[2]) * 256)
					+ (Long.parseLong(ipSplit[1]) * 256 * 256) 
					+ (Long.parseLong(ipSplit[0]) * 256 * 256 * 256));
		}
	}
	return ipNumber;
  }

  // ========================================================================
  
  public String isValidIp(String ipAddress) throws BlockbusterException {
	String result = null;
	Long ipNumber = 0L;
	
	try {
		ipNumber = getIpNumber(ipAddress);
		
		if(ipNumber != null) {
			//Need to validate whether the ipNumber is within the range of a country or not
			result = blockbusterDao.isValidIp(ipAddress);
		}
	} catch (Exception e) {
		throw new BlockbusterException("Exception in isValidIp method", e);
	}
	return result;
  }
}