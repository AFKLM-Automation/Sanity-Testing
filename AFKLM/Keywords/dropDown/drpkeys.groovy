package dropDown

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class drpkeys {
	@Keyword
	def selDrpVisibleText(TestObject drpElement, int timeout,String visibleText) {
		WebElement element =WebUI.findWebElement(drpElement, timeout)
		Select dropdown = new Select(element)
		dropdown.selectByVisibleText(visibleText)
	}

	@Keyword
	def selectDropdownByValue(TestObject drpElement, int timeout, String value) {
		WebElement element =WebUI.findWebElement(drpElement, timeout)
		Select dropdown = new Select(element)
		dropdown.selectByValue(value)
	}

	@Keyword
	def selectDropdownByIndex(TestObject drpElement,int timeout, int index) {
		WebElement element =WebUI.findWebElement(drpElement, timeout)
		Select dropdown = new Select(element)
		dropdown.selectByIndex(index)
	}
}
