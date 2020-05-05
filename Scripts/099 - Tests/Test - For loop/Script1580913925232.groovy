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

row_control = findTestData('control_jobs').getRowNumbers()

println(('***************** CANTIDAD DE REGISTROS: ' + row_control) + ' *****************')

WebUI.openBrowser(GlobalVariable.url_gd)

WebUI.waitForPageLoad(10)

for (int i = 1; i <= row_control; i++) {
    DG_Generacion_Pedido = findTestData('control_jobs').getValue('DG_Generacion_Pedido', i)

    println(('********************** REGISTRO N: ' + i) + ' **********************')

    if (DG_Generacion_Pedido == 'false') {
        materiales = findTestData('DGScenarios').getValue('param_materiales', i)

        println('proceso un registro: ' + materiales)

        if (i < row_control) {
            WebUI.delay(1)

            WebUI.refresh()
        }
        
        CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'B', i, 'true')
    } else if ((DG_Generacion_Pedido == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}

WebUI.delay(2)

WebUI.closeBrowser()