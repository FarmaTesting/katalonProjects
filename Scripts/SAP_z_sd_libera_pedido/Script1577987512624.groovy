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

WebUI.delay(1)

//def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()
//cantidad de registros
row_control = findTestData('control_jobs').getRowNumbers()

//println('Filas encontradas: ' + nRowsEncontradas)
println('******** Filas encontradas a ejecutar: ' + row_control)

//for (int i = 1; i <= nRowsEncontradas; i++)
for (int i = 1; i <= row_control; i++) {
    SAP_02_z_sd_libera_pedido = findTestData('control_jobs').getValue('SAP_02_z_sd_libera_pedido', i)

    println(((('<<<<<<<<<< IF SAP_02_z_sd_libera_pedido: ' + SAP_02_z_sd_libera_pedido) + ' registro: ') + i) + ' >>>>>>>>>>')

    if (SAP_02_z_sd_libera_pedido == 'false') {
        WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

        WebUI.delay(2)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_libera_pedidos')

        WebUI.delay(2)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

        WebUI.delay(2)

        for (int c = 41; c <= 42; c++) {
            def nRowEnEjecucion = i

            def nColEnEjecucion = c

            println((('Ejecutando fila N: ' + nRowEnEjecucion) + ' Ejecutando columna N: ') + nColEnEjecucion)

            WebUI.delay(5)

            WebUI.setText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'), 'E0002')

            WebUI.delay(2)

            WebUI.setText(findTestObject('SAP/z_sd_libera_pedidos/txt_n_pedido_a_buscar'), findTestData('DGScenarios').getValue(
                    nColEnEjecucion, nRowEnEjecucion))

            WebUI.delay(2)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

            //        WebUI.delay(1)
            if (WebUI.waitForElementVisible(findTestObject('SAP/z_sd_libera_pedidos/txt_no_encontro_datos'), 10)) {
                WebUI.clearText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'))

                WebUI.delay(5)

                WebUI.setText(findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar'), 'E0030')

                WebUI.delay(2)

                WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

                //            WebUI.delay(1)
                if (WebUI.verifyElementPresent(findTestObject('SAP/z_sd_libera_pedidos/tbl_registro_n_pedido'), 10, FailureHandling.OPTIONAL)) {
                    //Click a boton para seleccionar registro
                    WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/btn_liberacion_masiva'))

                    //Click a opcion dropdown para seleccionar registro encontrado\r\n
                    WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/btn_opcion_selec_todos'))

                    WebUI.delay(2)

                    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F8))

                    WebUI.delay(5)

                    WebUI.waitForElementVisible(findTestObject('SAP/z_sd_libera_pedidos/txt_E0032'), 30)

                    WebUI.click(findTestObject('SAP/z_sd_libera_pedidos/txt_E0032'))

                    WebUI.delay(2)

                    WebUI.click(findTestObject('Object Repository/SAP/z_sd_libera_pedidos/img_tomar'))

                    WebUI.delay(1)

                    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

                    WebUI.delay(2)

                    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

                    WebUI.delay(3)
                }
            }
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'E', i, 'true')

        break
    } else if ((SAP_02_z_sd_libera_pedido == 'true') && (i == row_control)) {
        assert true

        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')
    }
}

WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()