package keywordsForAFKLM

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class browser {

	@Keyword
	public static void openBrowser() {

		WebUI.openBrowser(GlobalVariable.URL)
		KeywordUtil.logInfo("Browser opened successfullly.")
		WebUI.waitForPageLoad(3000)
		WebUI.maximizeWindow();
	}

	@Keyword
	public static void closeBrowser() {
		Thread.sleep(2000)
		WebUI.closeBrowser()
		KeywordUtil.logInfo("Browser closed successfully.")
	}
}