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

WebUI.delay(2)

//def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()
//cantidad de registros
row_control = findTestData('control_jobs').getRowNumbers()

//println('Filas encontradas: ' + nRowsEncontradas)
println('******** Filas encontradas a ejecutar: ' + row_control)

//for (int i = 1; i <= nRowsEncontradas; i++)
for (int i = 1; i <= row_control; i++) {
    SAP_04_punto_de_arranque = findTestData('control_jobs').getValue('SAP_04_punto_de_arranque', i)

    println(((('<<<<<<<<<< IF SAP_04_punto_de_arranque: ' + SAP_04_punto_de_arranque) + ' registro: ') + i) + ' >>>>>>>>>>')

    if (SAP_04_punto_de_arranque == 'false') {
        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nz_sd_punto_arranque'], FailureHandling.STOP_ON_FAILURE)

        //WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 30)
        //WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
        //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque')
        //WebUI.delay(1)
        //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        WebUI.delay(2)

        //WebUI.waitForElementVisible(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), 30)
        for (int c = 41; c <= 43; c++) {
            def nRowEnEjecucion = i

            def nColEnEjecucion = c

            println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' y ejecutando columna N: ') + nColEnEjecucion)

            def strNumPedidoSap = findTestData('DGScenarios').getValue(nColEnEjecucion, nRowEnEjecucion)

            WebUI.delay(3)

            WebUI.clearText(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'))

            WebUI.delay(1)

            println('****** NumPedidoSap: ' + strNumPedidoSap)

            WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), strNumPedidoSap)

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap'), Keys.chord(Keys.F8))

            WebUI.delay(7)

            if (!(WebUI.verifyElementVisible(findTestObject('SAP/z_sd_punto_arranque/txt_no_existen_ped_pend'), FailureHandling.OPTIONAL))) {
                WebUI.delay(1)

                WebUI.click(findTestObject('SAP/z_sd_punto_arranque/btn_marcar_todo'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(5)

                WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F1), FailureHandling.OPTIONAL)

                WebUI.delay(5)

                WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3), FailureHandling.OPTIONAL)

                WebUI.delay(5 //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_punto_arranque', 15, FailureHandling.OPTIONAL)
                    )
            } else {
                WebUI.delay(1)

                WebUI.sendKeys(findTestObject('SAP/general/iframe_popup'), Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
            }
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'H', i, 'true')

        break
    } else if ((SAP_04_punto_de_arranque == 'true') && (i == row_control)) {
        assert true

        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()