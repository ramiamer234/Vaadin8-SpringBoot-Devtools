/**
 * File Name	:	CountryServiceImpl.java
 * Description	:	To Handle the Implementation of Country Service Web page requests.
 * Author		:	Mahaboob Subahan
 * Date			:	10-Sep-2018
 *
 * Copyright (C) 2018 Ninox Software Solutions. * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Ninox Software Solutions.
 * 
 */

package com.ninox.ninoxerp.core.mst.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ninox.ninoxerp.core.mst.dao.CountryDAO;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;
import com.ninox.ninoxerp.core.mst.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO countrydao;
	
	private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	/**
	 * To return data from CountryDM based on user's input
	 * 
	 * @param Long countryId, String countryCode, String countryName, String status
	 */
	@Transactional
	@Cacheable(value = "country")
	public List<CountryDM> getCountryList(Long countryId, String countryCode, String countryName, String status) {
		logger.info("Inside getCountryList >  " + countryId + "," + countryCode + ", " + countryName + "," + status);
		return countrydao.getCountryList(countryId, countryCode, countryName, status);
	}
	
	/**
	 * Method for return ISD Code of CountryDM based on user's input i.e countryId
	 * 
	 * @param Long countryId
	 * @return String isdCode
	 */
	@Transactional
	@Cacheable(value = "country")
	public String getISDCodebyCountryId(Long countryId) {
		logger.info("Inside getISDCodebyCountryId " + countryId);
		return countrydao.getISDCodebyCountryId(countryId);
	}
	
}
