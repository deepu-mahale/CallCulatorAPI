package QualitykioskTraining.CalculatorAPI;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addition {
	
	Calculator obj;
	int Result;
 	@BeforeGroups("RegressionTest")
	public void InitGroups()
	{
		System.out.println("Im in Before Grooup"); 
 		obj=new Calculator();

	}

 	@BeforeClass
	public void Init()
	{
		System.out.println("Im in Before Class"); 
 		obj=new Calculator();

	}
 
 	@BeforeMethod
	public void ReinitialiseResultVar() {
		System.out.println("Im in Before Method"); 
		Result=0;
	}
 	
@Test(priority=1,groups= {"RegressionTest"})
public void TestAddition()
{
	System.out.println("Im in 1st Test Cases"); 
	Result=obj.Addition(10,20);
	Assert.assertEquals(Result,30,"Addition not worked");
}

@Test(priority=2,groups= {"RegressionTest"})
public void TestAdditionWithZero()
{
	System.out.println("Im in 2nd Test Cases"); 
	Result=obj.Addition(0,0);
	Assert.assertEquals(Result,0,"Addition not worked with Zero");
}

@AfterClass
public void Teardown() {
	
	System.out.println("Im in After class"); 
	obj=null;
}

}
