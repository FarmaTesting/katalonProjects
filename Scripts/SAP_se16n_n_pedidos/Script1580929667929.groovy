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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

row_control = findTestData('DGScenarios').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' *******************')

for (int i = 1; i <= row_control; i++) {
    SAP_01_se16n_buscar_n_pedidos = findTestData('control_jobs').getValue('SAP_01_se16n_buscar_n_pedidos', i)

    println(('******************* REGISTRO N: ' + i) + ' *******************')

    if (SAP_01_se16n_buscar_n_pedidos == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        def nRowEnEjecucion = i

        strPedWeb089 = findTestData('DGScenarios').getValue('strPedWeb089', nRowEnEjecucion)

        strPedWeb101 = findTestData('DGScenarios').getValue('strPedWeb101', nRowEnEjecucion)

        strPedWeb106 = findTestData('DGScenarios').getValue('strPedWeb106', nRowEnEjecucion)

        println((((('*********** ' + strPedWeb089) + ' ** ') + strPedWeb101) + ' ** ') + strPedWeb106)

        WebUI.delay(1)

        strTabla = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'value')

        WebUI.delay(1)

        if (strTabla != 'VBAK') {
            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'vbak')

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

            WebUI.delay(2)

            WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 30)
        }

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(2)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 30)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zz_interfaz_nro')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        WebUI.delay(3)

        WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 30, FailureHandling.OPTIONAL)

        WebUI.waitForElementClickable(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20, FailureHandling.OPTIONAL)
		
		//************************** pedido 89********************************//
        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb089)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(3)

        if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
			
			strNumPedidoSap89 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'),'value')
			
			strNumPedidoSap89000 = '000' + strNumPedidoSap89
			
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AO', 
                nRowEnEjecucion, strNumPedidoSap89000)

        }

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(2)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 10)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zz_interfaz_nro')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        WebUI.delay(3)

       //WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

        WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 10)
		
		WebUI.waitForElementClickable(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 10, FailureHandling.OPTIONAL)
		
		//************************** pedido 101********************************//
        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb101)
		
		WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(3)

        if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 5, FailureHandling.OPTIONAL)) {
			
			strNumPedidoSap101 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'),'value')
			
			strNumPedidoSap101000 = '000' + strNumPedidoSap101
			
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AP', 
                nRowEnEjecucion, strNumPedidoSap101000)
        }
        
		WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse16n'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

        WebUI.delay(2)

        WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 10)

        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zz_interfaz_nro')

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/se16n/btn_ok'))

        WebUI.delay(3)

        WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 10)
		
		WebUI.waitForElementClickable(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 10, FailureHandling.OPTIONAL)
		
		//************************** pedido 106********************************//
        WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb106)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(3)

        if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
			
			strNumPedidoSap106 = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'),'value')
			
			strNumPedidoSap106000 = '000' + strNumPedidoSap106
			
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AQ', 
                nRowEnEjecucion, strNumPedidoSap106000)
        }

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'C', i, 'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

    } else if ((SAP_01_se16n_buscar_n_pedidos == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}