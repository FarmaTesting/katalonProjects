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

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : trx], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'), 'E0002')

WebUI.delay(1)

//*****************Hace click en selección multiple*********************//
WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/btn_seleccion_multiple'))

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('SAP/z_sd_libera_pedidos/iframe_URLSPW-0'))

//******************Completar seleccion *******************************//
WebUI.callTestCase(findTestCase('101_Pages/02_Liberacion_Pedido_Masiva'), [('strNumPedidoSap') : 42], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SAP/z_sd_libera_pedidos/txt_ppup_selec_mult_celda'), Keys.chord(Keys.F8))

WebUI.delay(1)

//************* Completar seleccion ************************//
WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

WebUI.delay(2)

if (WebUI.waitForElementVisible(findTestObject('SAP/z_sd_libera_pedidos/txt_no_encontro_datos'), 10)) {
    WebUI.clearText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'))

    WebUI.delay(1)

    WebUI.setText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'), 'E0030')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

    WebUI.delay(2)

    if (WebUI.waitForElementVisible(findTestObject('SAP/z_sd_libera_pedidos/tbl_registro_n_pedido'), 10)) {
        //Click a boton para seleccionar registro
        WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/btn_liberacion_masiva'))

        WebUI.delay(1)

        //Click a opcion dropdown para seleccionar registro encontrado\r\n
        WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/btn_opcion_selec_todos'))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F8))

        WebUI.delay(5)

        WebUI.waitForElementVisible(findTestObject('SAP/z_sd_libera_pedidos/txt_E0032'), 30)

        WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/txt_E0032'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/SAP/z_sd_libera_pedidos/img_tomar'))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

        WebUI.delay(3)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

        WebUI.delay(3)
    }
}

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.closeBrowser()

