import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('SSO Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/AF DET ENV/AF DET'))

CustomKeywords.'keywordsForAFKLM.windowSwitch.switchToNewWindow'()
//if (WebUI.verifyElementPresent(findTestObject('Object Repository/AF DET ENV/alreadyLogin Popup-yesBtn'), 1000)) {
//    WebUI.click(findTestObject('Object Repository/AF DET ENV/alreadyLogin Popup-yesBtn'))
//}

TestObject yesBtnPopp=findTestObject('Object Repository/AF DET ENV/alreadyLogin Popup-yesBtn')
if(WebUI.verifyElementPresent(yesBtnPopp, 5, FailureHandling.OPTIONAL)) {
	println('User is already login.')
	CustomKeywords.'keywordsForAFKLM.TakeScreenShots.getScreenShotToSpecificLocation'()
	WebUI.click(yesBtnPopp)
}
