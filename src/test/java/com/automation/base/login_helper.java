package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_helper {
	public WebDriver driver;
	
public login_helper(WebDriver driver) {
	this.driver=driver;
}
public void loginwithvaliduser() {
	driver.get("https://www.saucedemo.com");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
}
}
