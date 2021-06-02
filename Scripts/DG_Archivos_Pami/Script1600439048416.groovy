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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Ingresar a la pagina http://fsrvtfs00hq/testing/NCPAMI.aspx
WebUI.openBrowser('http://fsrvtfs00hq/testing/NCPAMI.aspx')

WebUI.waitForPageLoad(10)

WebUI.maximizeWindow()

//WebUI.click(findTestObject('Generador_Archivo_PAMI/comitente'))

row_control = findTestData('DG_Archivo_PAMI').getRowNumbers()

for(i=1; i < row_control; i++){
	
	materiales = findTestData('DG_archivo_PAMI').getValue('materiales',i)
	
	//El metodo realiza una busqueda por regexp del material cargado en la variable materiales
	if (materiales!=''){
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/select_Materiales'), materiales, false)
		
		println("Se selecciona el material $materiales")
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Generador_Archivo_PAMI/input_Materiales'))
		
	}	
}

//comitente = findTestData('DG_archivo_PAMI').getValue('comitente',1)

for(i=1; i < row_control; i++){
	
	WebUI.delay(1)
	
	clientes = findTestData('DG_archivo_PAMI').getValue('clientes',i)
	
	if(clientes !=''){
		
		println("El cliente seleccionado es $clientes")
		
		WebUI.delay(1)
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/select_Clientes'), clientes, false)
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/Generador_Archivo_PAMI/input_Clientes'))
		
	}	
}
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Generador_Archivo_PAMI/input_Generar'))

WebUI.delay(1)

WebUI.closeBrowser()
