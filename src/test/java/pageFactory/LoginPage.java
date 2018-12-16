package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(id="txtUsername")
      WebElement txtUsername;
    
    @FindBy(id="txtPassword")
      WebElement txtPassword;
    
    @FindBy(id="btnLogin")
      WebElement btnLogin;
    
    
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    
    public void setUsername(String nombreUsuario){
    	wait.until(ExpectedConditions.visibilityOf(txtUsername));
    	txtUsername.clear();
    	txtUsername.sendKeys(nombreUsuario);
    }
    
    public void setPassword(String contrasena){
    	wait.until(ExpectedConditions.visibilityOf(txtPassword));
    	txtPassword.clear();
        txtPassword.sendKeys(contrasena);
    }
    
    public void clickLogin(){
    	wait.until(ExpectedConditions.visibilityOf(btnLogin));
    	btnLogin.click();
    }
    
    public void iniciarSesion(String nombreUsuario,String contrasena){
        this.setUsername(nombreUsuario);
        this.setPassword(contrasena);
        this.clickLogin();
    }
    
    public void iniciarSesionAdmin() {
    	this.iniciarSesion("opensourcecms", "opensourcecms");
    }
}
