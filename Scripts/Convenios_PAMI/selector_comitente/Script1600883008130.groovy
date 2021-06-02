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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

switch(comitente){
	case 'ALCON':
		KeywordUtil.logInfo('ALCON')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'11', false)
		WebUI.delay(1)
		break
	case 'ANDROMACO':
		KeywordUtil.logInfo('ANDROMACO')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'14', false)
		WebUI.delay(1)
		break
	case 'BAUSCH &amp; LOMB':
		KeywordUtil.logInfo('BAUSCH &amp; LOMB')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'12', false)
		WebUI.delay(1)
		break
	case 'BOEHRINGER ING.':
		KeywordUtil.logInfo('BOEHRINGER ING.')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'02', false)
		WebUI.delay(1)
		break
	case 'CASASCO':
		KeywordUtil.logInfo('CASASCO')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'03', false)
		WebUI.delay(1)
		break
	case 'GADOR':
		KeywordUtil.logInfo('GADOR')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'05', false)
		WebUI.delay(1)
		break
	case 'NOVARTIS':
		KeywordUtil.logInfo('NOVARTIS')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'06', false)
		WebUI.delay(1)
		break
	case 'NOVARTIS CONSUM':
		KeywordUtil.logInfo('NOVARTIS CONSUM')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'07', false)
		WebUI.delay(1)
		break
	case 'NOVARTIS VACUNA':
		KeywordUtil.logInfo('NOVARTIS VACUNA')	
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'08', false)
		WebUI.delay(1)
		break
	case 'SANOFI PASTEUR':
		KeywordUtil.logInfo('SANOFI PASTEUR')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'36', false)
		WebUI.delay(1)
		break
	case 'TAKEDA PHARMA S':
		KeywordUtil.logInfo('TAKEDA PHARMA S')
		WebUI.selectOptionByValue(findTestObject('Object Repository/Generador_Archivo_PAMI/comitente'),'10', false)
		WebUI.delay(1)
		break	
}