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
import groovy.time.TimeCategory as TimeCategory
import java.lang.Integer as Integer
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

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
//def testVariable = findTestData('DGScenarios').getValue('out_n_pedido_sap', 1)
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AR', 1, testVariable)
//WebUI.getText(findTestObject('null'))
//WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.delay(2)
//WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 0)
//WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.SHIFT, Keys.F3))
//WebUI.sendKeys(findTestObject('SAP/btn_si'), Keys.chord(Keys.TAB))
//WebUI.sendKeys(findTestObject('SAP/btn_si'), Keys.chord(Keys.TAB))
//WebUI.sendKeys(findTestObject('SAP/btn_si'), Keys.chord(Keys.TAB))
//WebUI.sendKeys(findTestObject('SAP/btn_si'), Keys.chord(Keys.ENTER))
//actualDate = new Date()
//def formattedDate = actualDate.format('dd.MM.yyyy')
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AT', 1, formattedDate)
//def dateHour = actualDate.format('HH:mm')
//parseMins = (dateHour.split(':')[1])
//--------------------------------------------------------
//def String[] splitHours = HoraOrigen.split(':')
//println(splitHours[0])
//println(splitHours[1])
//splitHours[1] = Integer.parseInt(splitHours[1])
//println(splitHours[1])
//splitHours[1] = splitHours[1] + 10
//println(splitHours[1])
//horaHasta = splitHours[0] + splitHours[1]
//println(horaHasta)
//horaHasta = splitHours[0] + ':' + splitHours[1]
//println(horaHasta)
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AU', 1, horaHasta)
//--------------------------------------------------------
//def sumaMinutos = findTestData('DGScenarios').getValue('strHoraCreado', 1)
//def String[] splitHours = sumaMinutos.split(':')
//def splitMinutos = Integer.parseInt(splitHours[1])
//def splitMinutosTotal = splitMinutos + 10
//def horaHasta = splitHours[0] + ':' + splitMinutosTotal
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AU', 1, horaHasta)
//--------------------------------------------------------
//horaHasta = CustomKeywords.'utilities.tools.sumarMinutos'(findTestData('DGScenarios').getValue('strHoraCreado', 1))
//
//CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios.xlsx', 'generador_datos', 'AU', 1, horaHasta)

actualDate = new Date().format('dd.MM.yyyy')
//def formattedDate = actualDate.format('dd.MM.yyyy')
println (actualDate)
