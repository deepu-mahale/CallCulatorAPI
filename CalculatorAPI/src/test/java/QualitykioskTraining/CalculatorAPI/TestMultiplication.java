package QualitykioskTraining.CalculatorAPI;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestMultiplication {
	Calculator Cal;
	int Result;
	
	@BeforeClass
	public void Init() {
		Cal = new Calculator();
	}
	
	@BeforeMethod
	public void Reinitialize() {
		Result=0;
	}
	
	@Test(priority=1,dataProvider="ProvidePositiveValue",groups= {"RegressionTest"} )
	public void TestMultiplicationWithPositiveValues(int num1, int num2, int ExpectedResult) {
		Result=Cal.Multiplication(num1, num2);
		Assert.assertEquals(Result, ExpectedResult,"Multiplication does not worked");
	}
	
	@DataProvider
	public Object[][] ProvidePositiveValue() {
		Object [][] SetOfValues=new Object[3][3];
		//SET1
		SetOfValues [0][0]=1;
		SetOfValues [0][1]=2;
		SetOfValues [0][2]=2;
		
		//SET2
		SetOfValues [1][0]=10;
		SetOfValues [1][1]=20;
		SetOfValues [1][2]=200;
		
		//SET3
		SetOfValues [2][0]=1000;
		SetOfValues [2][1]=2000;
		SetOfValues [2][2]=2000000;
		
		return SetOfValues;


	}
	
	@BeforeSuite
	@Parameters({"RequestID"})
	public void CreateResultFolder(String RequestID) {
		
		System.out.println("I am in Before Suite");
		try {
			Files.createDirectories(Paths.get("./"+RequestID));

		}
		catch (IOException e) {
			System.out.println("problem in result directory");
		}
	}
	
	@Parameters({"RequestID"})
	@AfterSuite
	public void CopyResultFile(String RequestID) {
		System.out.println("I am in After suite");
		try {
			Files.copy(Paths.get(""), Paths.get("./CreatedPath/Result.html"), StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException e){
			System.out.println("Problem in copying Result file");

		}
	}
}
