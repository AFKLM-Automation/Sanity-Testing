import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('CustomerMasterr/CustomerMaster'), [('MasterName') : 'Customer Master'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterCustomerCode'), 'EGS251')

WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/searchCustomer/searchBtn'))

// Define TestObjects for the messages
TestObject noRecordsMessage = new TestObject('NoRecordsMessage')

noRecordsMessage.addProperty('xpath', ConditionType.EQUALS, '//span[contains(text()," 0 records found")]')

TestObject oneRecordMessage = new TestObject('OneRecordMessage')

oneRecordMessage.addProperty('xpath', ConditionType.EQUALS, '//span[contains(text()," 1 records found")]')

// Wait for the page to load
WebUI.waitForPageLoad(10)

// Check for "0 records found"
if (WebUI.verifyElementPresent(noRecordsMessage, 5, FailureHandling.OPTIONAL)) {
    println('No records found.') 
	CustomKeywords.'keywordsForAFKLM.TakeScreenShots.getScreenShotToSpecificLocation'()
	
} else if (WebUI.verifyElementPresent(oneRecordMessage, 5, FailureHandling.OPTIONAL)) {
    println('1 record found.')
	CustomKeywords.'keywordsForAFKLM.TakeScreenShots.getScreenShotToSpecificLocation'()

	// Define the TestObject for the table
    TestObject table = findTestObject('Object Repository/AF DET ENV/Customer Master/searchCustomer/tableForSearchRecord')
	// Wait for the table to be present
    WebUI.waitForElementPresent(table, 10)
	// Fetch column headers
 TestObject headerTestObject = findTestObject('Object Repository/AF DET ENV/Customer Master/searchCustomer/tableHeaderXpath')
    List<WebElement> headers = WebUI.findWebElements(headerTestObject,10)

  
	// Fetch rows (excluding the header row)
	TestObject rowTestObject = findTestObject('Object Repository/AF DET ENV/Customer Master/searchCustomer/tableRowXpath')
	 List<WebElement> rows = WebUI.findWebElements(rowTestObject,10)

   

    for (WebElement row : rows) {
        List<WebElement> columns = row.findElements(By.xpath('./td'))

        columns.eachWithIndex({ WebElement column, int colIndex ->
                if (colIndex < headers.size()) {
                    String headerText = (headers[colIndex]).getText()

                    String columnText = column.getText()

                    println("$headerText: $columnText")
                }
            })
    }
} else {
    println('The expected web element were not found.')
}




