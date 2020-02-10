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

for (int i = 1; i <= findTestData('DGScenarios').getRowNumbers(); i++) {
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

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), findTestData('DGScenarios').getValue('strFechaCreado', 
            i))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), findTestData('DGScenarios').getValue('strHoraCreado', 
            i))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_4_tercera_celda_filtro'), CustomKeywords.'utilities.tools.sumarMinutos'(
            findTestData('DGScenarios').getValue('strHoraCreado', i)))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 30)

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'augru')

    WebUI.click(findTestObject('SAP/btn_ok'))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), '002')

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AO', i, WebUI.concatenate('000',WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')))

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

    WebUI.clearText(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), '198')

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AP', i, WebUI.concatenate('000',WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')))

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

    WebUI.clearText(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'))

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), '139')

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AQ', i, WebUI.concatenate('000',WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')))

    WebUI.delay(10)
}

