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

WebUI.delay(2)

def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()

println('Filas encontradas: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    WebUI.click(findTestObject('SAP/txt_buscador_trx'))

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nz_sd_libera_pedidos')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.delay(1)

    for (int c = 41; c <= 42; c++) {
        def nRowEnEjecucion = i
        def nColEnEjecucion = c
        println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' Ejecutando columna N: ') + nColEnEjecucion)

        WebUI.setText(findTestObject('SAP/liberacion_pedidos/txt_bloqueo_buscar'), 'E0002')

        WebUI.delay(1)

        WebUI.setText(findTestObject('SAP/liberacion_pedidos/txt_n_pedido_a_buscar'), findTestData('DGScenarios').getValue(
                nColEnEjecucion, nRowEnEjecucion))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(1)

        if (WebUI.waitForElementVisible(findTestObject('SAP/liberacion_pedidos/txt_no_encontro_datos'), 5)) {
            WebUI.clearText(findTestObject('SAP/liberacion_pedidos/txt_bloqueo_buscar'))

            WebUI.delay(1)

            WebUI.setText(findTestObject('SAP/liberacion_pedidos/txt_bloqueo_buscar'), 'E0030')

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

            WebUI.delay(1)

            if (WebUI.verifyElementPresent(findTestObject('SAP/liberacion_pedidos/tbl_registro_n_pedido'), 5, FailureHandling.OPTIONAL)) {
                //Click a boton para seleccionar registro
                WebUI.click(findTestObject('SAP/liberacion_pedidos/btn_liberacion_masiva'))

                //Click a opcion dropdown para seleccionar registro encontrado\r\n
                WebUI.click(findTestObject('SAP/liberacion_pedidos/btn_opcion_selec_todos'))

                WebUI.delay(1)

                WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F8))

                WebUI.delay(3)

                WebUI.waitForElementVisible(findTestObject('SAP/liberacion_pedidos/Page_1579111655813/txt_E0032'), 30)

                WebUI.click(findTestObject('SAP/liberacion_pedidos/Page_1579111655813/txt_E0032'))

                WebUI.delay(1)

                WebUI.click(findTestObject('SAP/liberacion_pedidos/Page_Liberacin Masiva de Pedidos de Venta/img_tilde_verde'))

                WebUI.delay(1)

                WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

                WebUI.delay(1)

                WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

                WebUI.delay(1)
            }
        }
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()