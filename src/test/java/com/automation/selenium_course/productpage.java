package com.automation.selenium_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.base.login_helper;

public class productpage extends BaseTest {
	login_helper loginwithvaliduser;
	
	@BeforeMethod
	public void login_first() {
		loginwithvaliduser=new login_helper(driver);
		loginwithvaliduser.loginwithvaliduser();
	}
	@Test
	public void product_page() {
		WebElement getTitle=driver.findElement(By.className("title"));
		String title=getTitle.getText();
		Assert.assertEquals(title, "Products","the title should contain Products");
		
	}
	@Test
	public void product_displayed() {
		java.util.List<WebElement> productslist=driver.findElements(By.className("inventory_item_name"));
		Assert.assertEquals(productslist.size(),6, "products should be 6");
		
	}
	@Test
	public void product_name_price() {
		WebElement productname=driver.findElement(By.className("inventory_item_name"));
		String firstproductname=productname.getText();
		System.out.println("item name is"+firstproductname);
		Assert.assertFalse(firstproductname.isEmpty());
	}
	
	

}
