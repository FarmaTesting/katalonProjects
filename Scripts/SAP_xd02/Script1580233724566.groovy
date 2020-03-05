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

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 30)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nxd02')

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(3)

//WebUI.waitForElementVisible(findTestObject('SAP/xd02_mod_deudor/txt_buscador_deudor'), 30)
def nClienteModificar = findTestData('Clientes_xd02').getValue('param_cliente', 1)

WebUI.sendKeys(findTestObject('SAP/xd02_mod_deudor/txt_buscador_deudor'), nClienteModificar)

WebUI.sendKeys(findTestObject('SAP/xd02_mod_deudor/txt_buscador_deudor'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/xd02_mod_deudor/txt_nombre_deudor'), 30)

nombreDeudor = WebUI.getAttribute(findTestObject('SAP/xd02_mod_deudor/txt_nombre_deudor'), 'Value')

if (nombreDeudor == 'ORIEN S.A. SUCURSAL DAFLO.') {
    nombreDeudor = 'ORIEN S.A. SUCURSAL DAFLO'
} else {
    nombreDeudor = 'ORIEN S.A. SUCURSAL DAFLO.'
}

WebUI.delay(1)

WebUI.clearText(findTestObject('SAP/xd02_mod_deudor/txt_nombre_deudor'))

WebUI.sendKeys(findTestObject('SAP/xd02_mod_deudor/txt_nombre_deudor'), nombreDeudor)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/xd02_mod_deudor/txt_nombre_deudor'), Keys.chord(Keys.CONTROL, 's'))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/xd02_mod_deudor/btn_cerrar_popup_buscador_deudor'))

