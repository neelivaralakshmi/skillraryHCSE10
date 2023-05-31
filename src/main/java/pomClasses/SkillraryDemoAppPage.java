package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericLibraries.WebDriverUtility;

/**
 * This class contains elements and respective business libraries of skillrary demo app page
 * @author ngane
 *
 */
public class SkillraryDemoAppPage {
//declaration
	@FindBy (xpath="//div[@class='navbar-header']")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement coursetab;
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement SeleniumTrainingLink;
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement ContacUsLink;
	
	
	//Initialization
	public  SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		} 
	//Utilization
	
	/**
	 * This method return page header text
	 * @return
	 */
	
	public  String getPageHeader() {
		return pageHeader.getText();
		}
	
	/**
	 * this method is used to mouse hover to course tab
	 * @param web
	 */
	public void mouseHoverTOCourse(WebDriverUtility web) {
		web.mouseHover(coursetab);
	}
	/**
	 * this method is used to click on selenium training
	 */
	public void  clickSeleniumTraining() {
		SeleniumTrainingLink.click();
		
	}
	/**
	 * this method is used to select category
	 * @param web
	 * @param index 
	 */
	public void selectCategory1(WebDriverUtility web,int index) {
		web.dropdown(categoryDD,index);
	}
	/**
	 * this method returns contact us link
	 * @return
	 */
	public WebElement getContactUsLink() {
		return ContacUsLink;
		}
	/**
	 * this method is used to click on contact us link
	 */
	public void clickContactUs() {
		ContacUsLink.click();
		
	}

}
