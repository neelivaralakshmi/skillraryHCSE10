package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
//declaration
	@FindBy (xpath="//img[contains(@src,'contactus')]")
	private WebElement  logo;
	@FindBy(name="name")
	private WebElement fullName;
	@FindBy(name="sender")
	private WebElement emailTF;
	@FindBy(name="subject")
	private WebElement subjectTF;
	@FindBy(name="message")
	private WebElement messageBox;
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//Initilisation
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilisation
	/**
	 * this method returns logo
	 * @return
	 */
	 public WebElement getLogo(){
		 return logo;
		 
	 }
	  
	 /**
	 * this method is used to send th contact details
	 * @param name
	 * @param email
	 * @param subject
	 * @param message
	 * @param send us mail
	 */
	 public void sendDetails(String name,String email,String subject,String message) {
		 fullName.sendKeys("name");
		 emailTF.sendKeys("email");
		 subjectTF.sendKeys("subject");
		 messageBox .sendKeys("message");
		sendUsMailButton.click();
	 }

}
		