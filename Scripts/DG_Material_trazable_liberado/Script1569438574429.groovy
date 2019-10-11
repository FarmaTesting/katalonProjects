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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://fsrvtfs00hq/testing/ingreso_mercaderia.aspx')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_/select_DesarrolloCalidad'), 'qas', true)

WebUI.setText(findTestObject('Object Repository/Page_/input_Materiales (Separados por )_materialesTxt'), findTestData('DBAutomatizaciones').getValue(
        1, 1))

WebUI.click(findTestObject('Object Repository/Page_/input_Solo Trazables_trazablesChk'))

WebUI.click(findTestObject('Object Repository/Page_/input_Tipo Material_aceptarBtn'))

WebUI.click(findTestObject('Object Repository/Page_/input_Tipo Material_generarBtn'))

WebUI.closeBrowser()

