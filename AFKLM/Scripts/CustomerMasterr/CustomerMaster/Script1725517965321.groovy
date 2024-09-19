import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('AF DET Env'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/search'))
WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterSearchText'))
String SearchName="Customer Master"
WebUI.sendKeys(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterSearchText'), SearchName)
WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterMasterName',[('masterName'):SearchName]))



