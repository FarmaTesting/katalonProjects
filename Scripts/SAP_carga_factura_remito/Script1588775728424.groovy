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

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nz_sd_doc_comit'], FailureHandling.STOP_ON_FAILURE)

row_control = findTestData('DGScenarios').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' *******************')

for (int i = 1; i <= row_control; i++) {
    SAP_factura_remito = findTestData('control_jobs').getValue('SAP_factura_remito', i)

    println(('******************* REGISTRO N: ' + i) + ' *******************')

    if (SAP_factura_remito == '') {
        comitente = findTestData('DGScenarios').getValue('param_comitente', i)

        strNumPedidoSap106 = findTestData('DGScenarios').getValue('strNumPedidoSap106', i)

        remito = ('R00' + findTestData('DGScenarios').getValue('strNumPedidoSap106', i))

        out_n_entrega_106 = findTestData('DGScenarios').getValue('out_n_entrega_106', i)

        WebUI.sendKeys(findTestObject('SAP/factura_remito/txt_comitente'), comitente)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/factura_remito/txt_orden_compra'), strNumPedidoSap106)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/factura_remito/txt_entrega_sap'), out_n_entrega_106)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/factura_remito/txt_nro_remito'), remito)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(2)

        def popup = WebUI.verifyElementVisible(findTestObject('SAP/factura_remito/ppup_mensaje'), FailureHandling.OPTIONAL)

        if (popup) {
            WebUI.delay(1)

            CustomKeywords.'utilities.Tools.enter'()

            WebUI.click(findTestObject('SAP/factura_remito/ppup_btn_continuar'))
        }
        
        //****************************************************//

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'K', i, 'true')
		
		WebUI.delay(1)
		
        WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nz_sd_doc_comit')

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
    } else if ((SAP_factura_remito == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}

WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)