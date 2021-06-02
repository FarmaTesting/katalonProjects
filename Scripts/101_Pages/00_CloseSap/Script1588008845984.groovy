import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

def estoyLogueadoEnPantallaPrincipal = WebUI.verifyElementPresent(findTestObject('SAP/general/txt_Titulo'), 3, FailureHandling.OPTIONAL)

if (estoyLogueadoEnPantallaPrincipal) {
    WebUI.delay(1)

    WebUI.click(findTestObject('SAP/general/btn_salir_del_sistema'))

    WebUI.delay(2)

    WebUI.click(findTestObject('SAP/general/btn_salir_sistema_si'))

    WebUI.delay(1)

    WebUI.closeBrowser()
} else {
    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')

    WebUI.delay(1)

    WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

    WebUI.delay(2)

    WebUI.click(findTestObject('SAP/general/btn_salir_del_sistema'))

    WebUI.delay(2)

    WebUI.click(findTestObject('SAP/general/btn_salir_sistema_si'))

    WebUI.delay(1)

    WebUI.closeBrowser()
}

