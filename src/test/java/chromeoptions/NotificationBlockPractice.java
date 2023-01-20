package chromeoptions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NotificationBlockPractice {

	public static void main(String[] args) {
		HashMap<String, Integer> contentSettings = new HashMap<>();
		contentSettings.put("geolocation", 2);
		contentSettings.put("notifications", 2);
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", contentSettings);
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		


	}

}
