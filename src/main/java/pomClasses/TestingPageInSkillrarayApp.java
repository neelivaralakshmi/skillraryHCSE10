package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains elements and respective business libraries of skillrary demo app page
 * @author ngane
 *
 */
public class TestingPageInSkillrarayApp {
	
	
	//declaration
		@FindBy (xpath="//h1[@class=\"page-header\"]")
		private WebElement pageHeader;
		@FindBy(id="Python")
		private WebElement pythonImage;
		@FindBy(id="cartArea")
		private WebElement cartArea;
		@FindBy(xpath="//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
		private WebElement  facebookIcon;
		
		//initilisation
		
		 public  TestingPageInSkillrarayApp(WebDriver driver) {
			 
		 
		 PageFactory.initElements(driver,this);
		 }
		 
		 //Utilization
		 /**
		  * this method returns page headertext
		  * @return
		  **/
		 public String getPageHeader() {
			 return pageHeader.getText();
			 
		 }
		 /**
		  * this method returns python image
		  * @return
		  */
		 public WebElement getPythonImage(){
			 return pythonImage;
			 
		 }
		 /**
		  * this method returns cart area element
		  * @return
		  */
		 public WebElement getCartArea() {
			 return cartArea;
			 
		 }
		 public WebElement getFacebookIcon() {
			 return facebookIcon;
			 
		 }
		 /**
		  * this method is used to click on facebook icon
		  */
		 public void clickFacebookIcon() {
             facebookIcon.click();
		 }
}
		 
		 
		 
		 
