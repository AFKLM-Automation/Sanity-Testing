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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class FileUpload {


	@Keyword
	def static boolean uploadFile(TestObject uploadButton, String filePath) {
		try {
			WebUI.uploadFile(uploadButton, filePath)
			return true
			KeywordUtil.logInfo("The File from"+filePath+" successfully Uploaded" )
		} catch (Exception e) {
			println("Failed to upload file: ${e.message}")
			return false
		}
	}
}


//	// Example test case using custom keywords
//	//	TestObject uploadButton = findTestObject('your_upload_button_id')
//	//	String filePath = 'path/to/upload/file.txt'
//	//	boolean uploadResult = CustomKeywords.uploadFile(uploadButton, filePath)
//	//	println("File upload result: ${uploadResult}")

