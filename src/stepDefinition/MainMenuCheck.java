package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainMenuCheck 
{

	WebDriver driver;
	
	
	
	@Before
	public void init() 
	{
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	}

	@After
	public void close() 
	{
	    driver.quit();
	}
	
	@When("^I go to the homepage$")
	public void i_go_to_the_homepage() throws Throwable 
	{
		driver.get("https://orionhealth.com");
		System.out.println("Eranga");
	}

	@Then("^I should see 'Solutions for' menu$")
	public void i_should_see_Solutions_for_menu() throws Throwable 
	{
		Assert.assertEquals("Solutions for", driver.findElement(By.xpath("//nav/ul/li/a")).getText());
	}

	@Then("^I should see 'Products' menu$")
	public void i_should_see_Products_menu() throws Throwable 
	{
		Assert.assertEquals("Products", driver.findElement(By.xpath("//nav/ul/li[2]/a")).getText());
	}

	@Then("^I should see 'Knowledge Hub' menu$")
	public void i_should_see_Knowledge_Hub_menu() throws Throwable 
	{
		Assert.assertEquals("Knowledge Hub", driver.findElement(By.xpath("//nav/ul/li[3]/a")).getText());
	}

	@Then("^I should see 'Support' menu$")
	public void i_should_see_Support_menu() throws Throwable 
	{
		Assert.assertEquals("Support", driver.findElement(By.xpath("//nav/ul/li[4]/a")).getText());
	}

	@Then("^I should see 'About Us'$")
	public void i_should_see_About_Us() throws Throwable 
	{
		Assert.assertEquals("About Us", driver.findElement(By.xpath("//nav/ul/li[5]/a")).getText());
	}

	@When("^I go to menu (\\d+) (.*)$")
	public void i_go_to_menu(int arg1, String str1) throws Throwable 
	{
		WebElement menu=driver.findElement(By.xpath("(//a[contains(text(),'"+str1+"')])['"+arg1+"']"));//Menu
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", menu);
	}

	@When("^I click sub menu (\\d+) (.*)$")
	public void i_click_sub_menu_Healthcare_Providers(int arg1, String str1) throws Throwable 
	{
		WebElement submenu=driver.findElement(By.xpath("(//a[contains(text(),'"+str1+"')])['"+arg1+"']"));//Menu Item
		JavascriptExecutor executor1 = (JavascriptExecutor)driver; 
		executor1.executeScript("arguments[0].click();", submenu);
	}

	@Then("^I should see page title (.*)$")
	public void i_should_see_page_title_Healthcare_Providers(String str1) throws Throwable 
	{
		Thread.sleep(5000);
		Assert.assertEquals(""+str1+" | Orion Health", driver.getTitle());
	}

	@Then("^I should see page header (.*) (\\d+) (.*)$")
	public void i_should_see_page_header_Solutions_for_Healthcare_Providers(String str1, int arg1, String str2) throws Throwable 
	{
		Assert.assertEquals("Home\n"+""+str1+"\n"+""+str2+"", driver.findElement(By.cssSelector("ol")).getText());
	}
}