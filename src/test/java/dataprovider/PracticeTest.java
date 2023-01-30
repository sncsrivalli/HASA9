package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeTest {
	
	@Test(dataProvider = "dataForTicketBooking")
	public void bookTicketTest(String source, String dest) {
		System.out.println("From: "+source+"\t"+"To: "+dest);
	}
	
	@DataProvider
	public Object[][] dataForTicketBooking() {
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "Bangalore";
		obj[0][1] = "Hyd";
		
		obj[1][0] = "Kolkata";
		obj[1][1] = "Kochi";
		
		obj[2][0] = "Mumbai";
		obj[2][1] = "Delhi";
		
		return obj;
	}

}
