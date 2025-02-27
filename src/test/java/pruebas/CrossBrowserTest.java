package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver;

	//Variables que necesitaremos para nuestra prueba
	String url="http://www.automationpractice.pl/";
	
	@BeforeMethod
	@Parameters("navegador")
	public void setUP(String navegador) {
		
	if (navegador.equalsIgnoreCase("edge")) {
		
	  driver= new EdgeDriver();
	
	
	}
	else {
	  
		driver= new FirefoxDriver();

		   
	} 
	
	driver.manage().deleteAllCookies();//Borra las cookies
	driver.manage().window().maximize();//Maximiza la ventana
	driver.get(url);
	
   }
	@Test
	public void BuscarTexto() {
	
    WebElement txtBusqueda=driver.findElement(By.id("search_query_top"));
	txtBusqueda.sendKeys("dress");	
	txtBusqueda.sendKeys(Keys.ENTER);
	
	
    }
	
	@AfterMethod
    public void CerrarNagvegador() {
		
	 driver.quit();//Cierra todas las pestañas que se trabajaron
	}
}
