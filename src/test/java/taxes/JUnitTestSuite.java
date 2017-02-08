package taxes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import base.BaseTest;
import base.TaxesReaderTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BaseTest.class,
   TaxesReaderTest.class
})

public class JUnitTestSuite {

}
