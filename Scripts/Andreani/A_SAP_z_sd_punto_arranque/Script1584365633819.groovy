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

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nz_sd_punto_arranque'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

//******************Completar seleccion *******************************//
nRows = findTestData('DG_Andreani').getRowNumbers()

/*def nRowsEncontradas = findTestData('DG_Andreani').getRowNumbers()
println('Filas encontradas: ' + nRowsEncontradas)
for (int i = 1; i <= nRowsEncontradas; i++) {
    WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 30)
    WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque')
    WebUI.delay(1)
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
    WebUI.delay(1)
    WebUI.waitForElementVisible(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), 30)
    for (int c = 41; c <= 43; c++) {
        def nRowEnEjecucion = i
        def nColEnEjecucion = c
        println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' y ejecutando columna N: ') + nColEnEjecucion)
        def strNumPedidoSap = findTestData('DG_Andreani').getValue(nColEnEjecucion, nRowEnEjecucion)*/

def listPedidoSap89_101_106 = []

def sortListPedidoSap89_101_106 = []

for (int i = 1; i <= nRows; i++) {
	
		listPedidoSap89_101_106.add(findTestData('DG_Andreani').getValue(41, i))
	
	}
	
for (int i = 1; i <= nRows; i++) {
		
		listPedidoSap89_101_106.add(findTestData('DG_Andreani').getValue(42, i))
	}

for (int i = 1; i <= nRows; i++) {
	
		listPedidoSap89_101_106.add(findTestData('DG_Andreani').getValue(43, i))
}

sortListPedidoSap89_101_106 = listPedidoSap89_101_106.sort()

WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), sortListPedidoSap89_101_106.get(0))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap_to'), sortListPedidoSap89_101_106.get(17))

WebUI.delay(1)
//**********************************************************************//

/*WebUI.clearText(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'))
WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), strNumPedidoSap)*/

WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), Keys.chord(Keys.F8))

WebUI.delay(3)

if (WebUI.verifyElementVisible(findTestObject('SAP/z_sd_punto_arranque/btn_marcar_todo'), FailureHandling.OPTIONAL)) {
    WebUI.delay(1)

    WebUI.click(findTestObject('SAP/z_sd_punto_arranque/btn_marcar_todo'), FailureHandling.OPTIONAL)

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F1), FailureHandling.OPTIONAL)

    WebUI.delay(5)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3), FailureHandling.OPTIONAL)

    WebUI.delay(3)
} else if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/general/iframe_popup'), 15, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/general/iframe_popup'), 15, FailureHandling.OPTIONAL)

    WebUI.sendKeys(findTestObject('Object Repository/SAP/general/iframe_popup'), Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque', 15, FailureHandling.OPTIONAL)
}

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.closeBrowser()