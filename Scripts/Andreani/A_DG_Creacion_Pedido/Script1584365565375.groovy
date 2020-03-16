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

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

def nRowsEncontradas = findTestData('DG_Andreani').getRowNumbers()

println('Filas encontradas a ejecutar: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    def nFilaEnEjecucion = i

    fechacorrido = findTestData('DG_Andreani').getValue('strFechaCreado', nFilaEnEjecucion)

    actualDate = new Date().format('dd.MM.yyyy')

    if (fechacorrido != actualDate) {
        println('Fila en ejecucion: ' + nFilaEnEjecucion)

        if ((ambiente = findTestData('DG_Andreani').getValue('param_ambiente', nFilaEnEjecucion)) != '') {
            WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), ambiente, false)
        }
        
        if ((materiales = findTestData('DG_Andreani').getValue('param_materiales', nFilaEnEjecucion)) != '') {
            WebUI.clearText(findTestObject('GeneradorDatos_Page/txt_materiales'))

            WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_materiales'), materiales, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        //		no requerido
        //		if ((comitente = findTestData('DG_Andreani').getValue('param_comitente', rowFound)) != '') {
        //			WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_comitente'), comitente, false)
        //		}
        'no requerido'
        if ((trazable = findTestData('DG_Andreani').getValue('param_trazable', nFilaEnEjecucion)) != '\'OFF\'') {
            WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
        } else if (trazable == 'ON') {
            WebUI.check(findTestObject('GeneradorDatos_Page/chk_solo_trazables'))
        }
        
        if ((crear_pedido = findTestData('DG_Andreani').getValue('param_crear_pedido', nFilaEnEjecucion)) == '\'OFF\'') {
            WebUI.uncheck(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
        } else if (crear_pedido == 'ON') {
            WebUI.check(findTestObject('GeneradorDatos_Page/chk_crear_pedidos'))
        }
        
        'no requerido\r\n'
        if ((tipo_material = findTestData('DG_Andreani').getValue('param_tipo_material', nFilaEnEjecucion)) != '') {
            WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_tipo_material'), tipo_material, false)
        }
        
        if ((filtrar = findTestData('DG_Andreani').getValue('filtrar', nFilaEnEjecucion)) == 'SI') {
            WebUI.click(findTestObject('GeneradorDatos_Page/btn_filtrar'))
        }
        
        if ((cant_ingresar = findTestData('DG_Andreani').getValue('param_cant_ingresar', nFilaEnEjecucion)) != '') {
            WebUI.clearText(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'))

            WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_cantidad_a_ingresar'), cant_ingresar)
        }
        
        if ((ingresa_cuarentena = findTestData('DG_Andreani').getValue('param_ingresa_cuarentena', nFilaEnEjecucion)) == 
        '\'OFF\'') {
            WebUI.uncheck(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
        } else if (ingresa_cuarentena == 'ON') {
            WebUI.check(findTestObject('Object Repository/GeneradorDatos_Page/chk_ingresa_a_cuarentena'))
        }
        
        if ((canti_pedido = findTestData('DG_Andreani').getValue('param_canti_pedido', nFilaEnEjecucion)) != '') {
            WebUI.clearText(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'))

            WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_cantidad_pedido'), canti_pedido, FailureHandling.CONTINUE_ON_FAILURE)
        }
		
        if ((otros_clientes = findTestData('DG_Andreani').getValue('param_otros_clientes', nFilaEnEjecucion)) != '') {
            WebUI.clearText(findTestObject('Object Repository/GeneradorDatos_Page/txt_otros_clientes'))

            WebUI.sendKeys(findTestObject('Object Repository/GeneradorDatos_Page/txt_otros_clientes'), otros_clientes)
        }
        
        if ((generar = findTestData('DG_Andreani').getValue('generar', nFilaEnEjecucion)) == 'SI') {
            WebUI.click(findTestObject('GeneradorDatos_Page/btn_generar'))
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AU', nFilaEnEjecucion, 
            CustomKeywords.'utilities.tools.dateSap'())

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AV', nFilaEnEjecucion, 
            new Date().format('HH:mm'))

        strLote = WebUI.getAttribute(findTestObject('GeneradorDatos_Page/txt_lote'), 'Value')

        strFechaActual = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_actual'), 'Value')

        strFechaVencimiento = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_vencimiento'), 
            'Value')

        strNumRemito = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_remito'), 'Value')

        //strOcComiente = WebUI.concatenate(((['R', WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_oc_comiente'), 'Value')]) as String[]), FailureHandling.STOP_ON_FAILURE)
        strOcComiente = WebUI.concatenate(((['0000', 'R', '0000', strNumRemito]) as String[]), FailureHandling.STOP_ON_FAILURE)

        strNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_despacho'), 'Value')

        strDigVerNumDespacho = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_dig_ver_n_despacho'), 
            'Value')

        strFechaDespPlaza = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_fecha_despacho_plaza'), 
            'Value')

        strNumPedido = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_n_pedido'), 'Value')

        strAltaLoteI105 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_alta_de_lotes_I105'))

        strRemElectI141 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_remito_electronico_I141'))

        strPedidoClienteI089 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_cliente_I089'))

        strPedidoDistI106 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_de_distribucion_I106'))

        strPedidoComitenteI101 = WebUI.getText(findTestObject('GeneradorDatos_Page/txt_pedido_del_comitente_I101'))
		
		strPedWeb089 = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_ped_web_089'), 'Value')
		
		strPedWeb101 = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_ped_web_101'), 'Value')
		
		strPedWeb106 = WebUI.getAttribute(findTestObject('Object Repository/GeneradorDatos_Page/txt_ped_web_106'), 'Value')

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'I', nFilaEnEjecucion, 
            strLote)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'J', nFilaEnEjecucion, 
            strFechaActual)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'K', nFilaEnEjecucion, 
            strFechaVencimiento)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'L', nFilaEnEjecucion, 
            strNumRemito)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'N', nFilaEnEjecucion, 
            strOcComiente)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'W', nFilaEnEjecucion, 
            strNumDespacho)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'X', nFilaEnEjecucion, 
            strDigVerNumDespacho)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'Y', nFilaEnEjecucion, 
            strFechaDespPlaza)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'Z', nFilaEnEjecucion, 
            strNumPedido)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AI', nFilaEnEjecucion, 
            strAltaLoteI105)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AJ', nFilaEnEjecucion, 
            strRemElectI141)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AK', nFilaEnEjecucion, 
            strPedidoClienteI089)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AL', nFilaEnEjecucion, 
            strPedidoDistI106)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AM', nFilaEnEjecucion, 
            strPedidoComitenteI101)

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'AZ', nFilaEnEjecucion, 
            'NO')

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'BA', nFilaEnEjecucion, 
            'NO')
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'BB', nFilaEnEjecucion,
			strPedWeb089)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'BC', nFilaEnEjecucion,
			strPedWeb101)
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_Andreani.xlsx', 'generador_datos', 'BD', nFilaEnEjecucion,
			strPedWeb106)

        if (i < nRowsEncontradas) {
            WebUI.delay(1)
			WebUI.refresh()
        }
    }
}

WebUI.closeBrowser()

