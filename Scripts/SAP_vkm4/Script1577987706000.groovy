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

WebUI.delay(5)

def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()

println('Filas encontradas: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    WebUI.click(findTestObject('SAP/txt_buscador_trx'))

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nvkm4')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.waitForElementVisible(findTestObject('SAP/nvkm4/txt_doc_comercial_n_pedido_sap'), 30)

    for (int c = 41; c <= 42; c++) {
        def nRowEnEjecucion = i

        def nColEnEjecucion = c

        println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' Ejecutando columna N: ') + nColEnEjecucion)

        def strNumPedidoSap = findTestData('DGScenarios').getValue(nColEnEjecucion, nRowEnEjecucion)

        WebUI.delay(1)

        WebUI.clearText(findTestObject('SAP/nvkm4/txt_doc_comercial_n_pedido_sap'))

        WebUI.sendKeys(findTestObject('SAP/nvkm4/txt_doc_comercial_n_pedido_sap'), strNumPedidoSap)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

        if (WebUI.verifyElementPresent(findTestObject('SAP/nvkm4/chk_seleccion_pedido'), 5, FailureHandling.OPTIONAL)) {
            WebUI.check(findTestObject('SAP/nvkm4/chk_seleccion_pedido'))

            WebUI.delay(1)

            WebUI.waitForElementVisible(findTestObject('SAP/nvkm4/btn_liberar_pedido'), 30)

            WebUI.click(findTestObject('SAP/nvkm4/btn_liberar_pedido'))

            WebUI.delay(1)

            WebUI.waitForElementVisible(findTestObject('SAP/nvkm4/img_liberacion_exito'), 30)

            WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nvkm4/btn_si_finalizar_lista'))
        }
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()
