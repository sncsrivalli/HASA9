package testForListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
//@Listeners(genericLibraries.ListenerImplementation.class)
public class Test1 extends BaseClass{
	
	@Test(retryAnalyzer = genericLibraries.RetryImplementation.class)
	public void test1() {
		System.out.println("Test1");
		Assert.fail();
	}

}
