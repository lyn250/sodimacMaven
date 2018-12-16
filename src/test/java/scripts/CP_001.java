package scripts;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.ConfigMethods;
import pageFactory.DashboardPage;
import pageFactory.LoginPage;

public class CP_001 {
	LoginPage objLogin;
	DashboardPage objDashboard;
	
	@Test
	  public void chrome() throws MalformedURLException, InterruptedException {
		  ConfigMethods config = new ConfigMethods();
		  config.setDriver("chrome");
		  script(config.getDriver());
	  }
	
	public void script(WebDriver driver) throws InterruptedException {
		try {
		  	objLogin = new LoginPage(driver);
			objLogin.iniciarSesionAdmin();
			Thread.sleep(2000);
			objDashboard = new DashboardPage(driver);
			String obtenido = objDashboard.getlinkMenuCuentaText();
			String esperado = "Welcome Admin";
			Assert.assertEquals(obtenido, esperado, "Prueba fallida debido a que el resultado obtenido y el esperado no coinciden");			
		} finally {
			if(driver != null) {
	           driver.quit();
			}
		}
	  }
}
