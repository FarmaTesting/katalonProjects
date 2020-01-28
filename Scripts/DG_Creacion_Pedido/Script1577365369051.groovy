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
import com.kms.katalon.core.testdata.InternalData as InternalData
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

for (int i = 1; i <= findTestData('DGScenarios').getRowNumbers(); i++) {
	
	fechacorrido = findTestData('DGScenarios').getValue('strFechaCreado', i)
	
	actualDate = new Date().format('dd.MM.yyyy')

	if (fechacorrido != actualDate) {
		rowFound = i
				
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl(GlobalVariable.url)
		
		if ((ambiente = findTestData('DGScenarios').getValue('param_ambiente', rowFound)) != '') {
			WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), ambiente, false)
		}
		
		if ((materiales = findTestData('DGScenarios').getValue('param_materiales', rowFound)) != '') {
			WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_materiales'), materiales, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
		'no requerido'
		if ((comitente = findTestData('DGScenarios').getValue('param_comitente', rowFound)) != '') {
			WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_comitente'), comitente, false)
		}
		
		'no requerido'
		if ((trazable = findTestData('DGScenarios').getValue('param_trazable', rowFound)) != '\'OFF\'') {
			WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
		} else if (trazable == 'ON') {
			WebUI.check(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
		}
		
		if ((crear_pedido = findTestData('DGScenarios').getValue('param_crear_pedido', rowFound)) == '\'OFF\'') {
			WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
		} else if (crear_pedido == 'ON') {
			WebUI.check(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
		}
		
		'no requerido\r\n'
		if ((tipo_material = findTestData('DGScenarios').getValue('param_tipo_material', rowFound)) != '') {
			WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_tipo_material'), tipo_material, false)
		}
		
		if ((filtrar = findTestData('DGScenarios').getValue('filtrar', rowFound)) == 'SI') {
			WebUI.click(findTestObject('GeneradorDatos_Page/btn_filtrar'))
		}
		
		if ((cant_ingresar = findTestData('DGScenarios').getValue('param_cant_ingresar', rowFound)) != '') {
			WebUI.clearText(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'))
		
			WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'), cant_ingresar)
		}
		
		if ((ingresa_cuarentena = findTestData('DGScenarios').getValue('param_ingresa_cuarentena', rowFound)) == '\'OFF\'') {
			WebUI.uncheck(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
		} else if (ingresa_cuarentena == 'ON') {
			WebUI.check(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
		}
		
		if ((canti_pedido = findTestData('DGScenarios').getValue('param_canti_pedido', rowFound)) != '') {
			WebUI.clearText(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'))
		
			WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'), canti_pedido, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
		if ((otros_clientes = findTestData('DGScenarios').getValue('param_otros_clientes', rowFound)) != '') {
			WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_otros_clientes'), otros_clientes)
		}
		
		if ((generar = findTestData('DGScenarios').getValue('generar', rowFound)) == 'SI') {
		    WebUI.click(findTestObject('GeneradorDatos_Page/btn_generar'))
		}
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AS', rowFound, CustomKeywords.'utilities.tools.dateSap'())
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AT', rowFound, new Date().format('HH:mm'))
		
		strLote = WebUI.getAttribute(findTestObject('GeneradorDatos_Page/txt_lote'), 'Value')
		
		strFechaActual = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_actual'), 'Value')
		
		strFechaVencimiento = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_vencimiento'), 'Value')
		
		strNumRemito = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_remito'), 'Value')
		
		strOcComiente = WebUI.concatenate(((['R', WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_oc_comiente'), 'Value')]) as String[]), FailureHandling.STOP_ON_FAILURE)
		
		strNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_despacho'), 'Value')
		
		strDigVerNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_dig_ver_n_despacho'),'Value')
		
		strFechaDespPlaza = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_despacho_plaza'), 'Value')
		
		strNumPedido = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_pedido'), 'Value')
		
		strAltaLoteI105 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_alta_de_lotes_I105'))
		
		strRemElectI141 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_remito_electronico_I141'))
		
		strPedidoClienteI089 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_cliente_I089'))
		
		strPedidoDistI106 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_distribucion_I106'))
		
		strPedidoComitenteI101 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_del_comitente_I101'))
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'I', rowFound, strLote)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'J', rowFound, strFechaActual)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'K', rowFound, strFechaVencimiento)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'L', rowFound, strNumRemito)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'N', rowFound, strOcComiente)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'W', rowFound, strNumDespacho)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'X', rowFound, strDigVerNumDespacho)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'Y', rowFound, strFechaDespPlaza)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'Z', rowFound, strNumPedido)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AI', rowFound, strAltaLoteI105)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AJ', rowFound, strRemElectI141)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AK', rowFound, strPedidoClienteI089)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AL', rowFound, strPedidoDistI106)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AM', rowFound, strPedidoComitenteI101)

		WebUI.delay(600)
		
	}
	
	WebUI.closeBrowser()
	
}

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl(GlobalVariable.url)
//
//if ((ambiente = findTestData('DGScenarios').getValue('A', rowFound)) != '') {
//    WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), ambiente, false)
//}
//
//if (materiales != '') {
//    WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_materiales'), materiales, FailureHandling.CONTINUE_ON_FAILURE)
//}
//
//'no requerido'
//if (comitente != '') {
//    WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_comitente'), comitente, false)
//}
//
//'no requerido'
//if (trazable != '\'OFF\'') {
//    WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
//} else if (trazable == 'ON') {
//    WebUI.check(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
//}
//
//if (crear_pedido == '\'OFF\'') {
//    WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
//} else if (crear_pedido == 'ON') {
//    WebUI.check(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
//}
//
//'no requerido\r\n'
//if (tipo_material != '') {
//    WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_tipo_material'), tipo_material, false)
//}
//
//if (filtrar != 'SI') {
//    WebUI.click(findTestObject('GeneradorDatos_Page/btn_filtrar'))
//}
//
//if (cant_ingresar != '') {
//    WebUI.clearText(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'))
//
//    WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'), cant_ingresar)
//}
//
//if (ingresa_cuarentena == '\'OFF\'') {
//    WebUI.uncheck(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
//} else if (ingresa_cuarentena == 'ON') {
//    WebUI.check(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
//}
//
//if (canti_pedido != '') {
//    WebUI.clearText(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'))
//
//    WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'), canti_pedido, FailureHandling.CONTINUE_ON_FAILURE)
//}
//
//if (otros_clientes != '') {
//    WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_otros_clientes'), otros_clientes)
//}
//
////if (generar == 'SI') {
////    WebUI.click(findTestObject('GeneradorDatos_Page/btn_generar'))
////}
//strDate = new Date()
//
//def formattedDate = strDate.format('dd.MM.yyyy')
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AS', 1, formattedDate)
//
//def dateHour = strDate.format('HH:mm')
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AT', 1, dateHour)
//
//strLote = WebUI.getAttribute(findTestObject('GeneradorDatos_Page/txt_lote'), 'Value')
//
//strFechaActual = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_actual'), 'Value')
//
//strFechaVencimiento = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_vencimiento'), 
//    'Value')
//
//strNumRemito = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_remito'), 'Value')
//
////strOcComiente = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_oc_comiente'), 'Value')
//strOcComiente = WebUI.concatenate(((['R', WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_oc_comiente'), 
//                'Value')]) as String[]), FailureHandling.STOP_ON_FAILURE)
//
//strNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_despacho'), 'Value')
//
//strDigVerNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_dig_ver_n_despacho'), 
//    'Value')
//
//strFechaDespPlaza = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_despacho_plaza'), 
//    'Value')
//
//strNumPedido = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_pedido'), 'Value')
//
//println(strNumPedido)
//
//strAltaLoteI105 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_alta_de_lotes_I105'))
//
//println(strAltaLoteI105)
//
//strRemElectI141 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_remito_electronico_I141'))
//
//println(strRemElectI141)
//
//strPedidoClienteI089 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_cliente_I089'))
//
//println(strPedidoClienteI089)
//
//strPedidoDistI106 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_distribucion_I106'))
//
//println(strPedidoDistI106)
//
//strPedidoComitenteI101 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_del_comitente_I101'))
//
//println(strPedidoComitenteI101)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'I', 1, strLote)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'J', 1, strFechaActual)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'K', 1, strFechaVencimiento)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'L', 1, strNumRemito)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'N', 1, strOcComiente)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'W', 1, strNumDespacho)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'X', 1, strDigVerNumDespacho)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'Y', 1, strFechaDespPlaza)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'Z', 1, strNumPedido)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AI', 1, strAltaLoteI105)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AJ', 1, strRemElectI141)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AK', 1, strPedidoClienteI089)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AL', 1, strPedidoDistI106)
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AM', 1, strPedidoComitenteI101)