package scriptsDebugging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import miscelaneous.*;

import pageFactory.DashboardPage;
import pageFactory.LoginPage;
import pageFactory.NationalitiesPage;

public class CP_002_debug {
	
	static String driverPath = "F:\\webdrivers\\chromedriver.exe";	
	static String TipoWebdriver = "webdriver.chrome.driver";
	
	LoginPage objLogin;
	DashboardPage objDashboard;
	NationalitiesPage objNation;
	
  @Test
  public void f() throws InterruptedException {
    System.setProperty(TipoWebdriver, driverPath);
  	WebDriver driver = new ChromeDriver();
	try {
	  	driver.manage().window().maximize();
	  	driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
	  	objLogin = new LoginPage(driver);
		objLogin.iniciarSesionAdmin();
		objDashboard = new DashboardPage(driver);
		objDashboard.clickLinkNationalities();
		objNation = new NationalitiesPage(driver);
		objNation.cambiarAFrame();
		objNation.clickButtonAdd();
		objNation.completarFormulario(Util.generarRandomString(5));
		String obtenido = objNation.getMensaje();
		String esperado = "Successfully Saved";
		Assert.assertEquals(obtenido, esperado, "Prueba fallida debido a que el resultado obtenido y el esperado no coinciden.");
	} finally {
		if(driver != null) {
           driver.quit();
		}
	}
  }
}
