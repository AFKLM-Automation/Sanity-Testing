package library
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

class SerialNumberGenerator {
	private static int serialNumber = 1
	static String getNextSerialNumber() {
		return String.format("%04d", serialNumber++)
	}
}

public class TakeScreenshot {

	@Keyword
	public void takeScreenshot(String fileName,String FolderPath) {
		def driver = DriverFactory.getWebDriver()
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
		String projectDir = RunConfiguration.getProjectDir()
		String screenshotsDir = projectDir + File.separator + "ScreenShots" + File.separator + FolderPath
		String serialNumber = SerialNumberGenerator.getNextSerialNumber()
		String filePath = screenshotsDir + File.separator + fileName + "_" + serialNumber + ".png"
		File screenshotsDirFile = new File(screenshotsDir)
		if (!screenshotsDirFile.exists()) {
			screenshotsDirFile.mkdirs()
		}
		FileUtils.copyFile(srcFile, new File(filePath))
	}


	// TakeScreenshot in modified folder with TimeStamp
	@Keyword
	public void takeScreenshotTimeStamp(String fileName,String FolderPath) {

		def driver = DriverFactory.getWebDriver()
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
		String projectDir = RunConfiguration.getProjectDir()
		String screenshotsDir = projectDir + File.separator + "ScreenShots" + File.separator + FolderPath
		String serialNumber = SerialNumberGenerator.getNextSerialNumber()
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd'D'_MM'M'_yyyy_'Y'")
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH'H'_mm'M'_ss'S'")
		String formatDate = dateFormat.format(new Date())
		String formatTime = timeFormat.format(new Date())
		String filePath = screenshotsDir + File.separator + fileName + "_" + serialNumber + "_Date_" + formatDate + "_Time_" + formatTime + ".png"
		File screenshotsDirFile = new File(screenshotsDir)
		if (!screenshotsDirFile.exists()) {
			screenshotsDirFile.mkdirs()
		}
		FileUtils.copyFile(srcFile, new File(filePath))
	}


	// Screenshot In save in present date with modified name with time stamp
	@Keyword
	public void takeScreenshotWithFolderTimeStamp(String fileName) {

		def driver = DriverFactory.getWebDriver()
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy")
		String currentDate = sdf.format(new Date())
		String projectDir = RunConfiguration.getProjectDir()
		String folderPath = projectDir + File.separator + "ScreenShots" + File.separator + currentDate
		File folder = new File(folderPath)
		if (!folder.exists()) {
			folder.mkdirs()
			println("Folder created: " + folderPath)
		} else {
			println("Folder already exists: " + folderPath)
		}
		String screenshotsDir=	folderPath

		// Define the directory and file path for the screenshot
		//		String projectDir = RunConfiguration.getProjectDir()
		//		String screenshotsDir = projectDir + File.separator + "ScreenShots" + File.separator + FolderPath

		String serialNumber = SerialNumberGenerator.getNextSerialNumber()
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd'D'_MM'M'_yyyy_'Y'")
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH'H'_mm'M'_ss'S'")
		String formatDate = dateFormat.format(new Date())
		String formatTime = timeFormat.format(new Date())
		String filePath = screenshotsDir + File.separator + fileName + "_" + serialNumber + "_Date_" + formatDate + "_Time_" + formatTime + ".png"
		File screenshotsDirFile = new File(screenshotsDir)
		if (!screenshotsDirFile.exists()) {
			screenshotsDirFile.mkdirs()
		}
		FileUtils.copyFile(srcFile, new File(filePath))
	}
}


