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

nRows = findTestData('DGScenarios').getRowNumbers()

def listPedidoSap89_101 = []

def sortListPedidoSap89_101 = []

for (int i = 1; i <= nRows; i++) {
	
	pedidoSap89 = findTestData('DGScenarios').getValue('strNumPedidoSap89', i)
	
	if(pedidoSap89 != ''){
		listPedidoSap89_101.add(pedidoSap89)
	}
	
}

for (int i = 1; i <= nRows; i++) {
	
	pedidoSap101 = findTestData('DGScenarios').getValue('strNumPedidoSap101', i)
	
	if (pedidoSap101 != '') {
	
		listPedidoSap89_101.add(pedidoSap101)
	
	}
}

sortListPedidoSap89_101 = listPedidoSap89_101.sort()

println (sortListPedidoSap89_101.size())

println (sortListPedidoSap89_101)

