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
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable


public class Verify {

	@Keyword
	static boolean verifyElementText(TestObject element, String expectedText) {
		try {
			String actualText = WebUI.getText(element)
			if (actualText.equals(expectedText)) {
				WebUI.comment('Text is correct.')
				return true
				KeywordUtil.logInfo(element.getObjectId() + " Text is correct: " + actualText)
			} else {
				WebUI.comment('Text is incorrect. Expected: ' + expectedText + ', but got: ' + actualText)
				return false
				KeywordUtil.logInfo(element.getObjectId() + " Text is incorrect. Expected: " + expectedText + ", but got: " + actualText)
			}
		} catch (Exception e) {
			WebUI.comment("An error occurred while verifying text: ${e.message}")
			return false
			KeywordUtil.logInfo("An error occurred while verifying text of element: " + element.getObjectId())
		}
	}

	@Keyword
	static boolean compareText(String actual, String expected, String elementName) {
		try {
			if (actual.equals(expected)) {
				KeywordUtil.markPassed("Text matches the expected value.")
				println(elementName + " matches with the actual text: " + actual + " and expected text: " + expected)
				KeywordUtil.logInfo("Actual text: " + actual + " matches with the expected text: " + expected)
			} else {
				KeywordUtil.markFailed("Text does not match the expected value. Actual: '${actual}', Expected: '${expected}'")
				println(elementName + " does not match with the actual text: " + actual + " and expected text: " + expected)
				KeywordUtil.logInfo("Actual text: " + actual + " does not match with the expected text: " + expected)
			}
			return true
		} catch (Exception e) {
			println("Failed to compare text in class: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to compare text in class")
		}
	}


	@Keyword
	static boolean verifyElementHasClass(TestObject element, int timeout, String expectedClass) {
		try {
			WebUI.waitForElementVisible(element, timeout)
			String actualClasses = WebUI.getAttribute(element, 'class')
			return actualClasses.contains(expectedClass)
		} catch (Exception e) {
			println("Failed to verify element class: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to verifyElementHasClass" + element.getObjectId())
		}
	}

	@Keyword
	static boolean verifyElementPresent(TestObject element, int timeout) {
		try {
			WebUI.waitForElementPresent(element, timeout)
			return true
			KeywordUtil.logInfo("The" +element+" Is present on the screen")
		} catch (Exception e) {
			println("Element is not present: ${e.message}")
			return false
			KeywordUtil.logInfo("Element is not presen" + element.getObjectId())
		}
	}


	@Keyword
	def static boolean verifyElementVisible(TestObject Element,int timeout) {
		try {
			WebUI.waitForElementVisible(Element, timeout)
			return true
			KeywordUtil.logInfo("The" +Element+" Is Visible on the screen")
		} catch (Exception e) {
			println("Element is not visible: ${e.message}")
			return false
			KeywordUtil.logInfo("Element is Visible" + Element.getObjectId())
		}
	}

	@Keyword
	static boolean verifyPageTitle(TestObject element, int timeout, String expectedTitle) {
		try {
			WebUI.verifyElementPresent(element, timeout, FailureHandling.STOP_ON_FAILURE)
			String actualTitle = WebUI.getText(element)
			return actualTitle == expectedTitle
			KeywordUtil.logInfo("The Page Title " +element+" Is match with the"+expectedTitle+"Expected titel")
		} catch (Exception e) {
			println("Failed to verify page title: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to verify page title" + element.getObjectId())
		}
	}

	@Keyword
	static boolean verifyAllLinksOnCurrentPageAccessible() {
		try {
			WebUI.verifyAllLinksOnCurrentPageAccessible(false, null)
			return true
			KeywordUtil.logInfo("All links On the current page are visible")
		} catch (Exception e) {
			println("Failed to verify links on the current page: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to verify links on the current page")
		}
	}

	@Keyword
	def static boolean verifyElementCssProperty(TestObject element, String propertyName, String expectedValue) {
		try {
			String actualValue = WebUI.getCSSValue(element, propertyName)
			return actualValue == expectedValue
		} catch (Exception e) {
			println("Failed to verify element CSS property: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to verify element CSS property" + element.getObjectId())
		}
	}

	@Keyword
	def static boolean verifyElementFontSize(TestObject element, int expectedFontSize) {
		try {
			String fontSize = WebUI.getCSSValue(element, 'font-size')
			int actualFontSize = Integer.parseInt(fontSize.replaceAll('[^\\d.]', ''))
			return actualFontSize == expectedFontSize
			KeywordUtil.logInfo("The font size of "+element+" is match with"+ expectedFontSize)
		}
		catch (Exception e) {
			println("Failed to verify element font size: ${e.message}")
			return false
			KeywordUtil.logInfo("Failed to verify the font size of the element: " + element.getObjectId())
		}
	}

