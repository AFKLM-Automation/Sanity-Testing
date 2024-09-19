package library


import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory



public class FullpageSS {



	@Keyword
	def takeFullPageScreenshot(String filePath) {
		WebDriver driver = DriverFactory.getWebDriver()

		// Create a screenshot using AShot
		Screenshot screenshot = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver)

		// Save the screenshot to the specified file path
		ImageIO.write(screenshot.getImage(), "PNG", new File(filePath))
		KeywordUtil.logInfo("Take FullPage Screenshot on "+filePath+ "location")
	}
}
