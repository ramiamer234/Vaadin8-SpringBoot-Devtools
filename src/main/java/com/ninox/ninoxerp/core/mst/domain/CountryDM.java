package com.ninox.ninoxerp.core.mst.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ninox.ninoxerp.core.util.DateUtils;

@Entity
@Table(name = "m_country")
public class CountryDM implements Serializable {

	private static final long serialVersionUID = 840183232179879661L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private Long countryId;
	@Column(name = "country_name")
	private String countryName;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "ISD_CODE")
	private String isdCode;
	@Column(name = "gmt_offset")
	private String gmtOffset;
	@Column(name = "country_status")
	private String countyStatus;
	@Column(name = "last_updated_date")
	private Date lastUpdatedDt;
	@Column(name = "last_updated_by")
	private String lastUpdateBy;

	public CountryDM() {
	}

	public CountryDM(Long countryid, String countryname, String countrycode) {
		this.countryId = countryid;
		this.countryName = countryname;
		this.countryCode = countrycode;
	}

	public CountryDM(Long countryid, String countryname, String countrycode, String gmtOffset) {
		this.countryId = countryid;
		this.countryName = countryname;
		this.countryCode = countrycode;
		this.gmtOffset = gmtOffset;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getGmtOffset() {
		return gmtOffset;
	}

	public void setGmtOffset(String gmtOffset) {
		this.gmtOffset = gmtOffset;
	}

	public String getCountyStatus() {
		return countyStatus;
	}

	public void setCountyStatus(String countyStatus) {
		this.countyStatus = countyStatus;
	}

	public String getLastUpdatedDt() {
		if (lastUpdatedDt != null) {
			return DateUtils.datetostringtime(lastUpdatedDt);
		} else {
			return "";
		}
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	@Override
	public String toString() {
		return "CountryDM [countryId=" + countryId + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", isdCode=" + isdCode + ", gmtOffset=" + gmtOffset + ", countyStatus=" + countyStatus
				+ ", lastUpdatedDt=" + lastUpdatedDt + ", lastUpdateBy=" + lastUpdateBy + "]";
	}

}
