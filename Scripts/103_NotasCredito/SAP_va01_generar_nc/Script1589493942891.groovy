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
    SAP_va01_generar_nc = findTestData('control_jobs').getValue('SAP_va01_generar_nc', i)
	descuento_89 = findTestData('DGScenarios').getValue('descuento_89', i)
	descuento_101 = findTestData('DGScenarios').getValue('descuento_101', i)
	nFactura089 = findTestData('DGScenarios').getValue('out_n_factura_089', i)
	nFactura101 = findTestData('DGScenarios').getValue('out_n_factura_101', i)

    println(('****************** REGISTRO N: ' + i) + ' ********************')

    if (SAP_va01_generar_nc == '' && descuento_89 !='' && descuento_101 !='' && nFactura089.length() < 8 && nFactura101.length() < 8) {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nva01'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_tipo_pedido'), 'ZNC9')

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(1)

        //**************************Genera nota credito 89*******************************//
        nFactura089 = findTestData('DGScenarios').getValue('out_n_factura_089', i)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_n_factura'), nFactura089)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_n_factura'), Keys.chord(Keys.F5))
		
		WebUI.delay(1)

        popup_msg = WebUI.verifyElementVisible(findTestObject('SAP/nva01/ppup_informacion'), FailureHandling.OPTIONAL)
		
		WebUI.delay(1)
		
		if (popup_msg) {
			
			WebUI.delay(2)
			
			clickable_popup_msg = WebUI.verifyElementClickable(findTestObject('SAP/nva01/btn_ppup_continuar'), FailureHandling.OPTIONAL)
			
			while(popup_msg && clickable_popup_msg){
				
				WebUI.delay(2)
			
				WebUI.click(findTestObject('SAP/nva01/btn_ppup_continuar'))
				
				WebUI.delay(5)
				
				popup_msg = WebUI.verifyElementVisible(findTestObject('SAP/nva01/ppup_informacion'), FailureHandling.OPTIONAL)
				
				WebUI.delay(5)
				
				clickable_popup_msg = WebUI.verifyElementClickable(findTestObject('SAP/nva01/btn_ppup_continuar'), FailureHandling.OPTIONAL)
			}
			
		}
		
		WebUI.delay(1)
        
        cabecera = WebUI.verifyElementVisible(findTestObject('SAP/nva01/btn_cabecera'), FailureHandling.OPTIONAL)

        if (cabecera) {
            WebUI.click(findTestObject('SAP/nva01/btn_cabecera'))

            WebUI.waitForElementVisible(findTestObject('SAP/nva01/txt_motivoPedido'), 10)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_motivoPedido'), 'AJUSTE DESCUENTO CON PRODUCTO')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/tab_Condiciones'))

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/btn_InsertarLinea'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_campo_condicion'), 'znc9')

            WebUI.delay(1)

            descuento89 = findTestData('DGScenarios').getValue('descuento_89', i)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_importe'), descuento89)

            WebUI.delay(1)

            netoAntes = WebUI.getAttribute(findTestObject('SAP/nva01/txt_neto'), 'value')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/btn_activar'))

            WebUI.delay(1)

            netoDespues = WebUI.getAttribute(findTestObject('SAP/nva01/txt_neto'), 'value')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/general/btn_guardar'))

            WebUI.delay(2)

            nc_generado = WebUI.getText(findTestObject('SAP/nva01/span_msg_notacredito'))

            //NC Financiera por % 61140071 se ha grabado
            out_n_pedido_sol_nc_089 = nc_generado.substring(20, 28)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'BI', 
                i, out_n_pedido_sol_nc_089)
        }
        
        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(1)
		
		WebUI.clearText(findTestObject('SAP/nva01/txt_n_factura'))
		
		WebUI.delay(1)

        //***************************Genera nota credito 101*******************************//
        nFactura101 = findTestData('DGScenarios').getValue('out_n_factura_101', i)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_n_factura'), nFactura101)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_n_factura'), Keys.chord(Keys.F5))
		
		WebUI.delay(1)
		
        popup_msg = WebUI.verifyElementVisible(findTestObject('SAP/nva01/ppup_informacion'), FailureHandling.OPTIONAL)
			
        if (popup_msg) {
			
			WebUI.delay(2)
			
			clickable_popup_msg = WebUI.verifyElementClickable(findTestObject('SAP/nva01/btn_ppup_continuar'), FailureHandling.OPTIONAL)
			
			while(popup_msg && clickable_popup_msg){
				
				WebUI.delay(2)
			
				WebUI.click(findTestObject('SAP/nva01/btn_ppup_continuar'))
				
				WebUI.delay(5)
				
				popup_msg = WebUI.verifyElementVisible(findTestObject('SAP/nva01/ppup_informacion'), FailureHandling.OPTIONAL)
				
				WebUI.delay(5)
				
				clickable_popup_msg = WebUI.verifyElementClickable(findTestObject('SAP/nva01/btn_ppup_continuar'), FailureHandling.OPTIONAL)
			}
			
		}
		
		WebUI.delay(1)
        
        cabecera = WebUI.verifyElementVisible(findTestObject('SAP/nva01/btn_cabecera'), FailureHandling.OPTIONAL)

        if (cabecera) {
            WebUI.click(findTestObject('SAP/nva01/btn_cabecera'))

            WebUI.waitForElementVisible(findTestObject('SAP/nva01/txt_motivoPedido'), 10)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_motivoPedido'), 'AJUSTE DESCUENTO CON PRODUCTO')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/tab_Condiciones'))

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/btn_InsertarLinea'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_campo_condicion'), 'znc9')

            WebUI.delay(1)

            descuento101 = findTestData('DGScenarios').getValue('descuento_101', i)

            WebUI.sendKeys(findTestObject('SAP/nva01/txt_importe'), descuento101)

            WebUI.delay(1)

            netoAntes = WebUI.getAttribute(findTestObject('SAP/nva01/txt_neto'), 'value')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/nva01/btn_activar'))

            WebUI.delay(1)

            netoDespues = WebUI.getAttribute(findTestObject('SAP/nva01/txt_neto'), 'value')

            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/general/btn_guardar'))

            WebUI.delay(2)

            nc_generado = WebUI.getText(findTestObject('SAP/nva01/span_msg_notacredito'))

            //NC Financiera por % 61140071 se ha grabado
            out_n_pedido_sol_nc_101 = nc_generado.substring(20, 28)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'BJ', 
                i, out_n_pedido_sol_nc_101)
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'M', i, 
            'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)
    } else if ((SAP_va01_generar_nc == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}