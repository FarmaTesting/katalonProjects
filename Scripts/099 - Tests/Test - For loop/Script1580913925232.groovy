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

row_control = findTestData('DGScenarios').getRowNumbers()

println(('***************** CANTIDAD DE REGISTROS: ' + row_control) + ' *****************')

/*def listPedidoSap89_101 = []
def sortListPedidoSap89_101 = []
for (int i = 1; i <= 36; i++) {
	listPedidoSap89_101.add(findTestData('DGScenarios').getValue(41, i))
}
for (int i = 1; i <= 36; i++) {
	listPedidoSap89_101.add(findTestData('DGScenarios').getValue(42, i))
}
sortListPedidoSap89_101 = listPedidoSap89_101.sort()
println sortListPedidoSap89_101*/


for (int i = 1; i <= row_control; i++) {
    DG_Generacion_Pedido = findTestData('control_jobs').getValue('DG_Generacion_Pedido', i)

    println(('********************** REGISTRO N: ' + i) + ' **********************')

    if (DG_Generacion_Pedido == '') {
		
		println ('*********** entro *********')
		
		//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'B', i, 'true')
		
    } else if ((DG_Generacion_Pedido == 'true') && (i == row_control)) {
        println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

        assert true

        break
    }
}