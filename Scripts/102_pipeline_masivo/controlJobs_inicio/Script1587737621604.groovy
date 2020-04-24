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

row_control = findTestData('control_jobs').getRowNumbers()

for (int i = 1; i <= row_control; i++) {
	
	a = i.toString()
	
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'A', i, a)
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'B', i, 'false')
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'C', i, 'false')
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'D', i, 'false')
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'F', i, 'false')
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'I', i, 'false')
	CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_farmanet_escenarios_t.xlsx', 'control_jobs', 'J', i, 'false')
}