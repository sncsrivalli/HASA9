package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
	
	@Test
	public void demo1() {
		SoftAssert soft = new SoftAssert();
		String s1 = "Hi";
		String s2 = "Hello";
		
		soft.assertEquals(s1, s2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		soft.assertAll();
	}
	
	@Test
	public void demo2() {
		System.out.println("In demo2");
	}

}
