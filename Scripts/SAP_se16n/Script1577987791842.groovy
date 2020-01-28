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

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 30)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nse16n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscador_tablas'), 30)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), 'vbak')

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), 30)

//WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), findTestData('DGScenarios').getValue('AS', 1))
WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), strFechaCreado)

//WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), findTestData('DGScenarios').getValue('AT', 1))
WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), strHoraCreado)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_4_tercera_celda_filtro'), CustomKeywords.'utilities.tools.sumarMinutos'(strHoraCreado))

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 30)

//WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'N° Interno')

//WebUI.click(findTestObject('SAP/btn_ok'))

//WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), strRefExterna)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'kunnr')

WebUI.click(findTestObject('SAP/btn_ok'))

//WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), findTestData('DGScenarios').getValue('AG', 1))
WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), strSolicitante)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 30)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'spart')

WebUI.click(findTestObject('SAP/btn_ok'))

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), strSector)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 30)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'zz_observacion_01')

WebUI.click(findTestObject('SAP/btn_ok'))

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), strObservacion)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))


WebUI.delay(5)

//strNumPedidoSap = WebUI.concatenate(((['000', WebUI.getAttribute(findTestObject('SAP/SAP_se16n_vbak/txt_n_pedido_sap'), 'Value')]) as String[]), FailureHandling.STOP_ON_FAILURE)

//strNumPedidoSap = WebUI.concatenate(((['000', 

//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AO', 1, strNumPedidoSap)

//WebUI.delay(2)
//
//WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/n')
//
//WebUI.delay(2)
//
//WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

