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

WebUI.delay(1)

//*****************Hace click en selección multiple*********************//
WebUI.click(findTestObject('SAP/vkm4/btn_seleccion_multiple'))

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('SAP/vkm4/iframe_URLSPW-0'))

//**********************************************************************//
//******************Completar seleccion *******************************//
nRows = findTestData('DGScenarios').getRowNumbers()

for (int i = 1; i <= nRows; i++) {
	pedidoSap = findTestData('DGScenarios').getValue(strNumPedidoSap, i)

	xpath = (('//td[contains(@id,"[' + i) + ',2]")]/div/span/input')

	println('******* xpath: ' + xpath)

   TestObject new_object = WebUI.modifyObjectProperty(findTestObject('SAP/vkm4/txt_ppup_selec_mult_celda'), 'xpath',
		'equals', xpath, true)

	WebUI.sendKeys(new_object, pedidoSap)

	WebUI.delay(2)
}

WebUI.sendKeys(findTestObject('SAP/vkm4/txt_ppup_selec_mult_celda'), Keys.chord(Keys.F8))

WebUI.delay(1)

//**********************************************************************//

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(2)


if (!WebUI.verifyElementPresent(findTestObject('SAP/vkm4/txt_no_encontro_registro'), 10, FailureHandling.OPTIONAL)) {
	
	WebUI.waitForElementVisible(findTestObject('SAP/vkm4/chk_seleccion_pedido'), 20)
	
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