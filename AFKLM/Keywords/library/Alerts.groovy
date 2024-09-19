package library

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil



public class Alerts {

	//	static void log(String message) {
	//		KeywordUtil.logInfo(message)
	//	}

	@Keyword
	def static String getAlertText() {
		try {
			return DriverFactory.getWebDriver().switchTo().alert().getText()
			KeywordUtil.logInfo("Get alert text Successful")
		} catch (Exception e) {
			println("Failed to get alert text: ${e.message}")
			return null
			KeywordUtil.logInfo("Failed to get alert text: ${e.message}")
		}
	}

	@Keyword
	def static void acceptAlert() {
		try {
			DriverFactory.getWebDriver().switchTo().alert().accept()
			KeywordUtil.logInfo("Accept the alert Successful")
		} catch (Exception e) {
			println("Failed to accept alert: ${e.message}")
			KeywordUtil.logInfo("Failed to accept alert: ${e.message}")
		}
	}

	@Keyword
	def static void dismissAlert() {
		try {
			DriverFactory.getWebDriver().switchTo().alert().dismiss()
			KeywordUtil.logInfo("Dismiss the Alert Successful")
		} catch (Exception e) {
			println("Failed to dismiss alert: ${e.message}")
			KeywordUtil.logInfo("Failed to accept alert: ${e.message}")
		}
	}
}



// Check With Time

//public class Log {
//	@Keyword
//	def static void logMessage(String message) {
//		KeywordLogger log = new KeywordLogger()
//		log.logInfo(message)
//	}
//}
//
//
//// use
//
//// Example test case using custom keyword for logging
//logMessage("Starting test case...")
//// Perform actions and validations
//logMessage("Test case completed.")

