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
import org.sikuli.script.Key as Key
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'utilities.Tools.espera'(5000)

sap_logon = CustomKeywords.'utilities.Sap.Open_SAP_Logon'()

CustomKeywords.'utilities.Tools.espera'(7000)

if (sap_logon) {
    for (def index : (1..4)) {
        CustomKeywords.'utilities.Sap.typeDown'()

        CustomKeywords.'utilities.Tools.espera'(500)
    }
}

CustomKeywords.'utilities.Tools.espera'(2000)

CustomKeywords.'utilities.Sap.typeEnter'()

WebUI.callTestCase(findTestCase('100 _SAP/Login_Sap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('100 _SAP/Z_SD_CARGA_NC'), [('programa') : 'Z_SD_CARGA_NC'], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'utilities.Sap.Close_SAP'()