	@Keyword
	static boolean verifyPageURL(String expectedURL) {
		try {
			String actualURL = WebUI.getUrl()
			if (expectedURL.equals(actualURL)) {
				WebUI.comment("The expected URL matches the actual URL: " + actualURL)
				return true
				KeywordUtil.logInfo("The page URL is match with this URL" +actualURL+"With this " + expectedURL)
			} else {
				throw new StepFailedException("The expected URL does not match the actual URL. Expected: " + expectedURL + ", but found: " + actualURL)
			}
		} catch (Exception e) {
			WebUI.comment("The expected URL does not match the actual URL: ${e.message}")
			return false
			KeywordUtil.logInfo("The expected URL does not match the actual UR " + expectedURL)
		}
	}

	@Keyword
	static boolean verifyPartialPageURL(String partialURL) {
		try {
			String actualURL = WebUI.getUrl()
			if (actualURL.contains(partialURL)) {
				WebUI.comment("The actual URL contains the expected partial URL: " + partialURL)
				println('Actual URL matches with expected URL')
				return true
				KeywordUtil.logInfo("The page URL is match with actualURL this" +actualURL+"With this " + partialURL)
			} else {
				throw new StepFailedException("The actual URL does not contain the expected partial URL. Expected part: " + partialURL + ", but found: " + actualURL)
			}
		} catch (Exception e) {
			WebUI.comment("An error occurred while verifying the partial URL: ${e.message}")
			return false
			KeywordUtil.logInfo("An error occurred while verifying the partial URL " + partialURL)
		}
	}

	@Keyword
	static boolean elementToVerifyFontSize(TestObject element, int elementExpectedFontSize) {
		try {
			int expectedFontSize = elementExpectedFontSize
			boolean fontSizeVerificationResult =  verifyFontSize(element, expectedFontSize)
			if (fontSizeVerificationResult) {
				WebUI.comment('Font size is correct.')
				return true
				KeywordUtil.logInfo(element.getObjectId() + " Font size is correct")
			} else {
				WebUI.comment('Font size is incorrect.')
				return false
				KeywordUtil.logInfo(element.getObjectId() + " Font size is incorrect")
			}
		} catch (Exception e) {
			WebUI.comment("An error occurred while verifying FontSize: ${e.message}")
			return false
			KeywordUtil.logInfo("An error occurred while verifying FontSize of element: " + element.getObjectId())
		}
	}


	@Keyword
	public static boolean verifyFontSize(TestObject element, int expectedFontSize) {
		try {
			String fontSizeStr = WebUI.getCSSValue(element, 'font-size')
			int actualFontSize = Integer.parseInt(fontSizeStr.replaceAll("px", "").trim())
			return actualFontSize == expectedFontSize
			WebUI.comment('Font size is correct.')
			KeywordUtil.logInfo(element.getObjectId() + " Font size is correct")
		} catch (Exception e) {
			WebUI.comment("An error occurred while getting the font size: ${e.message}")
			return false
			KeywordUtil.logInfo("An error occurred while verifying FontSize of element: " + element.getObjectId())
		}
	}




	@Keyword
	public static boolean ElementClickable(TestObject element) {
		try {

			if (WebUI.verifyElementClickable(element)) {
				WebUI.comment('Button is clickable')
			} else {
				WebUI.comment('Button is not clickable')
			}
		} catch (Exception e) {
			WebUI.comment("An error occurred while verify Element Clickable: ${e.message}")
			return false
			KeywordUtil.logInfo("An error occurred while verify Element Clickable: " + element.getObjectId())
		}
	}


	@Keyword
	public static void CompareText(TestObject actualTextE, String ExpectedTextE) {
		try {
			String actualText = actualTextE
			String expectedText = ExpectedTextE
			if (actualText == expectedText) {
				KeywordUtil.markPassed("The actual text matches the expected text.")
				KeywordUtil.logInfo("The actual text match the expected text:"+actualText+ ", Expected:"+expectedText)
			} else {
				KeywordUtil.markFailed("The actual text does not match the expected text. Actual: " + actualText + ", Expected: " + expectedText)
			}
		}
		catch (Exception e) {
			WebUI.comment("An error occurred while Comparing text : ${e.message}")
			KeywordUtil.logInfo("An error occurred while verify comparing text" )
		}
	}
}




