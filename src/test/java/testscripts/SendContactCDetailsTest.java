package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendContactCDetailsTest extends BaseClass{
	@Test
public void sendContactDetailsTest() {
	SoftAssert soft=new SoftAssert(); 
		home.clickGearsTab();
		home.clickSkillraryDemoAppLink();
		web.switchToChildBrowser();
		
		soft.assertTrue(demoapp.getPageHeader().contains("ECommerce"));
		web.scrollTillElement(demoapp.getContactUsLink());
		demoapp.clickContactUs();
		soft.assertTrue(contact.getLogo().isDisplayed());
		Map<String,String> map=excel.getDataFromExcel("Sheet1");
		contact.sendDetails(map.get("Fullname"),map.get("Email"),map.get("Subject"),map.get("Message"));
		soft.assertAll();
		}
	
}

