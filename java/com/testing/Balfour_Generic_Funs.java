package com.testing;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Balfour_Generic_Funs {
	//public static  com.testing.Balfour_Generic_Funs balfour= new Balfour_Generic_Funs();
	public static WebDriver driver;
	@FindBy(name="login[username]")												WebElement userName;
	@FindBy(name="login[password]")												WebElement passWord;
	@FindBy(name="send")														WebElement loginBtn;
	@FindBy(className="searchbox")												WebElement MainInputsearchbox;
	@FindBy(className="show-for-medium-up")											WebElement searchBtn;
	//@FindBy(css="span[class='show-for-medium-up']")											WebElement searchBtn;
	
	
	
	 public void Open_URL_Of_Balfour(){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\upen5\\ChromeDriver\\2.29\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.balfour.com/");
			System.out.println("Page title is: " + driver.getTitle());
			PageFactory.initElements(driver, this);

			//Close the browser
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.quit();
	}
		 
	 public void  Click_On_Desired_Link_Or_Image(String linkOrImageName)
	 
	 {
		 
		 List<WebElement> elements=driver.findElements(By.tagName("a"));
		 outerloop:
			for (WebElement element : elements) {
		            System.out.println(element.getText());
		            
		            if(element.getText().equalsIgnoreCase(linkOrImageName)){
		              	
		            	element.click();
		            	System.out.println("**** Welcome to login page*****");
		            	
		            	break outerloop;
		            }
		 
	 }
	 
	 }
	 public void Login_Balfour(String inputName, String inputpassWord){
		 
		 		System.out.println(driver.getTitle());

	            new WebDriverWait(driver ,20).until(ExpectedConditions.titleContains("Customer Login"));
		 	
	            	userName.clear();
	            	userName.sendKeys(inputName);	
	            	
	            	userName.sendKeys(Keys.TAB);
	            	
	            	passWord.clear();
	            	passWord.sendKeys(inputpassWord);
	            	
	            	passWord.sendKeys(Keys.TAB);	
	            	
	            	loginBtn.click();
	            	
	   		
	  
	 }	 
	 
	 
	 void Enter_Text_On_SerchBox(String inputtext)

	 {
		 MainInputsearchbox.clear();
		 MainInputsearchbox.sendKeys(inputtext);
		 MainInputsearchbox.sendKeys(Keys.ESCAPE);
		 //MainInputsearchbox.sendKeys(Keys.TAB);
		 //searchBtn.sendKeys(Keys.ENTER);
		 
		 try {
			safeJavaScriptClick(searchBtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 public void safeJavaScriptClick(WebElement element) throws Exception {
			try {
				if (element.isEnabled() && element.isDisplayed()) {
					System.out.println("Clicking on element with using java script click");
					
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				} else {
					System.out.println("Unable to click on element");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is not attached to the page document "+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in DOM "+ e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to click on element "+ e.getStackTrace());
			}
		}
		 
	 }



















