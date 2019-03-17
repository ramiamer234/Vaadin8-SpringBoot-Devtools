package com.ninox.ninoxerp.core.mst.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ninox.ninoxerp.core.util.DateUtils;

@Entity
@Table(name = "m_state")
public class StateDM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private Long stateId;
	@Column(name = "state_name")
	private String stateName;
	@Column(name = "state_code")
	private String stateCode;
	@Column(name = "country_id")
	private Long countryId;
	@Column(name = "state_status")
	private String stateStatus;
	@Column(name = "last_updated_date")
	private Date lastUpdatedDt;
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	@Transient
	private String countryName;
	
	public StateDM() {
	}
	
	public StateDM(Long stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getStateId() {
		if (stateId != null) {
			return stateId.toString();
		} else {
			return "";
		}
	}
	
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	
	public String getStateName() {
		return stateName;
	}
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	public Long getCountryId() {
		return countryId;
	}
	
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	public String getStateStatus() {
		return stateStatus;
	}
	
	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}
	
	public String getLastUpdatedDt() {
		return DateUtils.datetostringtime(lastUpdatedDt);
	}
	
	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}
	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
}
