/**
 * File Name	:	CurrencyDM.java
 * Description	:	entity class for m_currency table
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
package com.ninox.ninoxerp.core.mst.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ninox.ninoxerp.core.util.DateUtils;

@Entity
@Table(name = "m_currency")
public class CurrencyDM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ccy_id")
	private Long ccyid;
	@Column(name = "ccy_name")
	private String ccyname;
	@Column(name = "ccy_code")
	private String ccycode;
	@Column(name = "ccy_symbol")
	private String ccysymbol;
	@Column(name = "ccy_status")
	private String ccystatus;
	@Column(name = "last_updated_date")
	private Date lastupdateddt;
	@Column(name = "last_updated_by")
	private String lastupdatedby;
	
	public CurrencyDM() {
	}
	
	public CurrencyDM(Long currencyId, String currencyCode, String currencyName) {
		this.ccyid = currencyId;
		this.ccycode = currencyCode;
		this.ccyname = currencyName;
	}
	
	public Long getCcyid() {
		return ccyid;
	}
	
	public void setCcyid(Long ccyid) {
		this.ccyid = ccyid;
	}
	
	public String getCcyname() {
		return ccyname;
	}
	
	public void setCcyname(String ccyname) {
		this.ccyname = ccyname;
	}
	
	public String getCcycode() {
		return ccycode;
	}
	
	public void setCcycode(String ccycode) {
		this.ccycode = ccycode;
	}
	
	public String getCcysymbol() {
		return ccysymbol;
	}
	
	public void setCcysymbol(String ccysymbol) {
		this.ccysymbol = ccysymbol;
	}
	
	public String getCcystatus() {
		return ccystatus;
	}
	
	public void setCcystatus(String ccystatus) {
		this.ccystatus = ccystatus;
	}
	
	public String getLastupdateddt() {
		if (lastupdateddt != null) {
			return DateUtils.datetostringtime(lastupdateddt);
		} else {
			return "";
		}
	}
	
	public void setLastupdateddt(Date lastupdateddt) {
		this.lastupdateddt = lastupdateddt;
	}
	
	public String getLastupdatedby() {
		return lastupdatedby;
	}
	
	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}
}
