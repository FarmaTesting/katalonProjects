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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : trx], FailureHandling.STOP_ON_FAILURE)

//*****************Hace click en selección multiple*********************//
//WebUI.click(findTestObject('SAP/z_sd_punto_arranque/btn_seleccion_multiple'))
//WebUI.delay(2)
//WebUI.verifyElementVisible(findTestObject('SAP/z_sd_punto_arranque/iframe_URLSPW-0'))
//**********************************************************************//
//******************Completar seleccion *******************************//
nRows = findTestData('DGScenarios').getRowNumbers()

/*for (int i = 1; i <= nRows; i++) {
    pedidoSap = findTestData('DGScenarios').getValue(strNumPedidoSap, i)
    xpath = (('//td[contains(@id,"[' + i) + ',2]")]/div/span/input')
    println('******* xpath: ' + xpath)
    TestObject new_object = WebUI.modifyObjectProperty(findTestObject('SAP/vkm4/txt_ppup_selec_mult_celda'), 'xpath', 'equals', 
        xpath, true)
    WebUI.sendKeys(new_object, pedidoSap)
    WebUI.delay(2)
}*/
//WebUI.sendKeys(findTestObject('SAP/vkm4/txt_ppup_selec_mult_celda'), Keys.chord(Keys.F8))
def listPedidoSap89_101_106 = []

def sortListPedidoSap89_101_106 = []

for (int i = 1; i <= nRows; i++) {
	
	pedidoSap89 = findTestData('DGScenarios').getValue('strNumPedidoSap89', i)
	
	if (pedidoSap89 != '') {
	
    listPedidoSap89_101_106.add(pedidoSap89)
	}
}

for (int i = 1; i <= nRows; i++) {
	
	pedidoSap101 = findTestData('DGScenarios').getValue('strNumPedidoSap101', i)
	
	if (pedidoSap101 != '') {
	
    listPedidoSap89_101_106.add(pedidoSap101)
	}
}

for (int i = 1; i <= nRows; i++) {
	
	pedidoSap106 = findTestData('DGScenarios').getValue('strNumPedidoSap106', i)
	
	if (pedidoSap106 != '') {
	
    listPedidoSap89_101_106.add(pedidoSap106)
	}
}

sortListPedidoSap89_101_106 = listPedidoSap89_101_106.sort()

println(sortListPedidoSap89_101_106.size())

println('******** menor: ' + sortListPedidoSap89_101_106.get(0))

WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), sortListPedidoSap89_101_106.get(
        0))

mayor = sortListPedidoSap89_101_106.size() - 1

WebUI.delay(1)

println('******** mayor:' + sortListPedidoSap89_101_106.get(mayor))

WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap_to'), sortListPedidoSap89_101_106.get(mayor))

WebUI.delay(1)

//**********************************************************************//
WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(3)

if (!(WebUI.verifyElementVisible(findTestObject('SAP/z_sd_punto_arranque/txt_no_existen_ped_pend'), FailureHandling.OPTIONAL))) {
    WebUI.delay(1)

    WebUI.click(findTestObject('SAP/z_sd_punto_arranque/btn_marcar_todo'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F1), FailureHandling.OPTIONAL)

    WebUI.delay(2)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3), FailureHandling.OPTIONAL)

    WebUI.delay(3) //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque', 15, FailureHandling.OPTIONAL)
} else if (WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/general/iframe_popup'), 15, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/SAP/general/iframe_popup'), 15, FailureHandling.OPTIONAL)

    WebUI.sendKeys(findTestObject('Object Repository/SAP/general/iframe_popup'), Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque')

}

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.closeBrowser()

