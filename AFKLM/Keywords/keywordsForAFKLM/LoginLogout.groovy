package keywordsForAFKLM

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class LoginLogout {



	@Keyword
	public static void login() {
		KeywordUtil.logInfo("Login authentication get started..")
		WebUI.sendKeys(findTestObject("Object Repository/Login/username"),GlobalVariable.Username)
		Thread.sleep(1000)
		WebUI.click(findTestObject("Object Repository/Login/continueBtn"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/password"), GlobalVariable.Password)
		Thread.sleep(1000)
		WebUI.click(findTestObject("Object Repository/Login/loginBtn"))
		Thread.sleep(1000)
		KeywordUtil.logInfo("User logged in successfully.")
	}

	@Keyword
	public static void logout() {
		KeywordUtil.logInfo("User logout process get started..")
		WebUI.click(findTestObject("Object Repository/Logout/profile"))
		Thread.sleep(1000)
		WebUI.click(findTestObject("Object Repository/Logout/logoutBtn"))
		KeywordUtil.logInfo("User logged out successfully.")
	}
}
