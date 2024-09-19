package keywordsForAFKLM

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable




public class TakeScreenShots {




	public static String timeStampOnScreenShot() {
		LocalDateTime now = LocalDateTime.now()
		String day=now.getDayOfMonth()
		String date=now.getDayOfMonth()
		String month=now.getMonth()
		String year=now.getYear()

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a")
		String formattedTime = now.format(timeFormatter)

		String timeStamp=day+"-"+month+"-"+year+"_"+formattedTime.replaceAll(":", "-")
	}

	@Keyword
	public static void getScreenShotToSpecificLocation() {
		GlobalVariable.screenShotName=timeStampOnScreenShot()
		GlobalVariable.parentDirectory = ((RunConfiguration.getProjectDir() + '/') + 'ScreenShots') + '/'
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy")
		String currentDate = sdf.format(new Date())


		GlobalVariable.newFolderName = WebUI.getWindowTitle()
		GlobalVariable.folderPath =  GlobalVariable.parentDirectory  +currentDate +'/'+ GlobalVariable.newFolderName

		def newFolder = new File(GlobalVariable.folderPath)

		if (!(newFolder.exists())) {
			boolean result = newFolder.mkdirs()

			if (result) {
				println('Folder created successfully:' + newFolder)


				Thread.sleep(3000)

				moveScreenShotToFolder()
			} else {
				println('Failed to create folder: ' + newFolder)
			}
		} else {
			println('Folder already exists:' + newFolder)


			Thread.sleep(3000)
			moveScreenShotToFolder()
		}
	}


	public static void moveScreenShotToFolder() {


		GlobalVariable.folderPath+="/"+GlobalVariable.newFolderName+"_"+ GlobalVariable.screenShotName+".png"
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getWebDriver()
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE)
		KeywordUtil.logInfo("Screenshot get captured.")
		File destFile = new File(GlobalVariable.folderPath)
		FileUtils.copyFile(srcFile, destFile)
		KeywordUtil.logInfo("Screenshot saved in the folder successfully.")
	}
}
