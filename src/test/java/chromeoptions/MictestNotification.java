package chromeoptions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MictestNotification {

	public static void main(String[] args) {
		HashMap<String, Integer> contentSettings = new HashMap<>();
		contentSettings.put("media_stream", 1);
		
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", contentSettings);
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://mictests.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("mic-launcher")).click();



	}

}
