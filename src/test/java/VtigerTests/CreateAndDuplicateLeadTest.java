package VtigerTests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;

public class CreateAndDuplicateLeadTest {

	public static void main(String[] args) {
		PropertiesFileUtility property = new PropertiesFileUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility web = new WebDriverUtility();
		
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
//		Random random = new Random();
//		int randomNum = random.nextInt(100);
////		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		WebDriver driver = web.openApplication(browser, url, time);
		
		String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
		
		if(title.contains("vtiger"))
			System.out.println("Login Page Displayed");
		else
			System.out.println("Login Page is not Displayed");
		
		driver.findElement(By.name("user_name")).sendKeys(property.fetchProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(property.fetchProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
		String homePageText = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if(homePageText.contains("Home"))
			System.out.println("Home Page is displayed");
		else
			System.out.println("Home Page is not displayed");
		
		driver.findElement(By.xpath("//a[.='Leads']")).click();
		
		String leads = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		
		if (leads.contains("Leads"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		String createLead = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(createLead.contains("Creating New Lead"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		Map<String,String> map = excel.readDataFromExcel("Create Lead", "TestData");
		
		WebElement salutationDropdown = driver.findElement(By.name("salutationtype"));
		web.dropdown(map.get("First Name Salutation"), salutationDropdown);
//		Select salutation = new Select(salutationDropdown);
//		salutation.selectByValue("Mrs.");
		
		String leadName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
		driver.findElement(By.name("lastname")).sendKeys(leadName);
		
		driver.findElement(By.name("company")).sendKeys(map.get("Company"));
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		String newLeadInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(newLeadInfo.contains(leadName))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		driver.findElement(By.name("Duplicate")).click();
		String duplicatingPage = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(duplicatingPage.contains(leadName))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		String duplicateLeadName = map.get("New Last Name")+javaUtil.generateRandomNumber(100);
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys(duplicateLeadName);
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		
		String newLead = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		if(newLead.equals(duplicateLeadName)) {
			System.out.println("Pass");
			excel.setDataToExcel("Create Lead", "Pass", IConstantPath.EXCEL_FILE_PATH, "TestData");
		}
		else {
			System.out.println("Fail");
			excel.setDataToExcel("Create Lead", "Fail", IConstantPath.EXCEL_FILE_PATH, "TestData");
		}
		

		WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		web.mouseHover(administratorIcon);
//		Actions a = new Actions(driver);
//		a.moveToElement(administratorIcon).perform();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		web.closeWindows();
		excel.closeWorkbook();
		
	}
}
