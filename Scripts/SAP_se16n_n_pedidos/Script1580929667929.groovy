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


WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()

println('Filas encontradas: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    def nRowEnEjecucion = i

    //println('Ejecutando fila N: ' + nRowEnEjecucion)
	
	KeywordUtil.logInfo("Ejecutando fila N: " + nRowEnEjecucion)

    strPedWeb089 = findTestData('DGScenarios').getValue('strPedWeb089', nRowEnEjecucion)

    strPedWeb101 = findTestData('DGScenarios').getValue('strPedWeb101', nRowEnEjecucion)

    strPedWeb106 = findTestData('DGScenarios').getValue('strPedWeb106', nRowEnEjecucion)

    WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 30)

    WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nse16n')

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 30)

    //WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'))
	
	strTabla = WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'value')
	
	if (strTabla != 'VBAK'){
		WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), 'vbak')
		
		WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))
			
		WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), 30)
	}
	
    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_3_3_segunda_celda_filtro'), findTestData('DGScenarios').getValue('strFechaCreado', 
    //            nRowEnEjecucion))
    //
    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), findTestData('DGScenarios').getValue('strHoraCreado', 
    //            nRowEnEjecucion))
    //	
    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_4_tercera_celda_filtro'), WebUI.concatenate(CustomKeywords.'utilities.Tools.sumarMinutos'(
    //                findTestData('DGScenarios').getValue('strHoraCreado', i)), ':59'))
	
    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_4_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))
	
	WebUI.delay(4)

    WebUI.waitForElementVisible(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 30)

    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'zz_interfaz_nro')

    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_buscar_filtro'), 'augru')
    WebUI.click(findTestObject('SAP/se16n/btn_ok'))

    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), '002')
    WebUI.delay(10)
	
	WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 30, FailureHandling.OPTIONAL)
	
	WebUI.waitForElementClickable(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20, FailureHandling.OPTIONAL)
	
	WebUI.delay(4)

    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb089)
	
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

    if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AO', nRowEnEjecucion, 
            WebUI.concatenate('000', WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')))
    }
    
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))
	
	WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20)
	
    WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), '198')
	
    WebUI.delay(10)
	
	WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20)
	
	WebUI.delay(4)

    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb101)
	
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

    if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AP', nRowEnEjecucion, 
            WebUI.concatenate('000', WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')))
    }
    
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))
	
	WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20)
	
    WebUI.clearText(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'))

    //    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), '139')
    WebUI.delay(10)
	
	WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), 20)
	
	WebUI.delay(4)

    WebUI.sendKeys(findTestObject('SAP/se16n/txt_se16n_1_1_3_primer_celda_filtro'), strPedWeb106)
	
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))
	
	WebUI.delay(2)

    if (WebUI.waitForElementPresent(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 10, FailureHandling.OPTIONAL)) {
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AQ', nRowEnEjecucion, 
            WebUI.concatenate('000', WebUI.getAttribute(findTestObject('SAP/se16n/txt_se16n_tabla_1ra_row'), 'value')))
    }
    
    WebUI.delay(5)
}

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()

