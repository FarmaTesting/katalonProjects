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
    WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 30)

    WebUI.click(findTestObject('SAP/txt_buscador_trx'))

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nz_sd_punto_arranque')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('SAP/punto_de_arranque/txt_nro_doc_comercial_n_pedidosap'), 30)

    for (int c = 41; c <= 42; c++) {
        def nRowEnEjecucion = i

        def nColEnEjecucion = c

        println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' y ejecutando columna N: ') + nColEnEjecucion)

        def strNumPedidoSap = findTestData('DGScenarios').getValue(nColEnEjecucion, nRowEnEjecucion)

        WebUI.clearText(findTestObject('SAP/punto_de_arranque/txt_nro_doc_comercial_n_pedidosap'))

        WebUI.sendKeys(findTestObject('SAP/punto_de_arranque/txt_nro_doc_comercial_n_pedidosap'), strNumPedidoSap)

        WebUI.sendKeys(findTestObject('SAP/punto_de_arranque/txt_nro_doc_comercial_n_pedidosap'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        if (WebUI.verifyElementPresent(findTestObject('SAP/punto_de_arranque/btn_marcar_todo'), 15, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('SAP/punto_de_arranque/btn_marcar_todo'))
			
			WebUI.delay(5)

            WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F1))
			
			WebUI.delay(5)

            WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

            WebUI.delay(1)
        } else {
            WebUI.delay(1)
			
			WebUI.verifyElementPresent(findTestObject('SAP/punto_de_arranque/iframe_popup'), 15, FailureHandling.OPTIONAL)

            WebUI.sendKeys(findTestObject('SAP/punto_de_arranque/iframe_popup'), Keys.chord(Keys.ENTER))
        }
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()

