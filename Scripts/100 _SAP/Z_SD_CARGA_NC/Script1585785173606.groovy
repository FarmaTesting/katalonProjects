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

CustomKeywords.'utilities.Sikuli.type'(programa)

CustomKeywords.'utilities.Tools.espera'(2000)

CustomKeywords.'utilities.Sap.typeEnter'()

CustomKeywords.'utilities.Tools.espera'(3000)

//ingresa la ruta donde esta guardado el csv que contiene las notas de credito
CustomKeywords.'utilities.Sikuli.paste'('C:\\FarmaTesting\\katalonProjects\\Resources\\NC_ROMAN_QAS.csv')

CustomKeywords.'utilities.Tools.espera'(2000)

CustomKeywords.'utilities.Sap.typeF8'()

CustomKeywords.'utilities.Tools.espera'(10000)

