package selenium;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnauthorizedUserDetailsRestaurant {
	
	@Test
	public void Tested1() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		sleep(3000);
		driver.manage().window().maximize();

		String url = "http://localhost:3000/restaurants";
		driver.get(url);
		  
		
		WebElement detailsButton = driver.findElement(By.xpath("//span[(text()= 'details')]/ancestor::a"));
		detailsButton.click();
		//sleep(3000);
		
		//Restaurant Name
		String actualResult = driver.findElement(By.xpath("html//div[@id='root']/main//h4[.='Bennett-Prince']")).getText();
		String expectedResult = "Bennett-Prince";
		
		//Address restaurant
		String address = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div[2]/p[1]")).getText();
		String addressResult = "Address: 55839 Valerie Highway Mooneytown, SC 16659\n"
				+ "Phone: +380362100001";
		
		Assert.assertEquals(expectedResult, actualResult);
		Assert.assertEquals(addressResult, address);
 		sleep(2000);
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}