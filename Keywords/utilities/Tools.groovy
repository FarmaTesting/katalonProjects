package utilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

import org.openqa.selenium.Keys as Keys



/**
 * @author alflopez-ext
 *
 */
class Tools {
	/**
	 * Separa las horas de los minutos y suma 08' mins para buscar como resultado
	 * @param sumarMinutos
	 * @return
	 */
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

	/**
	 * Gets date in forma dd.mm.yyy
	 * @return formattedDate
	 */
	@Keyword
	def dateSap() {
		def formattedDate = new Date().format('dd.MM.yyyy')
		return formattedDate
	}

	/**
	 * Verifica que Row va a usar
	 * @return
	 */
	@Keyword
	def rowQueUsa() {
		for (int i = 1; i <= findTestData('DGScenarios').getRowNumbers(); i++) {
			fechacorrido = findTestData('DGScenarios').getValue('strFechaCreado', i)
			actualDate = new Date().format('dd.MM.yyyy')
			if (fechacorrido != actualDate) {
				rowFound = i
			}
			break
		}
		return rowFound
	}


	/**
	 * Deslogueo de SAP sin importar que pantallaeste usando
	 */
	@Keyword
	def salirDeSap() {
		if (WebUI.waitForElementPresent(findTestObject('SAP/general/txt_buscador_trx'), 15)){
			WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), '/n')
			WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('SAP/general/btn_salir_del_sistema'))
			WebUI.click(findTestObject('SAP/general/btn_salir_sistema_si'))
			WebUI.closeBrowser()
		}
	}

	@Keyword
	def atrasF3() {
		Keys.chord(Keys.F3)
	}

	@Keyword
	def enter (){
		Keys.chord(Keys.ENTER)
	}

	/**
	 * Metodo que duerme la ejecución
	 * @param milisec
	 */
	@Keyword
	def void espera(long milisec) {
		try {
			Thread.sleep(milisec)
		}
		catch (InterruptedException e) {
			e.printStackTrace()
		}
	}

	@Keyword
	def void log (String title, boolean var){
		KeywordUtil.logInfo(title + " " + var)

	}


	@Keyword
	def List pedidosSap89_101 (int nRows, String dataFile) {

		def listPedidoSap89_101 = []

		def sortListPedidoSap89_101 = []

		for (int i = 1; i <= nRows; i++) {
			String pedidoSap89 = findTestData(dataFile).getValue('strNumPedidoSap89', i)

			if (pedidoSap89 != '') {
				listPedidoSap89_101.add(pedidoSap89)
			}
		}

		for (int i = 1; i <= nRows; i++) {
			String pedidoSap101 = findTestData(dataFile).getValue('strNumPedidoSap101', i)

			if (pedidoSap101 != '') {
				listPedidoSap89_101.add(pedidoSap101)
			}
		}

		sortListPedidoSap89_101 = listPedidoSap89_101.sort()

		String menor = sortListPedidoSap89_101.get(0)

		println('******** menor: ' + menor)

		String mayor = sortListPedidoSap89_101.get(sortListPedidoSap89_101.size() - 1)

		println('******* mayor: ' + mayor)

		def menor_mayor = []

		menor_mayor.add(menor)
		menor_mayor.add(mayor)

		return menor_mayor

	}


}