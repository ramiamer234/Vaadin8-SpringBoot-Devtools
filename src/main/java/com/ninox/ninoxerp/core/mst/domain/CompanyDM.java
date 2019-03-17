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
@Table(name = "m_company")
public class CompanyDM {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "COMPANY_ID")
		private Long companyid;
		@Column(name = "COMPANY_NAME")
		private String companyname;
		@Column(name = "COMPANY_CODE")
		private String companycode;
		@Column(name = "COMPANY_ADDRESS")
		private String companyaddress;
		@Column(name = "POST_CODE")
		private String postcode;
		@Column(name = "COUNTRY_ID")
		private Long countryid;
		@Transient
		private String countryName;
		@Column(name = "STATE_ID")
		private Long stateid;
		@Transient
		private String stateName;
		@Column(name = "CITY_ID")
		private Long cityid;
		@Transient
		private String cityName;
		@Column(name = "PHONE")
		private String phone;
		@Column(name = "EMAIL_ID")
		private String emailid;
		@Column(name = "REG_NO")
		private String regno;
		@Column(name = "TAN_NO")
		private String tanno;
		@Column(name = "ST_NO")
		private String stno;
		@Column(name = "FAX_NO")
		private String faxno;
		@Column(name = "WEBSITE")
		private String website;
		@Column(name = "SERVICETAX_NO")
		private String servicetaxno;
		@Column(name = "PAN_NO")
		private String panno;
		@Column(name = "EMPLOYER_NO")
		private String employerno;
		@Column(name = "ESI_NO")
		private String esino;
		@Column(name = "PF_NO")
		private String pfno;
		@Column(name = "CST_NO")
		private String cstno;
		@Column(name = "ECC_NO")
		private String eccno;
		@Column(name = "TIN_NO")
		private String tinno;
		@Column(name = "COMPANY_LOGO")
		private byte[] companylogo;
		@Column(name = "COMPANY_STATUS")
		private String companystatus;
		@Column(name = "BASE_CCY_ID")
		private Long currencyId;
		@Column(name = "ABOUT_US")
		private String aboutus;
		@Column(name = "COMPANY_HISTORY")
		private String companyhistory;
		@Column(name = "CUSTCARE_PHNO")
		private String customercarephoneno;
		@Column(name = "CUSTCARE_EMAIL")
		private String customercareemailid;
		@Transient
		private String currencyName;

		public String getCurrencyName() {
			return currencyName;
		}

		public void setCurrencyName(String currencyName) {
			this.currencyName = currencyName;
		}

		@Column(name = "LAST_UPDATED_DT")
		private Date lastupdateddt;
		@Column(name = "LAST_UPDATED_BY")
		private String lastupdatedby;

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getStateName() {
			return stateName;
		}

		public void setStateName(String stateName) {
			this.stateName = stateName;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public Long getCcyid() {
			return currencyId;
		}

		public void setCcyid(Long currencyId) {
			this.currencyId = currencyId;
		}

		public Long getCompanyid() {
			return companyid;
		}

		public void setCompanyid(Long companyid) {
			this.companyid = companyid;
		}

		public String getCompanyname() {
			return companyname;
		}

		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}

		public String getCompanycode() {
			return companycode;
		}

		public void setCompanycode(String companycode) {
			this.companycode = companycode;
		}

		public String getCompanyaddress() {
			return companyaddress;
		}

		public void setCompanyaddress(String companyaddress) {
			this.companyaddress = companyaddress;
		}

		public String getPostcode() {
			return postcode;
		}

		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}

		public Long getCityid() {
			return cityid;
		}

		public void setCityid(Long cityid) {
			this.cityid = cityid;
		}

		public Long getStateid() {
			return stateid;
		}

		public void setStateid(Long stateid) {
			this.stateid = stateid;
		}

		public Long getCountryid() {
			return countryid;
		}

		public void setCountryid(Long countryid) {
			this.countryid = countryid;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getRegno() {
			return regno;
		}

		public void setRegno(String regno) {
			this.regno = regno;
		}

		public String getTanno() {
			return tanno;
		}

		public void setTanno(String tanno) {
			this.tanno = tanno;
		}

		public String getStno() {
			return stno;
		}

		public void setStno(String stno) {
			this.stno = stno;
		}

		public String getFaxno() {
			return faxno;
		}

		public void setFaxno(String faxno) {
			this.faxno = faxno;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getServicetaxno() {
			return servicetaxno;
		}

		public void setServicetaxno(String servicetaxno) {
			this.servicetaxno = servicetaxno;
		}

		public String getPanno() {
			return panno;
		}

		public void setPanno(String panno) {
			this.panno = panno;
		}

		public String getEmployerno() {
			return employerno;
		}

		public void setEmployerno(String employerno) {
			this.employerno = employerno;
		}

		public String getEsino() {
			return esino;
		}

		public void setEsino(String esino) {
			this.esino = esino;
		}

		public String getPfno() {
			return pfno;
		}

		public void setPfno(String pfno) {
			this.pfno = pfno;
		}

		public String getCstno() {
			return cstno;
		}

		public void setCstno(String cstno) {
			this.cstno = cstno;
		}

		public String getEccno() {
			return eccno;
		}

		public void setEccno(String eccno) {
			this.eccno = eccno;
		}

		public String getTinno() {
			return tinno;
		}

		public void setTinno(String tinno) {
			this.tinno = tinno;
		}

		public byte[] getCompanylogo() {
			return companylogo;
		}

		public void setCompanylogo(byte[] companylogo) {
			this.companylogo = companylogo;
		}

		public String getCompanystatus() {
			return companystatus;
		}

		public void setCompanystatus(String companystatus) {
			this.companystatus = companystatus;
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

		public String getaboutus() {
			return aboutus;
		}

		public void setaboutus(String aboutus) {
			this.aboutus = aboutus;
		}

		public String getcompanyhistory() {
			return companyhistory;
		}

		public void setcompanyhistory(String companyhistory) {
			this.companyhistory = companyhistory;
		}

		public String getcustomercarephoneno() {
			return customercarephoneno;
		}

		public void setcustomercarephoneno(String customercarephoneno) {
			this.customercarephoneno = customercarephoneno;
		}

		public String getcustomercareemailid() {
			return customercarephoneno;
		}

		public void setcustomercareemailid(String customercareemailid) {
			this.customercareemailid = customercareemailid;
		}




}
