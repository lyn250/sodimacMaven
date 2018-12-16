package scriptsDebugging;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactory.DashboardPage;
import pageFactory.LoginPage;

public class CP_001_debug {
	
	static String driverPath = "F:\\webdrivers\\chromedriver.exe";	
	static String TipoWebdriver = "webdriver.chrome.driver";
	
	LoginPage objLogin;
	DashboardPage objDashboard;
	
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
		
		String obtenido = objDashboard.getlinkMenuCuentaText();
		String esperado = "Bienvenido Admin";
		objDashboard.clickLinkLogout();
		Assert.assertEquals(obtenido, esperado, "Prueba fallida debido a que el resultado obtenido y el esperado no coinciden.");			
	} finally {
		if(driver != null) {
           driver.quit();
		}
	}
  }
}
