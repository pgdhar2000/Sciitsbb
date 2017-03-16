package com.sciits.blockbuster.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sciits.blockbuster.base.BlockbusterDao;
import com.sciits.blockbuster.base.Response;
import com.sciits.blockbuster.base.ResponseCodes;
import com.sciits.blockbuster.dao.CoreDao;
import com.sciits.blockbuster.dao.model.AddressTypeDetails;
import com.sciits.blockbuster.dao.model.AddressTypeTbl;
import com.sciits.blockbuster.dao.model.CountryDetails;
import com.sciits.blockbuster.dao.model.CountryTbl;
import com.sciits.blockbuster.dao.model.RoleTbl;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebAddressTypeDetails;
import com.sciits.blockbuster.web.model.WebCountryDetails;
import com.sciits.blockbuster.web.model.WebRoleDetails;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class CoreDaoImpl extends BlockbusterDao<Serializable, BaseData> implements CoreDao{
	Logger log = Logger.getLogger(CoreDaoImpl.class);



	@Override
	public Response getCountries() throws BlockbusterException {
		String logTag = "getCountries(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		ArrayList<WebCountryDetails> webCountriesDetails = new ArrayList<>();

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(CountryTbl.class);
			List<CountryTbl> countries = criteria.list();

			for (CountryTbl countryTbl : countries) {
				webCountriesDetails.add(countryTbl.getWebCountryDetails());
			}
		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the countries." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Countries", ResponseCodes.OK.getCode(), webCountriesDetails);
	}







	@Override
	public Response getAddressType() throws BlockbusterException {
		String logTag = "getAddressType(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		List<WebAddressTypeDetails> webAddressTypeDetails = new ArrayList<WebAddressTypeDetails>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(AddressTypeTbl.class);
			List<AddressTypeTbl> addressTypeDetails = criteria.list();
			for(AddressTypeTbl addressTypeTbl :addressTypeDetails){
				webAddressTypeDetails.add(addressTypeTbl.getAddressTypeDetails());
			}

		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the countries." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "AddressTypeDetails", ResponseCodes.OK.getCode(), webAddressTypeDetails);
	}



	@Override
	public Response getRoles() throws BlockbusterException {
		String logTag = "getRoles(): ";
		log.info("Entering into : " + logTag);
		Session session = null;
		
		List<WebRoleDetails> webRoleDetails  = new ArrayList<WebRoleDetails>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(RoleTbl.class);
			List<RoleTbl> roleTbls = criteria.list();
			for(RoleTbl roleTbl: roleTbls){
				webRoleDetails.add(roleTbl.getWebRoleDetails());
			}

		} catch (Exception e) {
			String errMessage = logTag + "Exception occurred while getting the roles." + e;
			log.error(errMessage, e);
			throw new BlockbusterException(errMessage, e);
		} finally {
			closeSession(session);
		}
		return new Response(Boolean.TRUE, "Role Details", ResponseCodes.OK.getCode(), webRoleDetails);
	}

}
