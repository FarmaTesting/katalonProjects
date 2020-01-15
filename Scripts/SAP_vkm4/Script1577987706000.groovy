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

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nvkm4')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/SAP_nvkm4/txt_doc_comercial_n_pedido_sap'), 30)

WebUI.sendKeys(findTestObject('SAP/SAP_nvkm4/txt_doc_comercial_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.waitForElementVisible(findTestObject('SAP/SAP_nvkm4/chk_seleccion_pedido'), 30)

//WebUI.click(findTestObject('null'))
WebUI.check(findTestObject('SAP/SAP_nvkm4/chk_seleccion_pedido'))

WebUI.waitForElementVisible(findTestObject('SAP/SAP_nvkm4/btn_liberar_pedido'), 30)

WebUI.click(findTestObject('SAP/SAP_nvkm4/btn_liberar_pedido'))

WebUI.waitForElementVisible(findTestObject('SAP/SAP_nvkm4/img_liberacion_exito'), 30)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/n')

