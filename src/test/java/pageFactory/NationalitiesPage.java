package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NationalitiesPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	String frame = "rightMenu";
	
	@FindBy(id="btnAdd")
		WebElement buttonAdd;
	
	@FindBy(name="nationality[name]")
		WebElement txtNombre;
	
	@FindBy(name="btnSave")
		WebElement btnSave;
	
	@FindBy(xpath="//*[@id=\"messagebar\"]/span")
		WebElement mensaje;
	
	public NationalitiesPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor)driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
	
	public void clickButtonAdd() {
		
		wait.until(ExpectedConditions.visibilityOf(buttonAdd));
		buttonAdd.click();
	}
	
	public void cambiarAFrame() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(frame);
	}
	
	public void setNombre(String nombre) {
		wait.until(ExpectedConditions.visibilityOf(txtNombre));
		txtNombre.clear();
		txtNombre.sendKeys(nombre);
		//Enviar valores mediante JS
		//executor.executeScript("arguments[0].value='"+nombre+"'", txtNombre);
	}
	
	public void clickButtonSave() {
		wait.until(ExpectedConditions.visibilityOf(btnSave));
		btnSave.click();
	}
	
	public void completarFormulario(String nacionalidad) {
		this.setNombre(nacionalidad);
		this.clickButtonSave();
	}
	
	public String getMensaje() {
		wait.until(ExpectedConditions.visibilityOf(mensaje));
		return mensaje.getText();
	}
	
	
}
