/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.controller;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.base.ResponseCodes;
import com.sciits.blockbuster.base.SessionBase;

public abstract class BaseController extends SessionBase {

	public Response getInvalidAuthCodeResponse() {
		Response invalidAuthCodeResponse = new Response();
		invalidAuthCodeResponse.setMessage("Invalid AuthCode");
		invalidAuthCodeResponse.setResponseCode(ResponseCodes.OK.getCode());
		return invalidAuthCodeResponse;
	}

	public Response getInvalidAccessResponse() {
		Response invalidAuthCodeResponse = new Response();
		invalidAuthCodeResponse.setMessage("Unauthorized Access");
		invalidAuthCodeResponse.setResponseCode(ResponseCodes.OK.getCode());
		return invalidAuthCodeResponse;
	}

}
