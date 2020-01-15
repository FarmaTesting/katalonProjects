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

//strTotalRows == findTestData('Data Files/DGScenarios').getRowNumbers()
//strLote == findTestData('DGScenarios').getValue(1, rowNum)
//if (strLote != '') {
//	WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), strLote)
//}
//for (def rowNum = 2; rowNum <= findTestData('Data Files/DGScenarios').getRowNumbers(); rowNum++) {
//}
//WebUI.openBrowser('')
//WebUI.navigateToUrl(GlobalVariable.url)
//for (def rowNum = 2; rowNum <= findTestData('DGScenarios').getRowNumbers(); rowNum++) {
//WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), ambiente, false)
//WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), findTestData('DGScenarios').getValue(
//        1, rowNum), false)
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AR', rowNum, 'SI')
//}
//ambiente = findTestData('DGScenarios').getValue(1, 1)
//WebUI.openBrowser('')
//WebUI.navigateToUrl(GlobalVariable.url)
//WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_ambiente'), findTestData('DGScenarios').getValue(1, 1), false)
def testVariable = findTestData('DGScenarios').getValue('out_n_pedido_sap', 1)

CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AR', 1, testVariable)

WebUI.getText(findTestObject('null'))

