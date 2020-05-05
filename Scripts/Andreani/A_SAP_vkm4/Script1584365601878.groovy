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

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nvkm4'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

//******************Completar seleccion *******************************//
nRows = findTestData('DG_Andreani').getRowNumbers()

//def nRowsEncontradas = findTestData('DG_Andreani').getRowNumbers()
//println('Filas encontradas: ' + nRowsEncontradas)
//for (int i = 1; i <= nRowsEncontradas; i++) {
/*    WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nvkm4')
    WebUI.delay(1)
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap'), 30)*/
//    for (int c = 41; c <= 42; c++) {
/*        def nRowEnEjecucion = i
        def nColEnEjecucion = c
        println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' Ejecutando columna N: ') + nColEnEjecucion)
        def strNumPedidoSap = findTestData('DG_Andreani').getValue(nColEnEjecucion, nRowEnEjecucion)*/
def listPedidoSap89_101 = []

def sortListPedidoSap89_101 = []

for (int i = 1; i <= nRows; i++) {
    listPedidoSap89_101.add(findTestData('DG_Andreani').getValue(41, i))
}

for (int i = 1; i <= nRows; i++) {
    listPedidoSap89_101.add(findTestData('DG_Andreani').getValue(42, i))
}

sortListPedidoSap89_101 = listPedidoSap89_101.sort()

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap'), sortListPedidoSap89_101.get(0))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap_to'), sortListPedidoSap89_101.get(11))

//**********************************************************************//
WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(2)

/*        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap'))

        WebUI.sendKeys(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap'), strNumPedidoSap)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))*/
if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/vkm4/txt_no_encontro_registro'), 5, FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('Object Repository/SAP/vkm4/txt_no_encontro_registro'), 30)

    println('No se encontro pedido para liberar')
} else if (WebUI.verifyElementPresent(findTestObject('SAP/vkm4/chk_seleccion_pedido'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('SAP/vkm4/chk_seleccion_pedido'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/btn_liberar_pedido'), 30)

    WebUI.click(findTestObject('SAP/vkm4/btn_liberar_pedido'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/img_liberacion_exito'), 30)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

    WebUI.delay(1)

    WebUI.click(findTestObject('SAP/vkm4/btn_si_finalizar_lista'))
}

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.closeBrowser()