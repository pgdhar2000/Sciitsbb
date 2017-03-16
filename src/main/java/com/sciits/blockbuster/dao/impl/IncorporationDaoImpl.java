/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sciits.blockbuster.base.BlockbusterDao;
import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.base.ResponseCodes;
import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.dao.IncorporationDao;
import com.sciits.blockbuster.dao.model.AddressDetailsTbl;
import com.sciits.blockbuster.dao.model.BusinessPurposeDetails;
import com.sciits.blockbuster.dao.model.CountryDetails;
import com.sciits.blockbuster.dao.model.CountryTbl;
import com.sciits.blockbuster.dao.model.MbcTbl;
import com.sciits.blockbuster.dao.model.ParticipantShareholderTbl;
import com.sciits.blockbuster.dao.model.PrincipalShareholderTbl;
import com.sciits.blockbuster.dao.model.MbcDetails;
import com.sciits.blockbuster.dao.model.RegisteredAgentDetails;
import com.sciits.blockbuster.dao.model.UserTbl;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.web.model.WebBusinessPurposeDetails;
import com.sciits.blockbuster.web.model.WebCountryDetails;
import com.sciits.blockbuster.web.model.WebMbcDetails;
import com.sciits.blockbuster.web.model.WebRegistredAgentDetails;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class IncorporationDaoImpl extends BlockbusterDao<Serializable, MbcTbl> implements IncorporationDao {
	Logger log = Logger.getLogger(IncorporationDaoImpl.class);

	// ========================================================================

	@Override
	public Response addIncorporation(MbcTbl mbcDetails) throws BlockbusterException {
		String logTag = "addIncorporation(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		
		try {
			session = getSession();
			AddressDetailsTbl addressDetails = mbcDetails.getAddressDetailsTbl();
			addressDetails.setCreatedDatetime(new Date());
			UserTbl userTbl = new UserTbl();
			userTbl.setUserId(1);
			addressDetails.setUserTbl(userTbl);
			session.saveOrUpdate(addressDetails);
			
			MbcTbl mbcDetailsObj=  mbcDetails;
			mbcDetailsObj.setCreatedDatetime(new Date());
			mbcDetailsObj.setMbcNumber("5555");
			mbcDetailsObj.setMbcUniqueId(555);
			mbcDetailsObj.setUserTblByCreatedBy(userTbl);
			//mbcDetailsObj.setMbcGrossAssets(new BigDecimal(0));
			//mbcDetailsObj.setMbcNumberEmployees(0L);
			session.saveOrUpdate(mbcDetailsObj);
			
			ParticipantShareholderTbl participantShareholderDetails=mbcDetails.getParticipantShareholderTbl();
			participantShareholderDetails.setCreatedDatetime(new Date());
			participantShareholderDetails.setMbcTbl(mbcDetailsObj);
			participantShareholderDetails.setUserTbl(userTbl);
			session.saveOrUpdate(participantShareholderDetails);
			
			PrincipalShareholderTbl principalShareholderDetails=mbcDetails.getPrincipalShareholderTbl();
			principalShareholderDetails.setCreatedDatetime(new Date());
			principalShareholderDetails.setMbcTbl(mbcDetailsObj);
			principalShareholderDetails.setUserTbl(userTbl);
			session.saveOrUpdate(principalShareholderDetails);
			
			
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while adding the incorporation." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Incorporation added successfully", ResponseCodes.OK.getCode(), null);
	}

	// ========================================================================
	
	@Override
	public Response getIncorporationDetails(Long mbcId) throws BlockbusterException {
		String logTag = "getIncorporation(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		MbcDetails mbcDetails = null;
		
		try {
			if (mbcId == null) {
				return new Response(false, Constants.Incorporation.MBC_ID_NULL, ResponseCodes.BAD_REQUEST.getCode(), null);
			}
			session = getSession();
			log.info(logTag + "getting the mbc details with the mbcId: "+mbcId);
			mbcDetails = (MbcDetails) session.get(MbcDetails.class, mbcId);
			
			if(mbcDetails == null) {
				return new Response(false, Constants.Incorporation.INVALID_MBC_ID, ResponseCodes.BAD_REQUEST.getCode(), null);
			} else {
				return new Response(false, Constants.Incorporation.MBC_DETAILS, ResponseCodes.OK.getCode(), mbcDetails.getWebMbcDetails());
			}
			
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the incorporation." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
	}

	// ========================================================================
	
	@SuppressWarnings("unchecked")
	@Override
	public Response getCountries() throws BlockbusterException {
		String logTag = "getCountries(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		ArrayList<WebCountryDetails> webCountriesDetails = new ArrayList<>();
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(CountryDetails.class);
			List<CountryDetails> countries = criteria.list();
			
			//for (CountryDetails countryDetails : countries) {
			//	webCountriesDetails.add(countryDetails.getWebCountryDetails());
			//}
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the countries." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Countries", ResponseCodes.OK.getCode(), webCountriesDetails);
	}

	// ========================================================================
	
	@SuppressWarnings("unchecked")
	@Override
	public Response getBusinessPurposes() throws BlockbusterException {
		String logTag = "getBusinessPurposes(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		ArrayList<WebBusinessPurposeDetails> webBusinessPurposes = new ArrayList<WebBusinessPurposeDetails>();
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(BusinessPurposeDetails.class);
			List<BusinessPurposeDetails> businessPurposes = criteria.list();
			
			for (BusinessPurposeDetails details : businessPurposes) {
				webBusinessPurposes.add(details.getWebBusinessPurposeDetails());
			}

		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the Business Purposes." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Business Purposes", ResponseCodes.OK.getCode(), webBusinessPurposes);
	}

	// ========================================================================
	
	@SuppressWarnings("unchecked")
	@Override
	public Response getRegistredAgents() throws BlockbusterException {
		String logTag = "getRegistredAgents(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		ArrayList<WebRegistredAgentDetails> webRegistredAgents = new ArrayList<>();
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(RegisteredAgentDetails.class);
			List<RegisteredAgentDetails> registeredAgents = criteria.list();
			
			for (RegisteredAgentDetails registeredAgentDetails : registeredAgents) {
				webRegistredAgents.add(registeredAgentDetails.getRegistredAgentDetails());
			}
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the Registred Agents Details." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Registred Agents Details", ResponseCodes.OK.getCode(), webRegistredAgents);
	}

	// ========================================================================
	
	@SuppressWarnings("unchecked")
	@Override
	public Response getIncorporations() throws BlockbusterException {
		String logTag = "getIncorporations(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		ArrayList<WebMbcDetails> webMbcs = new ArrayList<>();
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(MbcDetails.class);
			List<MbcDetails> mbcs = criteria.list();
			
			for (MbcDetails mbcDetails : mbcs) {
				webMbcs.add(mbcDetails.getWebMbcDetails());
			}
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the Incorporations." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Incorporations", ResponseCodes.OK.getCode(), webMbcs);
	}

/*	@Override
	public String isValidIp(String ip) throws BlockbusterException {
		// TODO Auto-generated method stub
		return null;
	}*/

	// ========================================================================
	
}