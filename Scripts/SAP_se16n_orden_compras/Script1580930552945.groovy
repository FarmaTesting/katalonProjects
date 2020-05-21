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

println(('****************** CANTIDAD DE REGISTROS: ' + row_control) + ' *******************')

for (int i = 1; i <= row_control; i++) {
    SAP_01_se16n_n_orden_compra = findTestData('control_jobs').getValue('SAP_01_se16n_n_orden_compra', i)

    println(('******************* REGISTRO N: ' + i) + ' ********************')

    if (SAP_01_se16n_n_orden_compra == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        def nRowEnEjecucion = i

        WebUI.delay(1)

        strTabla = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'value')

        if (strTabla != 'EKKO') {
            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'ekko')

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

            WebUI.delay(1)

            WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 10)
        }
        
        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(2)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 10)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zzpedweb')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        def refExternaRemito = WebUI.concatenate(findTestData('DGScenarios').getValue('param_comitente', nRowEnEjecucion), 
            '00000000', findTestData('DGScenarios').getValue('out_n_remito', nRowEnEjecucion))

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AW', nRowEnEjecucion, 
            refExternaRemito)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), refExternaRemito)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(3)

        if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AT', 
                nRowEnEjecucion, WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value'))

            WebUI.delay(1)
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'D', i, 'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

    } else if ((SAP_01_se16n_n_orden_compra == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}