import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('CustomerMasterr/searchCustomer'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/searchCustomer/existCustomerDataCheckbox'))
WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/EditCustomer/editBtn'))

TestObject customerField=findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/dropDownOfCustomerType')
Boolean isDisabledCustomerTypeField = WebUI.verifyElementAttributeValue(customerField, 'disabled', 'true', 0)
println isDisabledCustomerTypeField
if(isDisabledCustomerTypeField) {
	
	println "Customer Type dropdown is disabled"
}
else {
	println "Customer Type dropdown is clickable"
}

TestObject customerCodeField=findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterCustomerCode')
Boolean isDisabledCustomerCodeField = WebUI.verifyElementAttributeValue(customerCodeField, 'readonly', 'true', 0)
println isDisabledCustomerCodeField
if(isDisabledCustomerCodeField) {

	println "Customer code filed is disabled"
}
else {
	println "Customer code field is clickable"
}

TestObject customerNameField=findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterCustomerName')
Boolean isClickableCustomerNameField = WebUI.verifyElementClickable(customerNameField)
println isClickableCustomerNameField
if(isClickableCustomerNameField) {
	WebUI.clearText(customerNameField)
	WebUI.sendKeys(customerNameField, 'Virat Agency')
}


TestObject customerAddressField=findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterAddress1')
Boolean isClickableCustomerAddressField = WebUI.verifyElementClickable(customerAddressField)
println isClickableCustomerAddressField
if(isClickableCustomerAddressField) {
	WebUI.clearText(customerAddressField)
	WebUI.sendKeys(customerAddressField, 'MALESHIA')
}

TestObject customerCurrencyField=findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/searchBtnOfCurrency')
Boolean isClickableCustomerCurrencyField = WebUI.verifyElementClickable(customerCurrencyField)
println isClickableCustomerCurrencyField
if(isClickableCustomerCurrencyField) {
	
	WebUI.click(findTestObject("Object Repository/AF DET ENV/Customer Master/createNewCustomer/searchBtnOfCurrency"))
	WebUI.clearText(findTestObject("Object Repository/AF DET ENV/createNewCustomer/enterCurrencyCodes"),FailureHandling.OPTIONAL)
	WebUI.sendKeys(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/enterCurrencyCode'), 'ANG')
	
	WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/searchCurrencyBtn'))
	
	def currencyValue = 'ANG'
	
	WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/selectCurrencyFromTable', [('currencyValue') : currencyValue]))
	CustomKeywords.'keywordsForAFKLM.TakeScreenShots.getScreenShotToSpecificLocation'()
	WebUI.scrollToElement(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/SaveAndCloseBtn'), 0)
	WebUI.click(findTestObject('Object Repository/AF DET ENV/Customer Master/createNewCustomer/SaveAndCloseBtn'))
}




WebUI.closeBrowser()