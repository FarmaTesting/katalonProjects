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

row_control = findTestData('DGScenarios').getRowNumbers()

println(('******************* CANTIDAD DE REGISTROS: ' + row_control) + ' ********************')

for (int i = 1; i <= row_control; i++) {
	SUMANET_liberacion_calidad = findTestData('control_jobs').getValue('SUMANET_liberacion_calidad', i)
	comitente = findTestData('DGScenarios').getValue('param_comitente', i)
	param_materiales = findTestData('DGScenarios').getValue('param_materiales', i)
	param_ingresa_cuarentena = findTestData('DGScenarios').getValue('param_ingresa_cuarentena', i)
	lote = findTestData('DGScenarios').getValue('out_lote', i) 

	println(('****************** REGISTRO N: ' + i) + ' ********************')

	if (SUMANET_liberacion_calidad == '' && comitente !='' && param_materiales !='' && param_ingresa_cuarentena == 'ON') {		
		
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl(GlobalVariable.url)
		
		WebUI.waitForPageLoad(10)
		
		WebUI.maximizeWindow()
		
		WebUI.setText(findTestObject('Sumanet/txt_sumanet_user1'), GlobalVariable.user)
		
		WebUI.setText(findTestObject('Sumanet/txt_sumanet_pass1'), GlobalVariable.pass)
		
		WebUI.click(findTestObject('Sumanet/btn_sumanet_login1'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Sumanet/img_Gestion_Lotes'))
		
		WebUI.delay(1)
		
		WebUI.mouseOver(findTestObject('Sumanet/menu_Gestion_Lotes'))
			
		WebUI.delay(1)
		
		WebUI.mouseOver(findTestObject('Sumanet/a_ProductoLote para liberar estado de cuarentena'))
		
		WebUI.click(findTestObject('Sumanet/a_ProductoLote para liberar estado de cuarentena'))
		
		WebUI.delay(1)
		
		WebUI.sendKeys(findTestObject('Sumanet/select_comitente'), comitente)
		
		WebUI.sendKeys(findTestObject('Sumanet/select_comitente'), Keys.chord(Keys.ENTER))
		
		WebUI.delay(1)
		
		WebUI.sendKeys(findTestObject('Sumanet/input_Producto'), param_materiales)
		
		WebUI.mouseOver(findTestObject('Sumanet/ui_menu_producto'))
		
		WebUI.click(findTestObject('Sumanet/ui_menu_producto'))
				
		WebUI.delay(1)
		
		WebUI.sendKeys(findTestObject('Sumanet/input_Lote'), lote)
		
		WebUI.mouseOver(findTestObject('Sumanet/ui_menu_Lote'))
		
		WebUI.click(findTestObject('Sumanet/ui_menu_Lote'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Sumanet/input_btn_Liberar'))
		
		WebUI.delay(1)
		
		//WebUI.takeScreenshot()
		
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'control_jobs', 'O', i, 'true')
		
		WebUI.closeBrowser()
		
	} else if ((SUMANET_liberacion_calidad == 'true') && (i == row_control)) {
		
		println('<<<<<<<<<<<<<< FIN >>>>>>>>>>>>>>>')

		assert true

		break
	}
}






