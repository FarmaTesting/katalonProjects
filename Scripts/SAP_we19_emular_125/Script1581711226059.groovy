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

row_control = findTestData('DGScenarios').getRowNumbers()

println(('***************** CANTIDAD DE REGISTROS: ' + row_control) + ' *****************')

for (int i = 1; i <= row_control; i++) {
    SAP_06_se19_ws_125 = findTestData('control_jobs').getValue('SAP_06_se19_ws_125', i)

    println(('********************** REGISTRO N: ' + i) + ' **********************')

    if (SAP_06_se19_ws_125 == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nwe19'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_idoc_a_buscar'), '11029547')

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_idoc_a_buscar'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        if (WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo_pos2'), 10)) {
            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo_pos2'))

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_borrar'))
        }
        
        def nRowEnEjecucion = i

        def mercEgresada = findTestData('DGScenarios').getValue('egreso_125', nRowEnEjecucion)

        if (mercEgresada == 'NO') {
            def nEntrega89 = findTestData('DGScenarios').getValue('out_n_entrega_89', nRowEnEjecucion)

            def nEntrega101 = findTestData('DGScenarios').getValue('out_n_entrega_101', nRowEnEjecucion)

            def nEntrega106 = findTestData('DGScenarios').getValue('out_n_entrega_106', nRowEnEjecucion)

            def nPosicion = '10'

            def nMaterial = findTestData('DGScenarios').getValue('param_materiales', nRowEnEjecucion)

            def nCantidad = findTestData('DGScenarios').getValue('param_canti_pedido', nRowEnEjecucion)

            def nLote = findTestData('DGScenarios').getValue('out_lote', nRowEnEjecucion)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

            WebUI.delay(2)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega89)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(2)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cuerpo'))

            WebUI.delay(1)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_posicion'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_posicion'), nPosicion)

            WebUI.delay(1)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_material'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_material'), nMaterial)

            WebUI.delay(1)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_cantidad'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_cantidad'), nCantidad)

            WebUI.delay(1)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_n_lote'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_n_lote'), nLote)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

            WebUI.delay(2)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'), 25)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(15)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

            WebUI.delay(4)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

            WebUI.delay(2)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega101)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

            WebUI.delay(2)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'), 25)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(15)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

            WebUI.delay(4)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'))

            WebUI.delay(2)

            WebUI.clearText(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_c_n_entrega'), nEntrega106)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('Object Repository/SAP/se19_ws_125/txt_info_cabecera'), Keys.chord(Keys.F8))

            WebUI.delay(2)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok'))

            WebUI.delay(15)

            WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'), 10)

            WebUI.delay(1)

            WebUI.click(findTestObject('Object Repository/SAP/se19_ws_125/btn_ok_confirmar_proceso'))

            WebUI.delay(1)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'BA', 
                nRowEnEjecucion, 'SI')
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'J', i, 'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

    } else if ((SAP_06_se19_ws_125 == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}