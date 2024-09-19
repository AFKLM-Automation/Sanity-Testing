package library


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW



public class Action {

	@Keyword
	def static void sendKeysToElement(TestObject element,String Value ) {
		try {
			WebUI.sendKeys(element, Value)
			KeywordUtil.logInfo("The "+Value+" is succesfully enter to"+element+"field")
		} catch (Exception e) {
			println("Failed to send keys to element: ${e.message}")
		}
	}

	@Keyword
	def static String getText(TestObject element,int timeout) {
		try {
			WebUI.waitForElementVisible(element,timeout )
			return WebUI.getText(element)
			KeywordUtil.logInfo("The"+element+"Text Get Sussesfully")
		} catch (Exception e) {
			println("Failed to get text from element: ${e.message}")
			return null
		}
	}

	@Keyword
	static boolean setText(TestObject element, String text) {
		try {
			WebUI.setText(element, text)
			return true
			KeywordUtil.logInfo("The"+text+"is Sussesfully set in"+element+"field")
		} catch (Exception e) {
			println("Failed to set text: ${e.message}")
			return false
		}
	}

	@Keyword
	static boolean setEncryptedText(TestObject element, String text) {
		try {
			WebUI.setEncryptedText(element, text)
			return true
			KeywordUtil.logInfo("The"+text+" setEncryptedText is Sussesfully set in"+element+"Field")
		} catch (Exception e) {
			println("Failed to set text: ${e.message}")
			return false
		}
	}

	@Keyword
	def static int generateRandomNumber(int min, int max) {
		try {
			return (int) (Math.random() * ((max - min) + 1)) + min
			return true
		} catch (Exception e) {
			println("Failed to geratateRandomNumber: ${e.message}")
			return false
		}
	}

	@Keyword
	boolean selectAll(TestObject element) {
		try {
			WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'a'))
			return true
			KeywordUtil.logInfo("Select All "+element+" is Sussesfull")
		} catch (Exception e) {
			println("Failed to Select all: ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean Copy(TestObject element) {
		try {
			WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'c'))
			return true
			KeywordUtil.logInfo("Copy value "+element+" is Successfull")
		} catch (Exception e) {
			println("Failed to copy: ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean paste (TestObject element) {
		try {
			WebUI.sendKeys(element, Keys.chord(Keys.CONTROL, 'v'))
			return true
			KeywordUtil.logInfo("Past value "+element+" is Sussesfull")
		} catch (Exception e) {
			println("Failed to past : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean copyPaste (TestObject copyElement,TestObject pastElement) {
		try {
			WebUI.sendKeys(copyElement, Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(copyElement, Keys.chord(Keys.CONTROL, 'c'))
			WebUI.sendKeys(pastElement, Keys.chord(Keys.CONTROL, 'v'))
			return true
			KeywordUtil.logInfo("Copy value "+copyElement+" is Sussesfull" + "Past value "+pastElement+" is Sussesfull")
		} catch (Exception e) {
			println("Failed to Copy Past : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean pressEnter () {
		try {
			WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
			return true
			KeywordUtil.logInfo("Press Enter Keys Successfully")
		} catch (Exception e) {
			println("Failed to press Enter button : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean pressTab () {
		try {
			WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
			return true
			KeywordUtil.logInfo("Press TAB Key Successfully")
		} catch (Exception e) {
			println("Failed to press tab button : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean pressPageup () {
		try {
			WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_UP))
			return true
			KeywordUtil.logInfo("Press Pageup Key Successfully")
		} catch (Exception e) {
			println("Failed to press pageUp button : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}

	@Keyword
	boolean pressPagedown () {
		try {
			WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN))
			return true
			KeywordUtil.logInfo("Press Pagedown Key Successfully")
		} catch (Exception e) {
			println("Failed to press pageUp button : ${e.getMessage()}")
			e.printStackTrace()
			return false
		}
	}
}

