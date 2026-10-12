package loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
public class loginpagetest extends BaseTest {
	String url="www.saucedemo";
	String valid_user= "standard_user";
	String valid_pass="secret_sauce";
	@Test
	public void login_page() {
	 driver.get(url);
	 WebElement username_feild=driver.findElement(By.id("user-name"));
	 username_feild.sendKeys(valid_user);
	 WebElement password_feild=driver.findElement(By.id("pasword"));
	 password_feild.sendKeys(valid_pass);
	 WebElement loginbutton=driver.findElement(By.id("login-button"));
	 loginbutton.click();
	 String currenturl=driver.getCurrentUrl();
	 System.out.println("current url"+currenturl);
	 Assert.assertTrue(currenturl.contains("inventory"));
	 
	}
	@Test
	public void password_error_find() {
		driver.get(url);
		 WebElement username_feild=driver.findElement(By.id("user-name"));
		 username_feild.sendKeys(valid_user);
		 WebElement password_feild=driver.findElement(By.id("pasword"));
		 password_feild.sendKeys("manoj");
		 WebElement loginbutton=driver.findElement(By.id("login-button"));
		 loginbutton.click();
		 WebElement error_message=driver.findElement(By.cssSelector("[data-test=error]"));
		 Assert.assertTrue(error_message.isDisplayed(),"error message is displayed");
		 System.out.println(error_message);
	}
	
	@Test
	public void emptyusername_error() {
		driver.get(url);
		WebElement username_feild=driver.findElement(By.id("user-name"));
		 username_feild.sendKeys(valid_user);
		 WebElement password_feild=driver.findElement(By.id("pasword"));
		 password_feild.sendKeys("manoj");
		 WebElement loginbutton=driver.findElement(By.id("login-button"));
		 loginbutton.click();
		 WebElement Emptyusername=driver.findElement(By.cssSelector("[data-test=error]"));
		 Assert.assertTrue(Emptyusername.isDisplayed(),"invalid username it  shoud be displayed");
		 
		
		
	}
	

}
