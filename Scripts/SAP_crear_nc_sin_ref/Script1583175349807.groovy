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

CustomKeywords.'utilities.Sikuli.dclick'('iconoescritorio')

CustomKeywords.'utilities.Sikuli.dclick'('ambienteqasinsso')

not_run: CustomKeywords.'utilities.Sikuli.click'('user')

CustomKeywords.'utilities.Sikuli.waitImage'('user', 5, 5)

CustomKeywords.'utilities.Sikuli.type'('tester')

CustomKeywords.'utilities.Sikuli.click'('clave')

CustomKeywords.'utilities.Sikuli.type'('Suma2020')

CustomKeywords.'utilities.Sikuli.click'('btnok')

