package synchronization;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[contains(text(),'Example 1')]")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement header = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
				if(element.isDisplayed())
					return element;
				else
					return null;
			}
		});
		
		System.out.println(header.getText());
		driver.quit();
	}

}
