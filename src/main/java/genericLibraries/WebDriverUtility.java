package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;

	public WebDriver LaunchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid  browser data ");
		}
		return driver;
	}

	/**
	 * this method is used to maximize the browser
	 */
	public void maximizeBrowser() {

		driver.manage().window().maximize();
	}

	/**
	 * this method is used to navigate the application via url
	 * @param url 
	 * 
	 * @param time
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * this method waits until element found
	 * 
	 * @param time
	 * @param time
	 */
	public void waitUntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * this method is used to wait until element is displayed
	 * 
	 * @param element
	 * @param time
	 * @param element
	 * 
	 * @return
	 */
	public void waitUntilElementFound(long time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to wait until element is enabled
	 * 
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(WebElement element,long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * this method is used to wait until element is displayed
	 * 
	 * @param title
	 * @param time
	 * @return
	 */
	public boolean explicitWait(long time,String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * this method is used to mouse hover to an element
	 *  *@param element
	 */
	public void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this method is used to double click to an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * this method is used to right click to an element 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * this method is used to drag&drop to an element to target
	 * @param element
	 * @param target
	 **/
	public void dragAndDropElement(WebElement element, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, target).perform();
	}

	/**
	 * this method is used to select an element from drop using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * this method is used to select an element from drop using value
	 * @param element
	 * @param value
	 */
	public void dropdown1(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * this method is used to select an element from drop using visibile text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * this method is used to scroll till element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true)",element);
	}

	/**
	 * this element is used to switch to frame using index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * this element is used to switch to frame using id or name atribute value
	 * * @param attribute value
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	/**
	 * this element is used to switch to frame using frame element * @param frame
	 * element
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

	/**
	 * this element is used to switch back to frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to capture screenshot of window
	 * @param <JavaUtility>
	 * @param jUtil
	 */
	public void takeScreenshot(JAvaUtility jUtil) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/ss_*" + jUtil.getCurrentTime() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to handle alert 
	 * @param status
	 */
	public void handleAlert(String status) {
		Alert a1 = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))
			a1.accept();
		else
			a1.dismiss();
	}

	/**
	 * this method is used to switch to child browser
	 */
	public void switchToChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String id : set) {
			driver.switchTo().window(id);
		}
	}

	/**
	 * this method is used to close the current window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}

	/**
	 * this method is used to exit all the browser/window
	 */
	public void quitallWindows() {
		driver.quit();
	}
}
