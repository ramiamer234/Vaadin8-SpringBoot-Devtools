package com.ninox.ninoxerp.base;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;
import com.ninox.ninoxerp.core.mst.service.CountryService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ItemClick;
import com.vaadin.ui.Tree.ItemClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

@SpringUI
@Title("Ninox ERP")
@Theme("ninoxtheme")
@SuppressWarnings("serial")
public class NinoxLogin extends UI implements ClickListener, ItemClickListener {

	@Autowired
	private CountryService countryService;

	private VerticalLayout vlRoot = new VerticalLayout();
	private VerticalLayout vlModules;
	private CssLayout clContent = new CssLayout();;
	private VerticalLayout vlArgumentLayout = new VerticalLayout();
	private TreeDataProvider tdpDashboard, tdpSettings, tdpAccounts, tdpSales, tdpPurchase, tdpStock, tdpReports,
			tdpPayroll;
	private Image imgLogOut;
	private Tree treeMenu;
	private String companyName = "Faris Departmental Store", loginUserName = "Mahaboob Subahan";

	@WebServlet(urlPatterns = "/*", name = "NinoxLoginServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = NinoxLogin.class, productionMode = false)
	public static class NinoxLoginServlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setLocale(Locale.US);
		vlRoot.setSizeFull();
		vlRoot.setMargin(false);
		vlRoot.setSpacing(false);
		setContent(vlRoot);
		buildLoginView();
		
			verfiyLoginUser();
		
		// buildMainView();
		try {
			test();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buildLoginView() {
		Image imgErpLogo = new Image(null, new ThemeResource("images/ninoxerp-logo.png"));
		Label lblFailureMsg = new Label(
				"<p align=\"left\"><font size=\"2\"color=\"#ff0000\"><b>The username or password you entered is incorrect  </b>"
						+ VaadinIcons.WARNING.getHtml() + "</p>",
				ContentMode.HTML);
		TextField tfUserName = new TextField(" Username/Email");
		tfUserName.setStyleName("logintextfield");
		tfUserName.setIcon(new ThemeResource("images/user.png"));
		tfUserName.setWidth("85%");
		PasswordField pfPassword = new PasswordField(" Password");
		pfPassword.setStyleName("loginpasswdfield");
		pfPassword.setIcon(new ThemeResource("images/password.png"));
		pfPassword.setWidth("85%");
		VerticalLayout vlLoginTextField = new VerticalLayout();
		vlLoginTextField.setMargin(false);
		vlLoginTextField.addComponent(tfUserName);
		vlLoginTextField.addComponent(pfPassword);
		vlLoginTextField.setComponentAlignment(tfUserName, Alignment.BOTTOM_LEFT);
		vlLoginTextField.setComponentAlignment(pfPassword, Alignment.TOP_LEFT);
		Button btnForgotPswd = new Button("Forgot Password?");
		btnForgotPswd.setStyleName("forgotbutton");
		Button btnSignIn = new Button("SIGN IN", event -> buildMainView());
		btnSignIn.setStyleName("signinbutton");
		btnSignIn.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		HorizontalLayout hlSignInBtn = new HorizontalLayout();
		hlSignInBtn.setMargin(false);
		hlSignInBtn.addComponent(btnForgotPswd);
		hlSignInBtn.addComponent(btnSignIn);
		hlSignInBtn.setExpandRatio(btnForgotPswd, 1);
		hlSignInBtn.setWidth("85%");
		FormLayout flLogin = new FormLayout();
		flLogin.setSpacing(true);
		flLogin.setMargin(true);
		flLogin.addComponent(imgErpLogo);
		flLogin.addComponent(lblFailureMsg);
		flLogin.addComponent(vlLoginTextField);
		flLogin.addComponent(hlSignInBtn);
		flLogin.setComponentAlignment(vlLoginTextField, Alignment.MIDDLE_LEFT);
		flLogin.setComponentAlignment(lblFailureMsg, Alignment.MIDDLE_LEFT);
		flLogin.setComponentAlignment(imgErpLogo, Alignment.MIDDLE_LEFT);
		flLogin.setComponentAlignment(hlSignInBtn, Alignment.MIDDLE_CENTER);
		VerticalLayout vlLoginLeftPanel = new VerticalLayout();
		vlLoginLeftPanel.setStyleName("loginleftpanel");
		vlLoginLeftPanel.setWidth("130%");
		vlLoginLeftPanel.setHeight("90%");
		vlLoginLeftPanel.addComponent(flLogin);
		vlLoginLeftPanel.setComponentAlignment(flLogin, Alignment.MIDDLE_CENTER);
		Image imgNinoxLogo = new Image(null, new ThemeResource("images/ninox-logo.png"));
		Label lblWelcome = new Label(
				"<p align=\"middle\"><font size=\"6\"color=\"#ffffff\">Welcome!</p><p align=\"middle\"><font size=\"2\"color=\"#ffffff\">When you don't create things, you become defined by your tastes rather than ability. your tastes only narrow & exclude people. so create.</p>",
				ContentMode.HTML);
		lblWelcome.setStyleName("linespace");
		lblWelcome.setWidth("85%");
		Button btnAboutUs = new Button("About Us");
		btnAboutUs.setWidth("200px");
		btnAboutUs.setStyleName("aboutusbutton");
		VerticalLayout vlAboutusButton = new VerticalLayout();
		vlAboutusButton.addComponent(btnAboutUs);
		vlAboutusButton.setComponentAlignment(btnAboutUs, Alignment.BOTTOM_CENTER);
		VerticalLayout vlLoginRightPanel = new VerticalLayout();
		vlLoginRightPanel.setSpacing(false);
		vlLoginRightPanel.setMargin(false);
		vlLoginRightPanel.setStyleName("loginrightpanel");
		vlLoginRightPanel.setWidth("70%");
		vlLoginRightPanel.setHeight("100%");
		vlLoginRightPanel.addComponent(imgNinoxLogo);
		vlLoginRightPanel.addComponent(lblWelcome);
		vlLoginRightPanel.addComponent(vlAboutusButton);
		vlLoginRightPanel.setComponentAlignment(imgNinoxLogo, Alignment.MIDDLE_CENTER);
		vlLoginRightPanel.setComponentAlignment(lblWelcome, Alignment.MIDDLE_CENTER);
		vlLoginRightPanel.setComponentAlignment(vlAboutusButton, Alignment.BOTTOM_CENTER);
		HorizontalLayout hlLoginForm = new HorizontalLayout();
		hlLoginForm.setStyleName("loginformbackround");
		hlLoginForm.setWidth("90%");
		hlLoginForm.setHeight("90%");
		hlLoginForm.setSpacing(false);
		hlLoginForm.addComponent(vlLoginLeftPanel);
		hlLoginForm.addComponent(vlLoginRightPanel);
		hlLoginForm.setComponentAlignment(vlLoginLeftPanel, Alignment.MIDDLE_LEFT);
		hlLoginForm.setComponentAlignment(vlLoginRightPanel, Alignment.MIDDLE_RIGHT);
		VerticalLayout vlLoginBackground = new VerticalLayout();
		vlLoginBackground.setSizeFull();
		vlLoginBackground.setStyleName("backgroundimage");
		vlLoginBackground.addComponent(hlLoginForm);
		vlLoginBackground.setComponentAlignment(hlLoginForm, Alignment.MIDDLE_CENTER);
		vlLoginBackground.setSpacing(false);
		vlLoginBackground.setMargin(false);
		vlRoot.addComponent(vlLoginBackground);
	}

	private void verfiyLoginUser() {
		try {
			treeMenu = new Tree();
			treeMenu.setSizeFull();
			TreeData<String> treeData = new TreeData<>();

			// Couple of childless root items
			treeData.addItem(null, "User Settings");
			treeData.addItem("User Settings", "Company Settings");

			// Items with hierarchy
			treeData.addItem(null, "Announcement");
			treeData.addItem("Announcement", "Message");
			treeData.addItem("Announcement", "Email");

			treeData.addItem(null, "Accounts");
			treeData.addItem("Accounts", "Daybook");
			treeData.addItem("Accounts", "Trail Balence");

			tdpDashboard = new TreeDataProvider<>(treeData);
			treeMenu.setDataProvider(tdpDashboard);
			treeMenu.expand("Earth"); // Expand programmatically
			UI.getCurrent().getSession().setAttribute("clContent", vlArgumentLayout);
			clContent.addComponent(vlArgumentLayout);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void buildMainView() {
		vlRoot.removeAllComponents();
		Image imgProductLogo = new Image(null, new ThemeResource("images/ninoxerp-logo.png"));
		imgProductLogo.setWidth("55%");
		imgProductLogo.setHeight("40%");
		HorizontalLayout hlHeaderErpLogo = new HorizontalLayout();
		hlHeaderErpLogo.setStyleName("hlheadererplogo");
		hlHeaderErpLogo.setWidth("280px");
		hlHeaderErpLogo.setHeight("100%");
		hlHeaderErpLogo.addComponent(imgProductLogo);
		hlHeaderErpLogo.setComponentAlignment(imgProductLogo, Alignment.MIDDLE_CENTER);
		Label lblCompanyName = new Label(companyName);
		lblCompanyName.setStyleName("heading3");
		Label lblLoginUserName = new Label(loginUserName);
		lblLoginUserName.setStyleName("heading2");
		HorizontalLayout hlUserPhoto = new HorizontalLayout();
		hlUserPhoto.setStyleName("userphoto");
		hlUserPhoto.setWidth("45px");
		hlUserPhoto.setHeight("45px");
		imgLogOut = new Image(null, new ThemeResource("icons/log-out.png"));
		imgLogOut.setWidth("30px");
		imgLogOut.setHeight("30px");
		imgLogOut.setDescription("Sign out");
		imgLogOut.setStyleName("signout");
		imgLogOut.addClickListener(this);
		HorizontalLayout hlHeaderCompany = new HorizontalLayout();
		hlHeaderCompany.setStyleName("hlheadercompany");
		hlHeaderCompany.setHeight("100%");
		hlHeaderCompany.addComponent(lblLoginUserName);
		hlHeaderCompany.addComponent(hlUserPhoto);
		hlHeaderCompany.addComponent(imgLogOut);
		hlHeaderCompany.setComponentAlignment(imgLogOut, Alignment.MIDDLE_RIGHT);
		hlHeaderCompany.setComponentAlignment(lblLoginUserName, Alignment.MIDDLE_RIGHT);
		hlHeaderCompany.setComponentAlignment(hlUserPhoto, Alignment.MIDDLE_RIGHT);
		HorizontalLayout hlHeaderDetail = new HorizontalLayout();
		hlHeaderDetail.setStyleName("hlheader");
		hlHeaderDetail.setWidth("100%");
		hlHeaderDetail.setHeight("67px");
		hlHeaderDetail.addComponent(hlHeaderErpLogo);
		hlHeaderDetail.addComponent(lblCompanyName);
		hlHeaderDetail.setExpandRatio(lblCompanyName, 1);
		hlHeaderDetail.addComponent(hlHeaderCompany);
		hlHeaderDetail.setComponentAlignment(lblCompanyName, Alignment.MIDDLE_LEFT);
		VerticalLayout hlSpinner = new VerticalLayout();
		hlSpinner.setMargin(false);
		hlSpinner.setStyleName("hlspinner");
		hlSpinner.setWidth("100%");
		hlSpinner.setHeight("5px");
		Label lblBreadscrum = new Label("Settings/My Account");
		lblBreadscrum.setStyleName("heading1");
		HorizontalLayout hlBreadscrum = new HorizontalLayout();
		hlBreadscrum.setStyleName("hlbreadscrum");
		hlBreadscrum.setWidth("100%");
		hlBreadscrum.setHeight("32px");
		hlBreadscrum.addComponent(lblBreadscrum);
		hlBreadscrum.setComponentAlignment(lblBreadscrum, Alignment.MIDDLE_LEFT);
		VerticalLayout hlHeader = new VerticalLayout();
		hlHeader.addComponent(hlHeaderDetail);
		hlHeader.addComponent(hlSpinner);
		hlHeader.addComponent(hlBreadscrum);
		hlHeader.setSpacing(false);
		hlHeader.setMargin(false);
		vlModules = new VerticalLayout();
		vlModules.setStyleName("vlmodule");
		vlModules.setWidth("70px");
		vlModules.setHeight("100%");
		loadModules(vlModules);
		vlModules.setSpacing(false);
		vlModules.setMargin(false);
		verfiyLoginUser();
		//
		treeMenu.setStyleName("treemenu");
		VerticalLayout vlMenu = new VerticalLayout();
		vlMenu.setStyleName("vlmenu");
		vlMenu.setWidth("210px");
		vlMenu.setHeight("100%");
		vlMenu.addComponent(treeMenu);
		vlMenu.setMargin(false);
		VerticalLayout vlContent = new VerticalLayout();
		vlContent.setStyleName("vlcontent");
		vlContent.addComponent(clContent);
		vlContent.setExpandRatio(clContent, 1);
		vlContent.setSpacing(false);
		vlContent.setMargin(false);
		HorizontalLayout hlBody = new HorizontalLayout();
		hlBody.setStyleName("hlmenucontent");
		hlBody.setSizeFull();
		hlBody.addComponent(vlModules);
		hlBody.addComponent(vlMenu);
		hlBody.addComponent(vlContent);
		hlBody.setExpandRatio(vlContent, 1);
		hlBody.setSpacing(false);
		hlBody.setMargin(false);
		Label lblLicense = new Label(
				"Powered by Ninox Software Solutions | This Software is lincenced to " + companyName);
		lblLicense.setStyleName("heading1");
		HorizontalLayout hlFooter = new HorizontalLayout();
		hlFooter.setStyleName("hlfooter");
		hlFooter.setWidth("100%");
		hlFooter.setHeight("25px");
		hlFooter.addComponent(lblLicense);
		hlFooter.setComponentAlignment(lblLicense, Alignment.MIDDLE_CENTER);

		// Load all components to Root
		vlRoot.addComponent(hlHeader);
		vlRoot.addComponent(hlBody);
		vlRoot.setExpandRatio(hlBody, 1);
		vlRoot.addComponent(hlFooter);
		vlRoot.setComponentAlignment(hlFooter, Alignment.BOTTOM_CENTER);
	}

	private VerticalLayout loadModules(VerticalLayout vlModule) {
		LinkedHashMap<Label, Image> hmModule = new LinkedHashMap<>();
		hmModule.put(new Label("Dashboard"), new Image(null, new ThemeResource("icons/dashboard.png")));
		hmModule.put(new Label("Settings"), new Image(null, new ThemeResource("icons/settings.png")));
		hmModule.put(new Label("Purchase"), new Image(null, new ThemeResource("icons/purchase.png")));
		hmModule.put(new Label("Sales"), new Image(null, new ThemeResource("icons/sales.png")));
		hmModule.put(new Label("Stock"), new Image(null, new ThemeResource("icons/stock.png")));
		hmModule.put(new Label("Accounts"), new Image(null, new ThemeResource("icons/folder.png")));
		hmModule.put(new Label("Payroll"), new Image(null, new ThemeResource("icons/salary.png")));
		hmModule.put(new Label("Reports"), new Image(null, new ThemeResource("icons/reports.png")));
		List<String> listModuleNames = Arrays.asList("Dashboard", "Settings", "Purchase", "Sales", "Stock", "Accounts",
				"Payroll", "Reports");
		hmModule.entrySet().forEach(layout -> {
			VerticalLayout vlLocalModule = new VerticalLayout();
			layout.getKey().setStyleName("modulenames");
			layout.getValue().setWidth("40px");
			layout.getValue().setHeight("40px");
			vlLocalModule.setId(layout.getKey().getValue());
			vlLocalModule.addComponent(layout.getValue());
			vlLocalModule.addComponent(layout.getKey());
			vlLocalModule.setComponentAlignment(layout.getValue(), Alignment.TOP_CENTER);
			vlLocalModule.setComponentAlignment(layout.getKey(), Alignment.TOP_CENTER);
			vlLocalModule.setStyleName("module");
			vlLocalModule.setSizeFull();
			vlLocalModule.setSpacing(true);
			vlLocalModule.setMargin(false);
			addLayoutClickListener(vlLocalModule, listModuleNames);
			vlModule.addComponent(vlLocalModule);
		});
		return vlModule;
	}

	@Override
	public void click(ClickEvent event) {
		if (imgLogOut == event.getComponent()) {
			vlRoot.removeAllComponents();
			buildLoginView();
		}
	}

	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<CountryDM> lists = countryService.getCountryList(null, null, null, null);
		System.out.println("Inside test function");
		for (CountryDM c : lists) {
			System.out.println("**** CountryDM :" + c.getCountryName().toString());
		}
		Class<?> c = null;
		Object b = null;
		c = Class.forName("com.ninox.ninoxerp.view.mst.Country");
		b = c.newInstance();
		c.isInstance(b);// invoke(b);
		// lists.forEach(System.out::println);
	}

	@Override
	public void itemClick(ItemClick event) {
		// TODO Auto-generated method stub
	}

	private void addLayoutClickListener(VerticalLayout vlModule, List<String> listModuleNames) {
		vlModule.addLayoutClickListener(e -> {
			vlModules.getComponentIterator().forEachRemaining(action -> {
				action.setStyleName("module");
			});
			if (listModuleNames.contains(e.getComponent().getId())) {
				e.getComponent().setStyleName("moduleclicked");
				System.out.println("Hi I am " + e.getComponent().getId() + "...!");
			}
		});
	}

}
