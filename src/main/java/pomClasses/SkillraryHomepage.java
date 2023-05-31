package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * this class contains elements & respective business libraries of skillraray homepage
 * @author ngane
 */
public class SkillraryHomepage {
//declaration

 @FindBy(xpath="//img[@alt='SkillRary']")
private WebElement logo;
@FindBy (xpath="//ul[contains(@class,'home_menu')]li[1] ")
private WebElement languageIcon;
@FindBy(xpath="//ul[contains(@class,'home_menu')]/descendant::a[text()='English']")
private WebElement english;
@FindBy(xpath="//a[text()=' GEARS ']")
private WebElement gearstab;
@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
private WebElement skillraryDemoAppLink;
//Initialisation

public SkillraryHomepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

/**
 * this method returns logo
 * @return
 */
public WebElement getlogo() {
	return logo;
}
/**
 * this method is used to select English as default language
 */
public void chooseEnglish() {
	languageIcon.click();
	english.click();
	}
/**
 * this method is used to click on gears tab
 */
public void clickGearsTab() {
	gearstab.click();
}
/**
 * this method is used to click on skillrary demo app 
 */
public void clickSkillraryDemoAppLink() {
	skillraryDemoAppLink.click();
 } 
}
