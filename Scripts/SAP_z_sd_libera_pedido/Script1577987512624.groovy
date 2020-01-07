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

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 0)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nz_sd_libera_pedidos')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0002')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

if (true) {
    WebUI.waitForImagePresent(findTestObject('SAP/SAP_Liberacion_Pedidos/img_tilde_verde'), 0)

    WebUI.waitForElementVisible(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_no_encontro_datos'), 0)
} else {
}

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0005')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0011')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0014')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0017')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0020')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0021')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0024')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0027')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0030')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

