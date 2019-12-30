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

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://fsapfeq00:8000/sap/bc/gui/sap/its/webgui?sap-client=200&sap-language=ES')

WebUI.setText(findTestObject('Object Repository/Page_SAP Easy Access - Men usuario p TESTER/input_Men_ToolbarOkCode'), 'mm02')

WebUI.setText(findTestObject('Object Repository/Page_Modificar material (Acceso)/input_Material___AGIM0U117'), '1026')

WebUI.click(findTestObject('Page_Modificar material 1026 (Productivos)/input_Material___AGIM0U121031'))

WebUI.click(findTestObject('Object Repository/Page_Modificar material (Acceso)/img_Seleccin de vistas slo a peticin___AGIM1D60-img'))

WebUI.setText(findTestObject('Object Repository/Page_Modificar material 1026 (Productivos)/input_Material___AGIM0U121031'), 
    'VIRAMUNE X 60 COMP.')

WebUI.click(findTestObject('Object Repository/Page_Modificar material 1026 (Productivos)/span_Grabar'))

WebUI.closeBrowser()

