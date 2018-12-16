package scripts;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.ConfigMethods;
import miscelaneous.Util;
import pageFactory.DashboardPage;
import pageFactory.LoginPage;
import pageFactory.NationalitiesPage;

public class CP_002 {
	LoginPage objLogin;
	DashboardPage objDashboard;
	NationalitiesPage objNation;
	
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
