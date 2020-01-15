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

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nz_sd_libera_pedidos')

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

def strNumPedidoSap = findTestData('DGScenarios').getValue('out_n_pedido_sap', 1)

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0002')

WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

if (WebUI.waitForElementVisible(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_no_encontro_datos'), 5) == true) {
    WebUI.clearText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'))

    WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0030')

    WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

    //if (WebUI.verifyElementVisible(findTestObject('null')) == 
    //true) {
    if (WebUI.getText(findTestObject('SAP/SAP_Liberacion_Pedidos/tbl_col_n_pedido')) == 'N° Pedido') {
        'Click a boton para seleccionar registro'
        WebUI.click(findTestObject('SAP/SAP_Liberacion_Pedidos/btn_liberacion_masiva'))

        'Click a opcion dropdown para seleccionar registro encontrado\r\n'
        WebUI.click(findTestObject('SAP/SAP_Liberacion_Pedidos/btn_opcion_selec_todos'))

        WebUI.delay(10)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F8))

        WebUI.delay(10)

        WebUI.waitForElementVisible(findTestObject('SAP/SAP_Liberacion_Pedidos/Page_1579111655813/txt_E0032'), 5)

        WebUI.click(findTestObject('SAP/SAP_Liberacion_Pedidos/Page_1579111655813/txt_E0032'))

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.TAB))

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.TAB))

        //WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.SPACE))

        WebUI.delay(2)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/n')
    }
}

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0005')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0011')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0014')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0017')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0020')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0021')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0024')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_bloqueo_buscar'), 'E0027')

not_run: WebUI.setText(findTestObject('SAP/SAP_Liberacion_Pedidos/txt_n_pedido_sap'), strNumPedidoSap)

not_run: WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

