package taxes;

import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import base.BaseTest;
import base.MathHelperTest;
import base.TaxesReaderTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BaseTest.class,
   TaxesReaderTest.class,
   MathHelperTest.class
})

public class JUnitTestSuite {

	 @BeforeClass
	 public static void setUp() {
		 	System.out.println("setting up");
			PropertyConfigurator.configure("log4j.properties");
	       
	 }

	 @AfterClass
	 public static void tearDown() {
	        System.out.println("tearing down");
	 }


}
