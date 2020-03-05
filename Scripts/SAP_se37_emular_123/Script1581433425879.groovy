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

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 10)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nse37')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/SAP/se37_ws_123/txt_modulo_funciones'), 10)

WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_modulo_funciones'), 'z_mm_andr_recepcion')

WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_modulo_funciones'), Keys.chord(Keys.F8))

def nRowsEncontradas = findTestData('DGScenarios').getRowNumbers()

println('Filas encontradas: ' + nRowsEncontradas)

for (int i = 1; i <= nRowsEncontradas; i++) {
    def nRowEnEjecucion = i

    println('Ejecutando fila N: ' + nRowEnEjecucion)

    def mercIngresada = findTestData('DGScenarios').getValue('ingreso_123', nRowEnEjecucion)

    println('Fue ingresada?: ' + mercIngresada)

    if (mercIngresada != 'SI') {
        def numOrdenCompra = findTestData('DGScenarios').getValue('out_n_orden_compra', nRowEnEjecucion)

        WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se37_ws_123/txt_cabecera'), 10)

        //Seccion Cabecera a completar
        WebUI.click(findTestObject('Object Repository/SAP/se37_ws_123/btn_cabecera'))

        WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_po_numb_ref'), 15, FailureHandling.OPTIONAL)

        def cPoNumbRef = numOrdenCompra

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_po_numb_ref'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_po_numb_ref'), cPoNumbRef)

        def cDocDate = findTestData('DGScenarios').getValue('strFechaCreado', nRowEnEjecucion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_doc_date'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_doc_date'), cDocDate)

        def cRefDocNo = findTestData('DGScenarios').getValue('out_oc_comitente', nRowEnEjecucion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_ref_doc_no'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_cab_ref_doc_no'), cRefDocNo)

        WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F3))

        WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se37_ws_123/btn_posicion'), 15, FailureHandling.OPTIONAL)

        //Seccion Posicion a completar
        WebUI.click(findTestObject('Object Repository/SAP/se37_ws_123/btn_posicion'))

        WebUI.waitForElementPresent(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_num_ref'), 15, FailureHandling.OPTIONAL)

        def pPoNumbRef = WebUI.concatenate('900000', findTestData('DGScenarios').getValue('out_n_remito', nRowEnEjecucion))

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_num_ref'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_num_ref'), pPoNumbRef)

        def pPoItemRef = '10'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_item_ref'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_item_ref'), pPoItemRef)

        def pMaterial = findTestData('DGScenarios').getValue('param_materiales', nRowEnEjecucion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_material'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_material'), pMaterial)

        def pPlan = 'FA01'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_plan'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_plan'), pPlan)

        def pStge = '1000'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_stge'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_stge'), pStge)

        def pBatch = findTestData('DGScenarios').getValue('out_lote', nRowEnEjecucion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_batch'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_batch'), pBatch)

        def pMov = '101'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_mov'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_mov'), pMov)

        def pStckType = '1'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_s'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_s'), pStckType)

        def pEntryQnt = findTestData('DGScenarios').getValue('param_cant_ingresar', nRowEnEjecucion)

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_entry_qnt'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_entry_qnt'), pEntryQnt)

        def pEntUom = 'C/U'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_ent'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_ent'), pEntUom)

        def pPoNumber = numOrdenCompra

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_number'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_number'), pPoNumber)

        def pPoItem = '10'

        WebUI.clearText(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_it'))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_it'), pPoItem)

        def pItemText = 'Ingreso Automatizado'

        WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_item_text'))

        WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_item_text'), pItemText)

        def pMoti = '1019'

        WebUI.clearText(findTestObject('SAP/se37_ws_123/txt_pos_moti'))

        WebUI.sendKeys(findTestObject('SAP/se37_ws_123/txt_pos_moti'), pMoti)

        WebUI.delay(1)

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/txt_pos_po_item_ref'), Keys.chord(Keys.F3))

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/btn_posicion'), Keys.chord(Keys.F8))

        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AZ', nRowEnEjecucion, 
            'SI')

        WebUI.delay(10)

        WebUI.sendKeys(findTestObject('Object Repository/SAP/se37_ws_123/btn_posicion'), Keys.chord(Keys.F3))
    }
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), '/n')

WebUI.sendKeys(findTestObject('Object Repository/SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.closeBrowser()

