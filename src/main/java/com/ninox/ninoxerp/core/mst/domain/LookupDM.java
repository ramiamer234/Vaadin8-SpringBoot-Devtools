package com.ninox.ninoxerp.core.mst.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_lookup")
public class LookupDM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lookup_id")
	private Long lookupid;
	@Column(name = "lookup_code")
	private String lookupcode;
	@Column(name = "lookup_desc")
	private String lookupdesc;
	@Column(name = "lookup_status")
	private String lookupstatus;
	@Column(name = "last_updated_date")
	private Date lastupdateddt;
	@Column(name = "last_updated_by")
	private String lastupdatedby;
	
	public LookupDM() {
	}
	
	public LookupDM(Long lookupid, String lookupcode) {
		this.lookupid = lookupid;
		this.lookupcode = lookupcode;
	}

	public LookupDM(Long lookupid, String lookupcode, String lookupdesc) {
		this.lookupid = lookupid;
		this.lookupcode = lookupcode;
		this.lookupdesc = lookupdesc;
	}
	
	public Long getLookupid() {
		return lookupid;
	}
	
	public void setLookupid(Long lookupid) {
		this.lookupid = lookupid;
	}
	
	public String getLookupcode() {
		return lookupcode;
	}
	
	public void setLookupcode(String lookupcode) {
		this.lookupcode = lookupcode;
	}
	
	public String getLookupdesc() {
		return lookupdesc;
	}
	
	public void setLookupdesc(String lookupdesc) {
		this.lookupdesc = lookupdesc;
	}
	
	public String getLookupstatus() {
		return lookupstatus;
	}
	
	public void setLookupstatus(String lookupstatus) {
		this.lookupstatus = lookupstatus;
	}
	
	public Date getLastupdateddt() {
		return lastupdateddt;
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
