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

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.imageio.ImageIO

import javax.swing.JOptionPane
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.TakesScreenshot
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.SAXException
import org.apache.commons.io.FileUtils
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.openqa.selenium.OutputType

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter

import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

public class excel {


	/**
	 * Ingresa un valor en una celda y guarda el cambio
	 *
	 * @param excelFile
	 * @param sheet
	 * @param column
	 * @param row
	 * @param value
	 * @return
	 */
	@Keyword
	def setValueToCellInExcel(String excelFile, String sheet, String column, int row, String value){
		String pathUserDir = System.getProperty("user.dir")
		String pathExcels = pathUserDir + '\\Resources\\'
		String excelFile01 = pathExcels + excelFile

		KeywordUtil.logInfo(excelFile01)

		// Verify files are created
		File file1 = new File(excelFile01)
		boolean fileRead = file1.canRead()
		boolean fileWrite = file1.canWrite()
		boolean fileExists = file1.exists()
		KeywordUtil.logInfo("Exist: " + fileExists + " || Read: " + fileRead + " || Write: " + fileWrite)

		assert fileExists == true

		Workbook workbook01 = ExcelKeywords.getWorkbook(excelFile01)
		Sheet sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheet)


		int rowIndex = row + 1
		String cell = column + rowIndex
		ExcelKeywords.setValueToCellByAddress(sheet01, cell, value)

//		Calendar hoy = Calendar.getInstance()
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
//		String formatted = format1.format(hoy.getTime())
//
//		int rowDate = row + 1
//		String c = "C" + rowDate
//		ExcelKeywords.setValueToCellByAddress(sheet01, c, formatted)

		ExcelKeywords.saveWorkbook(excelFile01, workbook01)
		KeywordUtil.logInfo(value + " - Data saved")
		KeywordUtil.markPassed("Saved successfully")


	}
}
