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

println(('****************** CANTIDAD DE REGISTROS: ' + row_control) + ' *******************')

for (int i = 1; i <= row_control; i++) {
    SAP_01_se16n_n_orden_compra = findTestData('control_jobs_Andreani').getValue('SAP_01_se16n_n_orden_compra', i)

    println(('******************* REGISTRO N: ' + i) + ' ********************')

    if (SAP_01_se16n_n_orden_compra == 'false') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        /*def nRowsEncontradas = findTestData('DG_Andreani').getRowNumbers()
println('Filas encontradas: ' + nRowsEncontradas)
for (int i = 1; i <= findTestData('DG_Andreani').getRowNumbers(); i++) {*/
        def nRowEnEjecucion = i

        println('Ejecutando fila N: ' + nRowEnEjecucion)

        WebUI.delay(1)

        /*    WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 10)
    WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
	WebUI.delay(1)
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nse16n')
    WebUI.delay(1)
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
	WebUI.delay(1)*/
        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 10)

        strTabla = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'value')

        if (strTabla != 'EKKO') {
            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'ekko')

            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

            WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 30)
        }
        
        WebUI.delay(3)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(8)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 30)

        WebUI.delay(8)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zzpedweb')

        WebUI.delay(2)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        WebUI.delay(1)

        //def refExternaRemito = WebUI.concatenate(findTestData('DG_Andreani').getValue('param_comitente', nRowEnEjecucion), 
        //    '00000000', findTestData('DG_Andreani').getValue('out_n_remito', nRowEnEjecucion))

		def refExternaRemito = (findTestData('DG_Andreani').getValue('out_rem_elect_i141',nRowEnEjecucion)).split(';')
		
		String arraySplited = refExternaRemito[0]
		
        WebUI.delay(4)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 
            'AW', nRowEnEjecucion, arraySplited)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), arraySplited)
		WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(3)

        if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 
                'AT', nRowEnEjecucion, WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value'))

            WebUI.delay(4)
        }
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'control_jobs', 'D', i, 'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

		break
    }
}