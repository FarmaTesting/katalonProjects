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

row_control = findTestData('control_jobs').getRowNumbers()

println(('***************** CANTIDAD DE REGISTROS: ' + row_control) + ' *****************')

for (int i = 1; i <= row_control; i++) {
    SAP_05_se37_WS_123 = findTestData('control_jobs').getValue('SAP_05_se37_WS_123', i)

    println(('***************** REGISTRO N: ' + i) + ' *****************')

    if (SAP_05_se37_WS_123 == 'false') {
        WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nse37'], FailureHandling.STOP_ON_FAILURE)

        //WebUI.delay(1)
        //WebUI.waitForElementVisible(findTestObject('SAP/general/txt_buscador_trx'), 10)
        //WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))
        //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/nse37')
        //WebUI.delay(1)
        //WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
        //WebUI.waitForElementVisible(findTestObject('SAP/se37_ws_123/txt_modulo_funciones'), 10)
        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_modulo_funciones'), 'z_mm_andr_recepcion')

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_modulo_funciones'), Keys.chord(Keys.F8))

        WebUI.delay(1)

        //def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()
        //cantidad de registros
        //println('Filas encontradas: ' + nRowsEncontradas)
        //for (int i = 1; i <= nRowsEncontradas; i++)
        def nRowEnEjecucion = i

        println('Ejecutando fila N: ' + nRowEnEjecucion)

        def mercIngresada = findTestData('DGScenarios').getValue('ingreso_123', nRowEnEjecucion)

        println('Fue ingresada?: ' + mercIngresada)

        if (mercIngresada != 'SI') {
            def numOrdenCompra = findTestData('DGScenarios').getValue('out_n_orden_compra', nRowEnEjecucion)

            WebUI.waitForElementPresent(findTestObject('SAP/se37_ws_123/txt_cabecera'), 10)

            //Seccion Cabecera a completar
            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/se37_ws_123/btn_cabecera'))

            WebUI.delay(1)

            WebUI.waitForElementPresent(findTestObject('SAP/se37_ws_123/txt_cab_po_numb_ref'), 15, FailureHandling.OPTIONAL)

            def cPoNumbRef = numOrdenCompra

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_cab_po_numb_ref'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_cab_po_numb_ref'), cPoNumbRef)

            WebUI.delay(1)

            def cDocDate = findTestData('DGScenarios').getValue('strFechaCreado', nRowEnEjecucion)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_cab_doc_date'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_cab_doc_date'), cDocDate)

            WebUI.delay(1)

            def cRefDocNo = findTestData('DGScenarios').getValue('out_oc_comitente', nRowEnEjecucion)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_cab_ref_doc_no'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_cab_ref_doc_no'), cRefDocNo)

            WebUI.delay(2)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

            WebUI.delay(1)

            WebUI.waitForElementPresent(findTestObject('SAP/se37_ws_123/btn_posicion'), 15, FailureHandling.OPTIONAL)

            //Seccion Posicion a completar
            WebUI.delay(1)

            WebUI.click(findTestObject('SAP/se37_ws_123/btn_posicion'))

            WebUI.delay(1)

            WebUI.waitForElementPresent(findTestObject('SAP/se37_ws_123/txt_pos_po_num_ref'), 15, FailureHandling.OPTIONAL)

            def pPoNumbRef = WebUI.concatenate('900000', findTestData('DGScenarios').getValue('out_n_remito', nRowEnEjecucion))

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_po_num_ref'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_po_num_ref'), pPoNumbRef)

            WebUI.delay(1)

            def pPoItemRef = '10'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_po_item_ref'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_po_item_ref'), pPoItemRef)

            WebUI.delay(1)

            def pMaterial = findTestData('DGScenarios').getValue('param_materiales', nRowEnEjecucion)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_material'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_material'), pMaterial)

            WebUI.delay(1)

            def pPlan = 'FA01'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_plan'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_plan'), pPlan)

            WebUI.delay(1)

            def pStge = '1000'

            WebUI.delay(1)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_stge'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_stge'), pStge)

            WebUI.delay(1)

            def pBatch = findTestData('DGScenarios').getValue('out_lote', nRowEnEjecucion)

            WebUI.delay(1)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_batch'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_batch'), pBatch)

            WebUI.delay(1)

            def pMov = '101'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_mov'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_mov'), pMov)

            WebUI.delay(1)

            def pStckType = '1'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_s'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_s'), pStckType)

            WebUI.delay(1)

            def pEntryQnt = findTestData('DGScenarios').getValue('param_cant_ingresar', nRowEnEjecucion)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_entry_qnt'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_entry_qnt'), pEntryQnt)

            WebUI.delay(1)

            def pEntUom = 'C/U'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_ent'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_ent'), pEntUom)

            WebUI.delay(1)

            def pPoNumber = numOrdenCompra

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_po_number'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_po_number'), pPoNumber)

            WebUI.delay(1)

            def pPoItem = '10'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_po_it'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_po_it'), pPoItem)

            WebUI.delay(1)

            def pItemText = 'Ingreso Automatizado'

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_item_text'))

            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_item_text'), pItemText)

            //		WebUI.click(findTestObject('SAP/se37_ws_123/btn_despl_derecha'))
            //		
            //		WebUI.click(findTestObject('SAP/se37_ws_123/btn_despl_derecha'))
            //		
            //		WebUI.click(findTestObject('SAP/se37_ws_123/btn_despl_derecha'))
            //		
            //		WebUI.click(findTestObject('SAP/se37_ws_123/btn_despl_derecha'))
            //		
            //		WebUI.click(findTestObject('SAP/se37_ws_123/btn_despl_derecha'))
            def pMoti = '1019'

            WebUI.delay(2)

            WebUI.click(findTestObject('SAP/se37_ws_123/btn_entrada_individual'))

            WebUI.delay(5)

            WebUI.click(findTestObject('SAP/se37_ws_123/txt_moti_entr_ind'))

            WebUI.delay(2)

            WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_moti_entr_ind'))

            WebUI.delay(2)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_moti_entr_ind'), pMoti)

            WebUI.delay(2)

            WebUI.click(findTestObject('Object Repository/SAP/se16n/btn_ok'))

            //        WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_moti'))
            //
            //        WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_moti'), pMoti)
            WebUI.delay(1)

            WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_po_item_ref'), Keys.chord(Keys.F3))

            WebUI.delay(3)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F8))

            WebUI.delay(2)

            CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AZ', 
                nRowEnEjecucion, 'SI')

            WebUI.delay(10)

            WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.F3))

            WebUI.delay(1)
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'F', i, 'true')
		
		WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    } else if ((SAP_05_se37_WS_123 == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}

/*WebUI.delay(2)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(2)*/

WebUI.closeBrowser()