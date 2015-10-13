package SeleniumIntegration.MavenJenkins;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TestHelper {

	private static WebElement element=null;
	// Math Calc Link
	   public static WebElement lnk_math_calc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a"));
	      return element;
	   }
		
	   //Percentage Calc Link
	   public static WebElement lnk_percent_calc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a"));
	      return element;
	   }
		
	   //Number 1 Text Box
	   public static WebElement txt_num_1(WebDriver driver)
	   {
	      //element = driver.findElement(By.id("cpar1"));
		   element=driver.findElement(By.xpath(".//*[@id='cpar1']"));
	      return element;
	   }
		
	   //Number 2 Text Box	
	   public static WebElement txt_num_2(WebDriver driver)
	   {
	      //element = driver.findElement(By.id("cpar2"));
		   element=driver.findElement(By.xpath(".//*[@id='cpar2']"));
	      return element;
	   }
		
	   //Calculate Button	
	   public static WebElement btn_calc(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
	      return element;
	   }	
		
	   // Result	
	   public static WebElement web_result(WebDriver driver)
	   {
	      element = driver.findElement(By.xpath(".//*[@id='cpar3']"));
	      return element;
	   }
	   
	   /*
	    * Login Page
	    */
	   //email address text box
	   public static WebElement emailAddress(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='email']"));
		   return element;
	   }
	   //password text box
	   public static WebElement password(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='password']"));
		   return element;
	   }
	   //remember check box
	   public static WebElement rememberEmail(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='login-form']/div[3]/label/input"));
		   return element;
	   }
	   //login button
	   public static WebElement login(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='login-form']/button"));
		   return element;
	   }
	   //Lost your password link
	   public static WebElement passwordLink(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/a"));
		   return element;
	   }
	   //signup link
	   public static WebElement signupLink(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/p/a"));
		   return element;
	   }
	   /*
	    * Signup Page
	    */
	   //first name text box
	   public static WebElement firstName(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='signup-form']/div[1]/input"));
		   return element;
	   }
	   //second name text box
	   public static WebElement lastName(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='signup-form']/div[2]/input"));
		   return element;
	   }
	  //confirm password text box
	   public static WebElement confirmPassword(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='confirm_password']"));
		   return element;
	   }
	   //Choose your timezone
	   public static void selectTimeZone(WebDriver driver)
	   {
	   Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='time-zone']")));
	   dropdown.selectByValue("Asia/Kolkata");;
	   }
	   //Terms and conditions check box
	   public static WebElement acceptTerms(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='signup-form']/div[8]/p/input"));
		   return element;
	   }
	   
	   //signup button
	   public static WebElement  signup(WebDriver driver)
	   {
		   element=driver.findElement(By.xpath(".//*[@id='sign_up']"));
		   return element;
	   }
	   
	    
}

