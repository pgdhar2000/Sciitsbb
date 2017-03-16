/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.util;

import com.sciits.blockbuster.exception.BlockbusterException;

public class GreatPlainsManager {

  private static GreatPlainsManager instance = null;

  // ========================================================================

  private GreatPlainsManager() {
  }

  // ========================================================================

  public static synchronized GreatPlainsManager getInstance() {

    if (instance == null) {
      instance = new GreatPlainsManager();
    }
    return instance;
  }

  // ========================================================================
  public Double getPricingDetails(String code) throws BlockbusterException {
		
		
		return 100d;

}
// ========================================================================

public boolean chargePayment(String code)throws BlockbusterException {
		
		
		return true;

}
  

  // ========================================================================
}