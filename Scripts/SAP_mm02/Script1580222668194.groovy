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

WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 30)

WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nmm02')

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/mm02_mod_producto/txt_n_material'), 30)

def nMaterialModificar = findTestData('Materiales_mm02').getValue('param_material', 1)

WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/txt_n_material'), nMaterialModificar)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/txt_n_material'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/mm02_mod_producto/txt_datos_base_1'), 30)

WebUI.delay(1)

WebUI.click(findTestObject('SAP/mm02_mod_producto/txt_datos_base_1'))

WebUI.delay(1)

//WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/txt_datos_base_1'), Keys.chord(Keys.LEFT))
//
//WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/btn_datos_base_1'), Keys.chord(Keys.ENTER))
//
//WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/mm02_mod_producto/btn_ok'), 30)

WebUI.click(findTestObject('SAP/mm02_mod_producto/btn_ok'))

WebUI.waitForElementVisible(findTestObject('SAP/mm02_mod_producto/txt_nombre_material'), 30)

nombreMod = WebUI.getAttribute(findTestObject('SAP/mm02_mod_producto/txt_nombre_material'), 'Value')

WebUI.delay(1)

if (nombreMod.contains('.')) {
    nombreMod = nombreMod.replace('.', '')
} else {
    nombreMod = (nombreMod + '.')
}

WebUI.clearText(findTestObject('SAP/mm02_mod_producto/txt_nombre_material'))

WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/txt_nombre_material'), nombreMod)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/mm02_mod_producto/txt_nombre_material'), Keys.chord(Keys.CONTROL, 's'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F3))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.TAB))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

