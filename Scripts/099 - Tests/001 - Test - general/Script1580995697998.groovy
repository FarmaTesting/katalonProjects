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

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 10)

WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nse37')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/vkm4/se37_ws_123/txt_modulo_funciones'), 10)

WebUI.sendKeys(findTestObject('SAP/vkm4/se37_ws_123/txt_modulo_funciones'), 'z_mm_andr_recepcion')

WebUI.sendKeys(findTestObject('SAP/vkm4/se37_ws_123/txt_modulo_funciones'), Keys.chord(Keys.F8))

WebUI.waitForElementPresent(findTestObject('SAP/vkm4/se37_ws_123/btn_posicion'), 15, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SAP/vkm4/se37_ws_123/btn_posicion'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('SAP/vkm4/se37_ws_123/txt_pos_moti'), 5)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/vkm4/se37_ws_123/txt_pos_moti'), '5678', FailureHandling.OPTIONAL)

WebUI.closeBrowser()

