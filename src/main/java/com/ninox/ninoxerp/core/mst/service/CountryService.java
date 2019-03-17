/**
 * File Name	:	CountryService.java
 * Description	:	To Handle Country Service Interface Web page requests.
 * Author		:	Mahaboob Subahan J
 * Date			:	Sep 10, 2018
 * 
 *
 *  Copyright (C) 2018 Ninox Software Solutions * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of  Ninox Software Solutions.
 *
 */

package com.ninox.ninoxerp.core.mst.service;

import java.util.List;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;

public interface CountryService {
	
	/**
	 * Method for return list from CountryDM, based on user's parameter
	 * 
	 * @param Long countryid, String countryCode, String countryName, String status
	 */
	public List<CountryDM> getCountryList(Long countryId, String countryCode, String countryName, String status);
	
	/**
	 * Method for return ISD Code of CountryDM based on user's input i.e countryId
	 * 
	 * @param Long countryId
	 */
	public String getISDCodebyCountryId(Long countryId);
}
