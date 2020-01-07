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

WebUI.waitForElementVisible(findTestObject('SAP/txt_buscador_trx'), 0)

WebUI.click(findTestObject('SAP/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), '/nse16n')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscador_tablas'), 0)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), 'vbak')

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscador_tablas'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_1_3_3_tercera_celda_filtro'), 0)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_tercera_celda_filtro'), '02.01.2020')

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_3_3_tercera_celda_filtro'), Keys.chord(Keys.CONTROL, 'f'))

WebUI.waitForElementVisible(findTestObject('SAP/txt_se16n_buscar_filtro'), 0)

WebUI.sendKeys(findTestObject('SAP/txt_se16n_buscar_filtro'), 'N° Interno')

WebUI.click(findTestObject('SAP/btn_ok'))

WebUI.sendKeys(findTestObject('SAP/txt_se16n_1_1_3_primer_celda_filtro'), '12312')

WebUI.sendKeys(findTestObject('SAP/txt_buscador_trx'), Keys.chord(Keys.F8))

