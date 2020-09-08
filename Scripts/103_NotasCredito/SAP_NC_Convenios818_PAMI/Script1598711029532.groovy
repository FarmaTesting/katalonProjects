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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nZ_SD_ENTRADA_NC_OOS'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Cdigo de Convenio_en_FNET'), '818')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Mandataria'), '1')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Mandataria'), Keys.chord(Keys.F8))

findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Cdigo de Convenio_en_FNET')

assert  !(WebUI.verifyElementHasAttribute(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/img_Error_archivo'), 'src', 5))

//Se deben visualizar Resumende Novedades Recibidas - Cabecera - Detalle
//Falta agregar click en el boton aceptar
WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nZ_PROC_LIQ_OOSS'], FailureHandling.STOP_ON_FAILURE)

actualDate = new Date().format('dd.MM.yyyy')

println(actualDate)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Convenio'), '818')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Ao Liquidacion'), '2020')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Mes Liquidacion'), '7')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Periodo_Liquidacion'), '1')

WebUI.delay(1)

WebUI.click(findTestObject('SAP/Z_PROC_LIQ_OOSS/span_Procesar Liq Pendientes'))

// Falta agregar click en boton si para desear continuar
//Falta agregar obtener el numero de pedido generado 0061143437
// Ingressamos a la VF06
WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nVF06'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Organizacin de ventas'), 'FNET')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Canal de distribucin'), '10')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Sector'), '36')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Clase de factura'), 'ZNC1')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Solicitante'), solicitante)

WebUI.delay(1)

WebUI.click(findTestObject('SAP/Z_PROC_LIQ_OOSS/span_Procesar Liq Pendientes'))

