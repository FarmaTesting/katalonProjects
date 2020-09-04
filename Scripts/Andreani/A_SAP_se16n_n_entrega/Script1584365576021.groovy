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

row_control = findTestData('control_jobs_Andreani').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' ********************')

for (int i = 1; i <= row_control; i++) {
    SAP_01_se16n_obtener_n_entrega = findTestData('control_jobs_Andreani').getValue('SAP_01_se16n_obtener_n_entrega', i)

    println(('****************** REGISTRO N: ' + i) + ' ********************')

    if (SAP_01_se16n_obtener_n_entrega == 'false') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        /*def nRowsEncontradas = findTestData('DG_Andreani').getRowNumbers()
println('Filas encontradas: ' + nRowsEncontradas)
WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 10)
WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nse16n')
WebUI.delay(1)
WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 10)*/
        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'lips')

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

        WebUI.delay(1)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 15)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(1)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 15)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'vgbel')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        //for (int i = 1; i <= findTestData('DG_Andreani').getRowNumbers(); i++) {
        def nRowEnEjecucion = i

        println('Ejecutando fila N: ' + nRowEnEjecucion)

        //********************************Busca el entrega 89 *******************************//
        def nPedido089 = findTestData('DG_Andreani').getValue('strNumPedidoSap89', i)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), nPedido089)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        if (WebUI.verifyElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
            def nEntrega1 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')
			
			cero = '00'

            println('Num entrega 089: ' + nEntrega1)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 
                'AR', i, cero+nEntrega1)

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), Keys.chord(Keys.F3))
        } else {
            WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        }
        
        //*********************************************************************************//
        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

        //********************************Busca el entrega 101 *******************************//
        def nPedido101 = findTestData('DG_Andreani').getValue('strNumPedidoSap101', i)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), nPedido101)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        if (WebUI.verifyElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
            def nEntrega2 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')
			
			cero = '00'

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 
                'AX', i, cero+nEntrega2)

            println('Num entrega 101: ' + nEntrega2)

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))
        } else {
            WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        }
        
        //*********************************************************************************//
        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

        //********************************Busca el entrega 106 *******************************//
        def nPedido106 = findTestData('DG_Andreani').getValue('strNumPedidoSap106', i)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), nPedido106)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        if (WebUI.verifyElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
            def nEntrega3 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')
			cero = '00'

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 
                'AY', i, cero+nEntrega3)

            println('Num entrega 106: ' + nEntrega3)

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))
        } else {
            WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        }
        
        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

        WebUI.delay(1)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'control_jobs', 'E', 
            i, 'true')

        WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    } else if ((SAP_01_se16n_obtener_n_entrega == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}