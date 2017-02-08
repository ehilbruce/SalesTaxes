package base;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import junit.framework.TestCase;

public class BaseTest extends TestCase {
	
	
private static boolean logIsInitialized = false;
	
	protected void setUp() throws Exception {
		System.out.println("BRUCEEEEEEEEEEEEEEEE");
//		if (!logIsInitialized) {
//			System.setProperty("log4j.defaultInitOverride", "true");
//			Properties props = new Properties();
////			props.setProperty("log4j.debug", "true");
//			props.setProperty("log4j.appender.A1", "org.apache.log4j.ConsoleAppender");
//			props.setProperty("log4j.rootLogger", "WARN, A1");
//			props.setProperty("log4j.appender.A1.layout", "org.apache.log4j.PatternLayout");
//			// livello(DEBUG,...) thread(...) NDC(utente) classe java(ultimi 40 char) messaggio newline
//			props.setProperty("log4j.appender.A1.layout.ConversionPattern", "%-5p [%t] %x %40c %m%n");	
//	
//			PropertyConfigurator.configure(props);
//			logIsInitialized = true;
//			
//		}
	}
	

	@Test
	public void testTest() {
		
		assertTrue(true);
	}
}
