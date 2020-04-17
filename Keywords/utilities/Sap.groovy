package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

import org.sikuli.script.Region
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.script.Key
import org.sikuli.script.FindFailed

public class Sap {

	Tools h = new Tools()
	Screen s = new Screen()
	Region r = new Region()

	@Keyword
	def Open_SAP_Logon() throws IOException {

		h.espera(2000)

		KeywordUtil.logInfo("Abriendo")

		String ruta = System.getProperty("user.dir") + "\\Resources\\"

		String archivo = "SAP_Logon.bat"
		String comando = "cmd /c start "

		String comandoCompleto = comando + ruta + archivo
		KeywordUtil.logInfo(comandoCompleto)

		Runtime.getRuntime().exec(comandoCompleto)
		KeywordUtil.logInfo("Abierto correctamente")

		return true
	}

	@Keyword
	def Close_SAP() throws IOException {
		KeywordUtil.logInfo("Cerrando")

		String process = "saplogon.exe"

		Runtime.getRuntime().exec("taskkill /F /IM " + process)
		KeywordUtil.logInfo("Cerrado correctamente")
	}

	@Keyword
	def typeTab() throws FindFailed {
		h.espera(500)
		r.type(Key.TAB)
	}

	@Keyword
	def typeEnter() throws FindFailed {
		h.espera(500)
		r.type(Key.ENTER)
	}

	@Keyword
	def typeDown() throws FindFailed {
		h.espera(500)
		r.type(Key.DOWN)
	}

	@Keyword
	def typeF8() throws FindFailed {
		h.espera(500)
		r.type(Key.F8)
	}
	
	@Keyword
	def typeRutaNC() throws FindFailed {
		
		String ruta = System.getProperty("user.dir") + "\\Resources\\" + "NC_ROMAN_QAS.csv"
		KeywordUtil.logInfo(ruta)
		
		h.espera(500)
		r.type(ruta)
	}
}
