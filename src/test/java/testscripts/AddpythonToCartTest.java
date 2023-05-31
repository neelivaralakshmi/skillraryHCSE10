package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddpythonToCartTest extends BaseClass {
	@Test
	public void addToCartTest() {
	SoftAssert soft = new SoftAssert();
	
	home.clickGearsTab();
	home.clickSkillraryDemoAppLink();
	web.switchToChildBrowser();
	
	soft.assertTrue(demoapp.getPageHeader().contains("ECommerce"));
	demoapp.selectCategory1(web,1);
	
	soft.assertEquals(testing.getPageHeader(), "Testing");
	
	web.scrollTillElement(testing.getPythonImage());
	web.dragAndDropElement(testing.getPythonImage(), testing.getCartArea());
	
	web.scrollTillElement(testing.getFacebookIcon()); 
	testing.clickFacebookIcon();
	
	soft.assertAll();
	
}
}
