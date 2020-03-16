import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('SAP/login/txt_sap_user'), GlobalVariable.user)

WebUI.setText(findTestObject('SAP/login/txt_sap_pass'), GlobalVariable.pass)

WebUI.click(findTestObject('SAP/login/ddwn_select_idioma'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SAP/login/ddwn_opcion_espanol'))

WebUI.click(findTestObject('SAP/login/btn_login'))

if (WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 10) == false) {
    WebUI.refresh()
}

