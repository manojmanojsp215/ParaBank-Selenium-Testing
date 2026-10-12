package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ParaBankLoginTest {
	@Test
	public void openWebsite() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		String title=driver.getTitle();
		System.out.println("page title: "+title);
		Assert.assertTrue(title.contains("ParaBank"));
		driver.quit();

	}
	@Test
    public void verifyLoginPage() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        String title = driver.getTitle();

        Assert.assertTrue(title.contains("ParaBank"));

        String pageSource = driver.getPageSource();

        Assert.assertTrue(pageSource.contains("Username"));

        System.out.println("Login page verified successfully!");

        driver.quit();
    }
	 @Test
	    public void validLoginTest() {

	        WebDriver driver = new ChromeDriver();

	        driver.get("https://parabank.parasoft.com/parabank/index.htm");

	        driver.findElement(By.name("username")).sendKeys("manoj");
	        driver.findElement(By.name("password")).sendKeys("manoj123");

	        driver.findElement(By.cssSelector("input[type='submit']")).click();

	        String pageSource = driver.getPageSource();

	        Assert.assertTrue(
	            pageSource.contains("Accounts Overview"),
	            "Login may have failed"
	        );

	        System.out.println("Login test passed!");

	        driver.quit();
	    }
	 @Test
	 public void invalidLoginTest() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(By.name("username"))
	           .sendKeys("wronguser123");

	     driver.findElement(By.name("password"))
	           .sendKeys("wrongpass123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();

	     String pageSource = driver.getPageSource();

	     Assert.assertTrue(
	         pageSource.contains("Error"),
	         "Expected login error message was not displayed"
	     );

	     System.out.println("Invalid login test passed!");

	     driver.quit();
	 }
	 @Test
	 public void verifyAccountOverview() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();

	     boolean accountOverviewDisplayed =
	             driver.getPageSource().contains("Accounts Overview");

	     Assert.assertTrue(
	             accountOverviewDisplayed,
	             "Account Overview page was not displayed"
	     );

	     System.out.println("Account Overview verified successfully!");

	     driver.quit();
	 }
	 @Test
	 public void logoutTest() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");
	     
	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();
	    
	     driver.findElement(By.linkText("Log Out")).click();
	    
	     boolean logoutSuccessful =
	             driver.getPageSource().contains("Customer Login");

	     Assert.assertTrue(
	             logoutSuccessful,
	             "Logout was not successful"
	     );

	     System.out.println("Logout test passed!");

	     driver.quit();
	 }
	 @Test
	 public void verifyRegistrationPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(By.linkText("Register")).click();

	     WebDriverWait wait =
	             new WebDriverWait(driver, Duration.ofSeconds(10));

	     wait.until(d ->
	             d.getPageSource().contains("First Name"));

	     Assert.assertTrue(
	             driver.getPageSource().contains("First Name"),
	             "Registration page did not open"
	     );

	     System.out.println("Registration page verified!");

	     driver.quit();
	 }
	 @Test
	 public void verifyCustomerLookupPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(By.linkText("Forgot login info?")).click();

	     Assert.assertTrue(
	         driver.getPageSource().contains("First Name"),
	         "Customer lookup page did not open"
	     );

	     System.out.println("Customer lookup page verified!");

	     driver.quit();
	 }
	 
	 @Test
	 public void verifyCustomerServicePage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     String currentUrl = driver.getCurrentUrl();

	     Assert.assertTrue(
	         currentUrl.contains("/parabank/"),
	         "ParaBank website did not open"
	     );

	     System.out.println("ParaBank website verified successfully!");

	     driver.quit();
	 }
	 @Test
	 public void verifyContactPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(
	         By.xpath("//a[contains(@href,'contact.htm')]")
	     ).click();

	     String currentUrl = driver.getCurrentUrl();

	     Assert.assertTrue(
	         currentUrl.contains("contact.htm"),
	         "Contact page did not open"
	     );

	     System.out.println("Contact page verified successfully!");

	     driver.quit();
	 }
	 @Test
	 public void verifyAboutUsPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     driver.findElement(
	         By.linkText("About Us")
	     ).click();

	     String currentUrl = driver.getCurrentUrl();

	     Assert.assertTrue(
	         currentUrl.contains("about.htm"),
	         "About Us page did not open"
	     );

	     System.out.println("About Us page verified successfully!");

	     driver.quit();
	 }
	 @Test
	 public void verifyTransferFundsPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	    
	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();

	     
	     driver.findElement(By.linkText("Transfer Funds")).click();

	    
	     Assert.assertTrue(
	         driver.getPageSource().contains("Transfer Funds"),
	         "Transfer Funds page did not open"
	     );

	     System.out.println("Transfer Funds page verified!");

	     driver.quit();
	 }
	 @Test
	 public void verifyBillPaymentPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");
	     
	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();
	     
	     driver.findElement(By.linkText("Bill Pay")).click();
	     
	     Assert.assertTrue(
	         driver.getPageSource().contains("Bill Payment"),
	         "Bill Payment page did not open"
	     );

	     System.out.println("Bill Payment page verified!");

	     driver.quit();
	 }
	 @Test
	 public void verifyFindTransactionsPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");

	     // Login using your valid credentials
	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();
	     
	     driver.findElement(By.linkText("Find Transactions")).click();
	     
	     Assert.assertTrue(
	         driver.getPageSource().contains("Find Transactions"),
	         "Find Transactions page did not open"
	     );

	     System.out.println("Find Transactions page verified!");

	     driver.quit();
	 }
	 @Test
	 public void verifyUpdateContactInfoPage() {

	     WebDriver driver = new ChromeDriver();

	     driver.get("https://parabank.parasoft.com/parabank/index.htm");
	     
	     driver.findElement(By.name("username"))
	           .sendKeys("manoj");

	     driver.findElement(By.name("password"))
	           .sendKeys("manoj123");

	     driver.findElement(By.cssSelector("input[type='submit']"))
	           .click();
	     
	     driver.findElement(By.linkText("Update Contact Info")).click();
	    
	     Assert.assertTrue(
	         driver.getPageSource().contains("Update Profile"),
	         "Update Contact Information page did not open"
	     );

	     System.out.println("Update Contact Information page verified!");

	     driver.quit();
	 }
}
