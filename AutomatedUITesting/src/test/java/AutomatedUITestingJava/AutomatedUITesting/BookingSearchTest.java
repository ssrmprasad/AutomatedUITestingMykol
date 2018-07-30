package AutomatedUITestingJava.AutomatedUITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import AutomatedUITestingJava.AutomatedUITesting.ui.controls.Control;
import AutomatedUITestingJava.AutomatedUITesting.ui.controls.Edit;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.*;
import junit.framework.*;

@RunWith(Parameterized.class)
public class BookingSearchTest {
	private WebDriver driver;
	private String destination;
	private boolean isLeisure;
	private int numberOfAdults;
	
	
	
	public BookingSearchTest(String destination, boolean isLeisure, int numberOfAdults) {
		super();
		this.destination = destination;
		this.isLeisure = isLeisure;
		this.numberOfAdults = numberOfAdults;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters()
	{
		return Arrays.asList(new Object[][]
				{
					{"London",true,2},
					{"Manchester",false,1}
				});
	}
	/*public BookingSearchTest()
	{
		
	}*/
	@Before
	public void setUp() throws Exception
	{
		Configuration.load();
		Configuration.print();
		String baseUrl = Configuration.get("url");
		System.setProperty("webdriver.chrome.driver", "/Users/rmohanprasad/git/Mastering Selenium TestNG/src/resources/browserexes/chromedriver2");
		System.setProperty("webdriver.gecko.driver", "/Users/rmohanprasad/git/Mastering Selenium TestNG/src/resources/browserexes/geckodriver");
		//System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver2").getAbsolutePath());
		//System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());
		DesiredCapabilities cap = new DesiredCapabilities();
		//driver = new ChromeDriver(cap);
		Driver.add(Configuration.get("browser"),cap);
		driver = Driver.current();
		driver.get(baseUrl);
		
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void firstTest()
	{
		driver.findElement(By.id("ss")).click();
		driver.findElement(By.id("ss")).clear();
		driver.findElement(By.id("ss")).sendKeys("London");
		driver.findElement(By.id("ss")).sendKeys(this.destination);
		driver.findElement(By.cssSelector("i.sb-date-field__chevron.bicon-downchevron")).click();
		driver.findElement(By.xpath("//table[@class='c2-month-table']//td[contains(@class,'c2-day-s-today')]")).click();
		if(this.isLeisure)
		{
			driver.findElement(By.xpath("(//input[@name='sb_travel_purpose'])[2]")).click();;
		}
		else
		{
			driver.findElement(By.xpath("(//input[@name='sb_travel_purpose'])[1]")).click();;
		}
	}
	
	@Test
	public void testValidSearch()
	{
		Edit editDestination = new Edit(driver,By.id("ss"));
		Control checkoutDayExpand = new Control(driver,By.cssSelector("i.sb-date-field__chevron.bicon-downchevron"));
		Control checkoutDayToday = new Control(driver,By.xpath("//table[@class='c2-month-table']//td[contains(@class,'c2-day-s-today')]"));
	}
	

}
