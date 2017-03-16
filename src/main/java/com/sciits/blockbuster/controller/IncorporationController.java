/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.common.UrlConstants;
import com.sciits.blockbuster.dao.model.AddressDetailsTbl;
import com.sciits.blockbuster.dao.model.BusinessPurposeDetails;
import com.sciits.blockbuster.dao.model.CountryDetails;
import com.sciits.blockbuster.dao.model.MbcDetails;
import com.sciits.blockbuster.dao.model.MbcTbl;
import com.sciits.blockbuster.dao.model.ParticipantShareholderTbl;
import com.sciits.blockbuster.dao.model.PrincipalShareholderTbl;
import com.sciits.blockbuster.dao.model.RegisteredAgentDetails;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.UserAuthDetails;
import com.sciits.blockbuster.services.AuthenticationService;
import com.sciits.blockbuster.services.IncorporationService;
import com.sciits.blockbuster.util.GeoLocationValidator;
import com.sciits.blockbuster.util.GreatPlainsManager;

@Controller
@CrossOrigin
@RequestMapping(value=UrlConstants.Incorporation.API_BASE)
public class IncorporationController extends BaseController{

	Logger log = Logger.getLogger(IncorporationController.class);
	
	@Autowired
	IncorporationService incorporationService;
	
	@Autowired
	AuthenticationService authenticationService;
	
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.ADD, method = RequestMethod.POST)
	public @ResponseBody Response addIncorporation(@RequestBody MbcTbl mbcDetails,HttpServletRequest request,
		@RequestParam String authCode) throws BlockbusterException {
		String logTag = "addIncorporation(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		Boolean paymentStatus = false;
		//Double fee = 0d;
		
		try {
			//userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			GeoLocationValidator geoLocationValidator =GeoLocationValidator.getInstance();
			GreatPlainsManager greatPlainsManager = GreatPlainsManager.getInstance();
			
			//if(userAuthDetails.isValidAuthCode()) {
				//if(Constants.SUPER_USER.compareTo(userAuthDetails.getRoleId()) == 0 || Constants.REGISTERED_AGENT.compareTo(userAuthDetails.getRoleId()) == 0) {
						//if(geoLocationValidator.isValidIp(request.getRemoteAddr()).equals("success")){
							
							// check unique name
							//incorporationService.checkMBCName(mbcTbl.getMbcLegalName());
							
							//store MBC details
							incorporationService.addIncorporation(mbcDetails);
							
							//get Fee
							//fee = greatPlainsManager.getPricingDetails("INCORPORATION");
							
							// Deduct fee from RA account
							paymentStatus = greatPlainsManager.chargePayment("INCORPORATION");
						
							if(!paymentStatus){
								//TODO Return failure transaction
							}else{
								//return success transaction
							}
						//}else {
						//	return getInvalidAccessResponse();
						//} 
				//}
				//else {
				//	return getInvalidAccessResponse();
				//}
			//} else {
			//	return getInvalidAuthCodeResponse();
			//}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while adding the Incorporation"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
		return null;
	
	}
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.GET_COUNTRIES, method = RequestMethod.GET)
	public @ResponseBody Response getCountries(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getCountries(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			
			if(userAuthDetails.isValidAuthCode()) {
				return incorporationService.getCountries();
			} else {
				return getInvalidAuthCodeResponse();
			}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Countries details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.GET_BUSINESS_PURPOSES, method = RequestMethod.GET)
	public @ResponseBody Response getBusinessPurposes(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getBusinessPurposes(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			
			if(userAuthDetails.isValidAuthCode()) {
				return incorporationService.getBusinessPurposes();
			} else {
				return getInvalidAuthCodeResponse();
			}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Business Purposes details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.GET_REGISTERD_AGENTS, method = RequestMethod.GET)
	public @ResponseBody Response getRegistredAgents(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getRegistredAgents(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			
			if(userAuthDetails.isValidAuthCode()) {
				return incorporationService.getRegistredAgents();
			} else {
				return getInvalidAuthCodeResponse();
			}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Registred Agents details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.GET, method = RequestMethod.POST)
	public @ResponseBody Response getIncorporation(@RequestParam Long mbcId, @RequestParam String authCode) throws BlockbusterException {
		String logTag = "getIncorporation(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			
			if(userAuthDetails.isValidAuthCode()) {
				if(Constants.SUPER_USER.compareTo(userAuthDetails.getRoleId()) == 0 || Constants.REGISTERED_AGENT.compareTo(userAuthDetails.getRoleId()) == 0) {
					return incorporationService.getIncorporationDetails(mbcId); 
				} else {
					return getInvalidAccessResponse();
				}
			} else {
				return getInvalidAuthCodeResponse();
			}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Incorporation details"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	//========================================================================
	
	@RequestMapping(value = UrlConstants.Incorporation.GET_INCORPORATIONS, method = RequestMethod.GET)
	public @ResponseBody Response getIncorporations(@RequestParam String authCode) throws BlockbusterException {
		String logTag = "getIncorporations(): ";
		log.info("Entering into : "+logTag+ "with authCode: "+authCode);
		UserAuthDetails userAuthDetails = null;
		
		try {
			userAuthDetails = authenticationService.getUserAuthDetails(authCode);
			
			if(userAuthDetails.isValidAuthCode()) {
				if(Constants.SUPER_USER.compareTo(userAuthDetails.getRoleId()) == 0 || Constants.REGISTERED_AGENT.compareTo(userAuthDetails.getRoleId()) == 0) {
					return incorporationService.getIncorporations(); 
				} else {
					return getInvalidAccessResponse();
				}
			} else {
				return getInvalidAuthCodeResponse();
			}
		} catch (Exception e) {
			String errMessage = logTag +"Exception occurred while getting the Incorporations"+ e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		}
	
	}
	
	//========================================================================
}
