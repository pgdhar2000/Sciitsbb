/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.util;

public class PaymentGatewayManager {

  private static PaymentGatewayManager instance = null;

  // ========================================================================

  private PaymentGatewayManager() {
  }

  // ========================================================================

  public static synchronized PaymentGatewayManager getInstance() {

    if (instance == null) {
      instance = new PaymentGatewayManager();
    }
    return instance;
  }

  // ========================================================================

  

  // ========================================================================
}