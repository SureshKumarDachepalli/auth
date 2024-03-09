package pkg2;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v112.performance.Performance;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pkg1.A;

public class B {


	public static void main(String[] args) throws Throwable {
		WebDriver	driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		//click on sign
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
	
		//enter mail id
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sureshkumar.d467@gmail.com");
		//click on continue button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		//enter on pw
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("suresh");
		//click on sign button
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	
	Thread.sleep(2000);
	//enter values in search box
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone",Keys.ENTER);
	
	//parent window
	Thread.sleep(2000);
	 String parentWindow=driver.getWindowHandle();
	//scroll down
	Thread.sleep(2000);
JavascriptExecutor	jse=(JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,2000)");
//click one mobile 
    driver.findElement(By.xpath("//img[@class='s-image']")).click();
    Thread.sleep(2000);
   
    
//go to child window
  Set<String>  childWindow=driver.getWindowHandles();
  for(String w:childWindow) {
	  if(!w.equals(parentWindow)) {
	  
	 // Perform actions on the child window 
	  driver.switchTo().window(w);
	    
	//again scroll down
		Thread.sleep(2000);
	jse.executeScript("window.scrollBy(0,500)");
	try {
		//click on add to cart
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
	}catch(ElementNotInteractableException e) {
		System.out.println("it showing ElementNotInteractableException");
	}

	//click on cart
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//close the child window
	Thread.sleep(3000);
	driver.close();
	       }
         }
//Switch back to the parent window
  Thread.sleep(2000);
  driver.switchTo().window(parentWindow);

   
  
 
 

	}

}
