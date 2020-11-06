package samplePackage;
import org.apache.commons.lang3.RandomStringUtils;

public class restUtils {

	public static String getFirstName() {
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return("john" + generatedString);
		
		
	}

	public static String getLastName() {
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return("kendy" + generatedString);
		
		
	}
	public static String getUsername() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return("john" + generatedString);
		
		
	}
	public static String getPassword() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return("john" + generatedString);
		
		
	}
	public static String empName() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return("john" + generatedString);
		
		
	}
	public static String empSal() {
		String generatedString=RandomStringUtils.randomNumeric(5);
		return(generatedString);
		
		
	}
	public static String empAge() {
		String generatedString=RandomStringUtils.randomNumeric(3);
		return(generatedString);
		
		
	}
}