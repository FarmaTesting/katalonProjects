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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

row_control = findTestData('DGScenarios').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' ********************')

for (int i = 1; i <= row_control; i++) {
    SAP_vf01_confirmar_nc = findTestData('control_jobs').getValue('SAP_vf01_confirmar_nc', i)

    println(('****************** REGISTRO N: ' + i) + ' ********************')

    if (SAP_vf01_confirmar_nc == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nvf01'], FailureHandling.STOP_ON_FAILURE)

        //************************* Nota de credito 089 para confirmar***************************//
        out_n_pedido_sol_nc_089 = findTestData('DGScenarios').getValue('out_n_pedido_sol_nc_089', i)

        WebUI.sendKeys(findTestObject('SAP/vf01/txt_nc_documento'), out_n_pedido_sol_nc_089)

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/general/btn_guardar'))

        WebUI.delay(1)

        status = WebUI.verifyElementVisible(findTestObject('SAP/vf01/txt_status'), FailureHandling.OPTIONAL)

        text89 = WebUI.getAttribute(findTestObject('SAP/vf01/txt_status'), 'value')

        if (status && (text89 == 'Tratado')) {
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BK', i, text89)
			WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nvf01'], FailureHandling.STOP_ON_FAILURE)
			
        } else {
            documento = WebUI.getText(findTestObject('SAP/vf01/span_msg_notacredito'))

            out_nota_credito_089 = documento.substring(10, 18)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BK', i, out_nota_credito_089)
        }
        
        WebUI.delay(1)

        //************************* Nota de credito 101 para confirmar***************************//
        out_n_pedido_sol_nc_101 = findTestData('DGScenarios').getValue('out_n_pedido_sol_nc_101', i)

        WebUI.sendKeys(findTestObject('SAP/vf01/txt_nc_documento'), out_n_pedido_sol_nc_101)

        WebUI.delay(1)

        WebUI.click(findTestObject('SAP/general/btn_guardar'))

        WebUI.delay(1)

        status = WebUI.verifyElementVisible(findTestObject('SAP/vf01/txt_status'), FailureHandling.OPTIONAL)

        text101 = WebUI.getAttribute(findTestObject('SAP/vf01/txt_status'), 'value')

        if (status && (text101 == 'Tratado')) {
            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BL', i, text101)
			WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nvf01'], FailureHandling.STOP_ON_FAILURE)
			
        } else {
            documento = WebUI.getText(findTestObject('SAP/vf01/span_msg_notacredito'))

            out_nota_credito_101 = documento.substring(10, 18)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 
                'BL', i, out_nota_credito_101)
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'N', i, 
            'true')

        WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)
    } else if ((SAP_vf01_confirmar_nc == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}