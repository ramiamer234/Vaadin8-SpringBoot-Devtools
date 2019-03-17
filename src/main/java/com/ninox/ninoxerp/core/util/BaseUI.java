package com.ninox.ninoxerp.core.util;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
public abstract class BaseUI {

	// Root container for clContent.
	public VerticalLayout vlContentPageRootContainter = (VerticalLayout) UI.getCurrent().getSession().getAttribute("clContent");
	
	// Container for search page.
	public VerticalLayout vlSearchPageContainter = new VerticalLayout();
	
	// Container for add/edit page.
	public VerticalLayout vlAddEditPageContainter = new VerticalLayout();
	
	public Grid<CountryDM> grdMasterSearchResult = new Grid<>();
	public BaseUI(){
		try {
		grdMasterSearchResult.setWidth("100%");
		grdMasterSearchResult.setHeight("100%");
		grdMasterSearchResult.setSelectionMode(Grid.SelectionMode.SINGLE);
		grdMasterSearchResult.setColumnReorderingAllowed(true);
		vlSearchPageContainter.setMargin(false);
		vlSearchPageContainter.addComponent(grdMasterSearchResult);
		vlSearchPageContainter.setExpandRatio(grdMasterSearchResult, 1);
		vlContentPageRootContainter.setMargin(false);
		vlContentPageRootContainter.addComponent(vlSearchPageContainter);
		vlContentPageRootContainter.setExpandRatio(vlSearchPageContainter, 1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
