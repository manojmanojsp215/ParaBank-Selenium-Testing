package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class xpath_test extends BaseTest {
	@Test
	public void xpath_test_byid() {
		driver.get("https://www.saucedemo.com");
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("test_user");
		Assert.assertEquals(username.getAttribute("Value"),"test_user");
	}
	@Test
	public void xpath_test_byattribute() {
		driver.get("https://www.saucedemo.com");
		WebElement loginbutton=(WebElement) driver.findElement(By.xpath("//input[@value='Login']"));
		Assert.assertTrue(loginbutton.isDisplayed(),"login  button should be displayed");
		System.out.println("Login button is displayed");
	}
	@Test
	public void xpath_byname() {
		Object login_helper = newloginwithvaliduser(driver);
	}
	
	

}
