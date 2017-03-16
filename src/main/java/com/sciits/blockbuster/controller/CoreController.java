package com.sciits.blockbuster.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.common.UrlConstants;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.UserAuthDetails;
import com.sciits.blockbuster.services.CoreService;

@Controller
@CrossOrigin
@RequestMapping(value=UrlConstants.Core.API_BASE)
public class CoreController {
	Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	CoreService coreService;
	
	
	
	@RequestMapping(value = UrlConstants.Core.GET_COUNTRIES, method = RequestMethod.GET)
	public @ResponseBody Response getCountries(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getCountries(): ";
		//log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			return coreService.getCountries();
			
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Countries details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	
	
	@RequestMapping(value = UrlConstants.Core.GET_ADDRESS_TYPE_DETAILS, method = RequestMethod.GET)
	public @ResponseBody Response getAddressTypeDetails(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getAddressTypeDetails(): ";
		//log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			return coreService.getAddressType();
			
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Address type  details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
		
	}	
		@RequestMapping(value = UrlConstants.Core.GET_ROLES, method = RequestMethod.GET)
		public @ResponseBody Response getRoles(@RequestParam String authCode) throws BlockbusterException {
			String logTag = "getRoles(): ";
			//log.info("Entering into : "+logTag+ "with authCode: "+authCode);
			UserAuthDetails userAuthDetails = null;
			
			try {
				return coreService.getRoles();
				
			} catch (Exception e) {
				String errMessage = logTag +"Exception occurred while getting the Role  details"+ e;
				log.error(errMessage, e);
				throw new BlockbusterException(errMessage, e);
			}
	
	}

}
