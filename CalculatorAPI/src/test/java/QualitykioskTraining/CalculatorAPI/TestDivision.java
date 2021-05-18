package QualitykioskTraining.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDivision {
	
	Calculator Cal;
	int Res;
	@BeforeClass
	public void CreateObj(){
		Cal=new Calculator();
	}
	@BeforeMethod
	public void Reinitialize() {
		Res=0;
	}
	
	@Test(priority=1,groups= {"RegressionTest"})
	public void TestDivisionWithPositiveValues() {
		System.out.println("Test case 1");
		Res=Cal.Division(100, 2);
		Assert.assertEquals(Res, 50,"Division is not working");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("In After Method");
	}
	
	@Test(priority=2,groups= {"RegressionTest"})
	public void TestDivisionWithnegativeValues() {
		System.out.println("Test case 2");
		Res=Cal.Division(-100, -2);
		Assert.assertEquals(Res, 50,"Division is not working");
	}

	
	@AfterClass
	public void ReleaseObj() {
		System.out.println("in After Class");
		Cal=null;
	}

}
