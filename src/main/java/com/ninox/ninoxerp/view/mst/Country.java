package com.ninox.ninoxerp.view.mst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ninox.ninoxerp.core.mst.domain.CountryDM;
import com.ninox.ninoxerp.core.mst.service.CountryService;
import com.ninox.ninoxerp.core.util.BaseUI;

public class Country extends BaseUI {
	
	@Autowired
	private CountryService countryService;
	
	public Country() {
		buildView();
	}
	
	private void buildView() {
		loadSearchResult();
	}
	
	private void loadSearchResult() {
		try {
		grdMasterSearchResult.getDataProvider().refreshAll();
		List<CountryDM> lists = countryService.getCountryList(null, null, null, null);
		grdMasterSearchResult.setItems(lists);
		grdMasterSearchResult.setColumns("countryId", "countryName", "countryCode", "isdCode", "gmtOffset", "countyStatus", "lastUpdatedDt", "lastUpdateBy");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
