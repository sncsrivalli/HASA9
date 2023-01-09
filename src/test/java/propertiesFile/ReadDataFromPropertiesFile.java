package propertiesFile;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException   {
		
		//Step 1: Convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		//Step 2: Create an instance for Properties class 
		//Properties class is available in java.util package
		Properties p = new Properties();
		
		//Step 3: Load all the key-value pairs to properties object 
		p.load(fis); // IOException
		//Java concept involved - Map interface- HashTable
		
		//Step 4: Read data 
		String url = p.getProperty("url");
		long time = Long.parseLong(p.getProperty("timeouts"));
		
		System.out.println(url+"\t"+time);

	}

}
