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

///**
// * Separa las horas de los minutos y suma 08' mins para buscar como resultado
// * @param sumarMinutos
// * @return
// */
@Keyword
def sumarMinutos(String sumarMinutos) {
	//def sumarMinutos = findTestData('DGScenarios').getValue('strHoraCreado', 1)
	def String[] splitHours = sumarMinutos.split(':')
	def splitMinutos = Integer.parseInt(splitHours[1])
	def splitMinutosTotal = splitMinutos + 10
	if (splitMinutosTotal >= 60){
		splitMinutosTotal = 59
	}
	def horaHasta = splitHours[0] + ':' + splitMinutosTotal
	return horaHasta
}