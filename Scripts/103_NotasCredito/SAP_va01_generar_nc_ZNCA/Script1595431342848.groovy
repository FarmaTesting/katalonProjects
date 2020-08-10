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
    importe_nc = findTestData('DGScenarios').getValue('importe_nc', i)
	SAP_va01_generar_nc = findTestData('control_jobs').getValue('SAP_va01_generar_nc', i)

    println(('****************** REGISTRO N: ' + i) + ' ********************')

    if (importe_nc != '' && SAP_va01_generar_nc == '') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nva01'], FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_tipo_pedido'), 'ZNCA')

        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(1)

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
			
		WebUI.click(findTestObject('SAP/nva01/span_Ventas'))
			
		WebUI.delay(1)

        WebUI.waitForElementVisible(findTestObject('SAP/nva01/txt_motivoPedido'), 10)

        WebUI.sendKeys(findTestObject('SAP/nva01/txt_motivoPedido'), 'AJUSTE DESCUENTO FARMANET POR PRODUCTO')

        WebUI.delay(1)
			
	    WebUI.click(findTestObject('SAP/nva01/Posicion'))
			
	    WebUI.delay(1)			
			
	    WebUI.click(findTestObject('SAP/nva01/Pos_condiciones'))

        WebUI.delay(1)
			
	    WebUI.click(findTestObject('SAP/nva01/InsertarLinea'))
			
		WebUI.delay(1)
			
		importe = findTestData('DGScenarios').getValue('importe_nc', i)
		
		WebUI.sendKeys(findTestObject('SAP/nva01/txt_campo_condicion'), 'ZMA2')

        //WebUI.sendKeys(findTestObject('SAP/nva01/ClCd'), 'ZMA2')

        WebUI.delay(1)
			
		WebUI.sendKeys(findTestObject('SAP/nva01/txt_campo_condicion'),importe)
			
	    //WebUI.sendKeys(findTestObject('SAP/nva01/tbl_importe'), importe)
					
		WebUI.delay(1)
		
		WebUI.sendKeys(findTestObject('SAP/nva01/txt_campo_condicion'), Keys.chord(Keys.ENTER))
		
		//WebUI.sendKeys(findTestObject('SAP/nva01/tbl_importe'), Keys.chord(Keys.ENTER))
			
		WebUI.delay(1)
			
		WebUI.click(findTestObject('SAP/general/btn_guardar'))
			
		WebUI.delay(1)
						
		documento = WebUI.getText(findTestObject('SAP/nva01/span_msg_notacredito'))
			
		println(documento)
			
		WebUI.delay(1)
			
		documento_nc_importe = documento.substring(20, 28)
			
		WebUI.delay(1)
			
		println(documento_nc_importe)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'BI',i, documento_nc_importe)      
        
        WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

        WebUI.delay(1)
		
		//WebUI.clearText(findTestObject('SAP/nva01/txt_n_factura'))
		
		//WebUI.delay(1)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'M', i,
			'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)
    } else if ((SAP_va01_generar_nc == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}