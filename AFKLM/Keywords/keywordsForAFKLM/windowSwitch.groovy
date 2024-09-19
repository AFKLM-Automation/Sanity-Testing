package keywordsForAFKLM

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class windowSwitch {

	@Keyword
	public static void switchToNewWindow() {

		// Store the current window handle
		String originalWindow = WebUI.getWindowIndex()

		// Switch to the new window (if you have multiple windows open)
		WebUI.switchToWindowIndex(1)
		KeywordUtil.logInfo("Driver switched to child window successfully.")
	}

	@Keyword
	public static void switchToMainWindow() {
		// Switch back to the original window
		WebUI.switchToWindowIndex(0)
		KeywordUtil.logInfo("Driver switched to main window.")
	}
}
