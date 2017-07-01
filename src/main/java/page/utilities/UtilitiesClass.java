package page.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UtilitiesClass {
	static Logger log=Logger.getLogger(UtilitiesClass.class.getName());

	// Checks three times in case DOM operation happening on the page is temporarily causing the element to be inaccessible
	public static void lowRiskClick(WebElement element) {
		PropertyConfigurator.configure(UtilitiesClass.class.getResourceAsStream("/log4j.properties"));
		boolean result=false;
		int attempts=0;
		while(attempts<3 && !result){
			try{
			attempts++;
			log.debug("Attempt No: "+attempts+" for element "+element.toString().split("-> ")[1].replace("]", ""));
			element.click();
			result=true;
			break;
			}
			catch(Exception e){
				log.error(e.getMessage());
				if(attempts==3){
					Assert.assertFalse(true);
				}
			}
		}
	}
	
	// Checks three times in case DOM operation happening on the page is temporarily causing the element to be inaccessible
	public static void lowRiskSendKeys(WebElement element, String text){
		PropertyConfigurator.configure(UtilitiesClass.class.getResourceAsStream("/log4j.properties"));
		boolean result=false;
		int attempts=0;
		while(attempts<4 && !result){
			try{
			attempts++;
			log.debug("Attempt No: "+attempts+" for element "+element.toString().split("-> ")[1].replace("]", ""));
			element.sendKeys(text);
			result=true;
			break;
			}
			catch(Exception e){
				log.error(e.getMessage());
				if(attempts==3){
					Assert.assertFalse(true);
				}
			}
		}
	}
	
}
