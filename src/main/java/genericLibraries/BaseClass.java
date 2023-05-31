package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomClasses.ContactUsPage;
import pomClasses.SeleniumTrainingPage;
import pomClasses.SkillraryDemoAppPage;
import pomClasses.SkillraryHomepage;
import pomClasses.TestingPageInSkillrarayApp;

public class BaseClass {
	//utility classes
	 protected PropertiesUtility property;
	 protected ExcelUtility excel;
	 protected JAvaUtility jutil;
	 protected WebDriverUtility web;
	 protected WebDriver driver;
	 //pom classes
	 protected SkillraryHomepage home;
	 protected SkillraryDemoAppPage demoapp;
	 protected SeleniumTrainingPage selenium;
	 protected TestingPageInSkillrarayApp testing;
	 protected ContactUsPage contact;
	 
	 //@BeforeSuite
	//@BeforeTest
	 
	@BeforeClass
	public void classConfig() {
		property =new PropertiesUtility();
		 excel=new  ExcelUtility();
		 jutil =new JAvaUtility();
		 web=new WebDriverUtility();
		 
		 property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		 excel.excelInit(IConstantPath.EXCEL_PATH);
		 
	}
	@BeforeMethod
	public void methodConfig() {
		driver = web.LaunchBrowser(property.readDataFromProperty("browser"));
		web.maximizeBrowser();
		web.navigateToApp(property.readDataFromProperty("url"));
		web.waitUntilElementFound(Long.parseLong(property.readDataFromProperty("time")));
		
		home = new SkillraryHomepage(driver);
		demoapp =new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPageInSkillrarayApp(driver);
		contact=new ContactUsPage(driver);
		
		
	}
	@AfterMethod
	public void methodTearDown() {
		web.quitallWindows();
	}
	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}
