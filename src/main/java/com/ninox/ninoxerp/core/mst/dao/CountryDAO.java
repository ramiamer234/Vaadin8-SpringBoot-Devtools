/**
 * File Name	:	CountryDAO.java
 * Description	:	To Handle Country Data Access Object Web page requests.
 * Author		:	Mahaboob Subahan
 * Date			:	10-Sep-2018
 * 
 *  Copyright (C) 2018 Ninox Software Solutions * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of  Ninox Software Solutions.
 *
 */

package com.ninox.ninoxerp.core.mst.dao;

import java.util.List;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;

public interface CountryDAO {
	
	/**
	 * Method for return list of CountryDM based on user's input
	 * 
	 * @param Long countryid, String countryCode, String countryName, String status
	 * @return CountryDM List
	 */
	public List<CountryDM> getCountryList(Long countryId, String countryCode, String countryName, String status);
	
	/**
	 * Method for return ISD Code of CountryDM
	 * 
	 * @param Long countryId
	 * @return ISDCode List
	 */
	public String getISDCodebyCountryId(Long countryId);
	
}
