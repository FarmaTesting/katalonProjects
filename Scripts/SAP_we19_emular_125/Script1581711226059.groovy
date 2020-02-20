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

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nwe19')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/txt_idoc_a_buscar'), 10)

WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_idoc_a_buscar'), '11029547')

WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_idoc_a_buscar'), Keys.chord(Keys.F8))

if (WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo_pos2'), 10)) {
    WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo_pos2'))

    WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_borrar'))
}

def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()

println('Filas encontradas: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    def nRowEnEjecucion = i

    println('Ejecutando fila N: ' + nRowEnEjecucion)

    def mercEgresada = findTestData('DGScenarios').getValue('egreso_125', nRowEnEjecucion)

    println('Fue egresada?: ' + mercEgresada)

    if (mercEgresada != 'SI') {
        def nEntrega89 = findTestData('DGScenarios').getValue('out_n_entrega_89', nRowEnEjecucion)

        def nEntrega101 = findTestData('DGScenarios').getValue('out_n_entrega_101', nRowEnEjecucion)

        def nEntrega106 = findTestData('DGScenarios').getValue('out_n_entrega_106', nRowEnEjecucion)

        def nPosicion = '10'

        def nMaterial = findTestData('DGScenarios').getValue('param_materiales', nRowEnEjecucion)

        def nCantidad = findTestData('DGScenarios').getValue('param_cant_ingresar', nRowEnEjecucion)

        def nLote = findTestData('DGScenarios').getValue('out_lote', nRowEnEjecucion)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

        WebUI.delay(2)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega89)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo'))

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_posicion'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_posicion'), nPosicion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_material'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_material'), nMaterial)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_cantidad'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_cantidad'), nCantidad)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_n_lote'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_n_lote'), nLote)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_procesar'))

        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

        WebUI.delay(2)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

        WebUI.delay(1)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega101)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_procesar'))

        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

        WebUI.delay(2)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

        WebUI.delay(1)

        WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega106)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

        WebUI.delay(10)

        WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_procesar'))

        WebUI.delay(20)
		
		WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'BA', nRowEnEjecucion, 
            'SI')
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()