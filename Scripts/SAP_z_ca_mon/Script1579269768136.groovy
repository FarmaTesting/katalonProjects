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

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 30)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_ca_mon')

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/general/txt_id_interfaz'), 30)

WebUI.sendKeys(findTestObject('SAP/general/txt_id_interfaz'), 'WB-000089')

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(5)

WebUI.click(findTestObject('SAP/monitor_z_ca_mon/Page_Monitor de interfaces Gestin de transacciones/span_Hora ejec'))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/monitor_z_ca_mon/Page_Monitor de interfaces Gestin de transacciones/img_Transacciones seleccionadas__SORT_DSC14124-img'))

WebUI.delay(1)

strRefExterna = WebUI.getAttribute(findTestObject('SAP/monitor_z_ca_mon/Page_Monitor de interfaces Gestin de transacciones/table_Transacciones seleccionadasID interfazVarianteID ejecNtransEstado'), 
    'Value')

CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AN', 1, strRefExterna)

