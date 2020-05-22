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

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : trx], FailureHandling.STOP_ON_FAILURE)

//*****************Hace click en selección multiple*********************//
//WebUI.click(findTestObject('SAP/vkm4/btn_seleccion_multiple'))
//WebUI.verifyElementVisible(findTestObject('SAP/vkm4/iframe_URLSPW-0'))
//**********************************************************************//
//******************Completar seleccion *******************************//
nRows = findTestData('DGScenarios').getRowNumbers()

/*for (int i = 1; i <= nRows; i++) {
	pedidoSap = findTestData('DGScenarios').getValue(strNumPedidoSap, i)
	xpath = (('//td[contains(@id,"[' + i) + ',2]")]/div/span/input')
	println('******* xpath: ' + xpath)
   TestObject new_object = WebUI.modifyObjectProperty(findTestObject('SAP/z_sd_punto_arranque/txt_ppup_selec_mult_celda'), 'xpath',
		'equals', xpath, true)
	WebUI.sendKeys(new_object, pedidoSap)
	WebUI.delay(2)
}*/
//WebUI.sendKeys(findTestObject('SAP/vkm4/txt_ppup_selec_mult_celda'), Keys.chord(Keys.F8))
def listPedidoSap89_101 = []

def sortListPedidoSap89_101 = []

for (int i = 1; i <= nRows; i++) {
    pedidoSap89 = findTestData('DGScenarios').getValue('strNumPedidoSap89', i)

    if (pedidoSap89 != '') {
        listPedidoSap89_101.add(pedidoSap89)
    }
}

for (int i = 1; i <= nRows; i++) {
    pedidoSap101 = findTestData('DGScenarios').getValue('strNumPedidoSap101', i)

    if (pedidoSap101 != '') {
        listPedidoSap89_101.add(pedidoSap101)
    }
}

sortListPedidoSap89_101 = listPedidoSap89_101.sort()

println(sortListPedidoSap89_101.size())

println('******** menor: ' + sortListPedidoSap89_101.get(0))

WebUI.sendKeys(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap'), sortListPedidoSap89_101.get(0))

mayor = (sortListPedidoSap89_101.size() - 1)

WebUI.delay(1)

println('******* mayor: ' + sortListPedidoSap89_101.get(mayor))

WebUI.sendKeys(findTestObject('SAP/vkm4/txt_doc_comercial_n_pedido_sap_to'), sortListPedidoSap89_101.get(mayor))

//**********************************************************************//
WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(2)

def msj_no_registro = WebUI.verifyElementVisible(findTestObject('SAP/vkm4/txt_no_encontro_registro'), FailureHandling.OPTIONAL)

if (msj_no_registro) {
    println('***************** No hay pedido para liberar *****************')

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.delay(2)

    WebUI.closeBrowser( //WebUI.click(findTestObject('SAP/vkm4/chk_seleccion_pedido'))
        )
} else {
    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/chk_seleccion_pedido'), 10)

    WebUI.click(findTestObject('SAP/vkm4/btn_marcar_todo'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/btn_liberar_pedido'), 10)

    WebUI.click(findTestObject('SAP/vkm4/btn_liberar_pedido'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/vkm4/img_liberacion_exito'), 10)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

    WebUI.delay(1)

    WebUI.click(findTestObject('SAP/vkm4/btn_si_finalizar_lista'))

    WebUI.delay(2)
}

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.closeBrowser()