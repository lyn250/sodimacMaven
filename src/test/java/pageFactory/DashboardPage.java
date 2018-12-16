package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	
	@FindBy(xpath="//*[@id=\"option-menu\"]/li[1]")
		WebElement linkMenuCuenta;
	
	@FindBy(xpath="//*[@id=\"option-menu\"]/li[3]/a")
		WebElement linkLogout;
	
	@FindBy(xpath="//*[@id=\"admin\"]/ul/li[5]/a")
		WebElement linkNationalities;
	
	@FindBy(xpath="//*[@id=\"btnAdd\"]")
	WebElement linkagregar;

	
	
	public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor)driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
	
	public void clickLinkMenuCuenta() {
		linkMenuCuenta.click();
	}
	
	public void clickLinkLogout() {
		wait.until(ExpectedConditions.visibilityOf(linkLogout));
		linkLogout.click();
	}
	
	public void clickLinkNationalities() throws InterruptedException {
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click()", linkNationalities);
	}
	
	public String getlinkMenuCuentaText() {
		return linkMenuCuenta.getText();
	}
	
}
