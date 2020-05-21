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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

row_control = findTestData('DGScenarios').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' ********************')

for (int i = 1; i <= row_control; i++) {
    SAP_se16n_n_factura = findTestData('control_jobs').getValue('SAP_se16n_n_factura', i)

    println(('****************** REGISTRO N: ' + i) + ' ********************')

    if (SAP_se16n_n_factura == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'VBRP')

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

        WebUI.delay(1)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 15)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(1)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 10)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'vgbel')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        WebUI.delay(1)

        //********************************Busca la factura entrega 89 *******************************//
        nEntrega089 = findTestData('DGScenarios').getValue('out_n_entrega_89', i)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), nEntrega089)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5)

        factura = WebUI.verifyElementVisible(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), FailureHandling.OPTIONAL)

        msg_error = WebUI.verifyElementVisible(findTestObject('SAP/se16n/msg_error'), FailureHandling.OPTIONAL)

        if (factura) {
            nFactura089 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BG', i, nFactura089)

            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), Keys.chord(Keys.F3))
        } else if (msg_error) {
            msg = WebUI.getText(findTestObject('SAP/se16n/msg_error'))

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BG', i, msg)

            WebUI.refresh()

            WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

            WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_tablas'), [:], FailureHandling.STOP_ON_FAILURE)
        }
        
        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

        //********************************Busca la factura entrega 101 *******************************//
        nEntrega101 = findTestData('DGScenarios').getValue('out_n_entrega_101', i)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), nEntrega101)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5)

        factura = WebUI.verifyElementVisible(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), FailureHandling.OPTIONAL)

        msg_error = WebUI.verifyElementVisible(findTestObject('SAP/se16n/msg_error'), FailureHandling.OPTIONAL)

        if (factura) {
            nFactura101 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BH', i, nFactura101)
        } else if (msg_error) {
            msg = WebUI.getText(findTestObject('SAP/se16n/msg_error'))

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BH', i, msg)
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'L', i, 
            'true')

        WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)
    } else if ((SAP_se16n_n_factura == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}