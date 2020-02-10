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

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 10)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nse16n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscador_tablas'), 10)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), 'lips')

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_1_3_3_segunda_celda_filtro'), 15)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 15)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'vgbel')

WebUI.click(findTestObject('SAP/btn_ok'))

for (int i = 1; i <= findTestData('DGScenarios').getRowNumbers(); i++) {

    def nPedido089 = findTestData('DGScenarios').getValue('strNumPedidoSap89', i)

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), nPedido089)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    WebUI.delay(2)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
        def nEntrega1 = WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AR', i, 
            nEntrega1)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), Keys.chord(Keys.F3))
    } else {
        WebUI.click(findTestObject('SAP/txt_buscador_trx'))

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))
    }
    
    WebUI.clearText(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'))

    def nPedido101 = findTestData('DGScenarios').getValue('strNumPedidoSap101', i)

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), nPedido101)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    WebUI.delay(2)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
        def nEntrega2 = WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AX', i, 
            nEntrega2)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))
    } else {
        WebUI.click(findTestObject('SAP/txt_buscador_trx'))

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))
    }
    
    WebUI.clearText(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'))

    def nPedido106 = findTestData('DGScenarios').getValue('strNumPedidoSap106', i)

    WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), nPedido106)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    WebUI.delay(2)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
        def nEntrega3 = WebUI.getAttribute(findTestObject('Object Repository/SAP/txt_se16n_tabla_1ra_row'), 'value')

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AY', i, 
            nEntrega3)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))
    } else {
        WebUI.click(findTestObject('SAP/txt_buscador_trx'))

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))
    }
	
	WebUI.clearText(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'))
}

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))