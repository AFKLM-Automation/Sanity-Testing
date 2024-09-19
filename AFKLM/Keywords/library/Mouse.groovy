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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class Mouse {

	@Keyword
	def static void LClick(TestObject element) {
		try {
			WebUI.click(element)
			KeywordUtil.logInfo("Left Click on"+element+"successful")
		} catch (Exception e) {
			println("Failed to left click on element: ${e.message}")
			KeywordUtil.logInfo("Failed to left click on element: ${e.message}")
		}
	}

	@Keyword
	def static void RClick(TestObject element) {
		try {

			WebUI.rightClick(element, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.logInfo("Right Click on"+element+"successful")
		} catch (Exception e) {
			println("Failed to Right click on element: ${e.message}")
			KeywordUtil.logInfo("Failed to Right click on element: ${e.message}")
		}
	}

	@Keyword
	def static void DClick(TestObject element) {
		try {
			WebUI.doubleClick(element, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.logInfo("Double Click on"+element+"successful")
		} catch (Exception e) {
			println("Failed to double click on element: ${e.message}")
			KeywordUtil.logInfo("Failed to double click on element: ${e.message}")
		}
	}

	@Keyword
	def static void mouseHoverOver(TestObject element) {
		try {
			WebUI.mouseOver(element)
			KeywordUtil.logInfo("Mouse Hover Over on"+element+"successful")
		} catch (Exception e) {
			println("Failed to hover over element: ${e.message}")
			KeywordUtil.logInfo("Failed to mouse hover over an element: ${e.message}")
		}
	}


	@Keyword
	def static void clickAtCoordinates(TestObject element, int x, int y) {
		try {
			WebUI.clickOffset(element, x, y)
			KeywordUtil.logInfo("click At Coordinateon "+element+"Offset cordinate"+x+"_"+y+"successful")
		} catch (Exception e) {
			println("Failed to click at coordinates: ${e.message}")
			KeywordUtil.logInfo("Failed to click at coordinates: ${e.message}")
		}
	}


	@Keyword
	def static void Dragdrop(TestObject dragElement,TestObject dropElement ) {
		try {
			WebUI.dragAndDropToObject(dragElement, dropElement)
			KeywordUtil.logInfo("The "+dragElement+"Element drag from here and drop here"+dropElement+"successful")
		} catch (Exception e) {
			println("Failed to dragElement and dropElement: ${e.message}")
			KeywordUtil.logInfo("Failed to dragElement and dropElement: ${e.message}")
		}
	}

	@Keyword
	def static void ScrollToElement(TestObject Element,int timeout) {
		try {
			WebUI.scrollToElement(Element, timeout, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.logInfo("The Scroll To "+Element+"Element successfull")
		} catch (Exception e) {
			println("Failed to Scroll To Element: ${e.message}")
			KeywordUtil.logInfo("Failed to Scroll To Element: ${e.message}")
		}
	}
}




