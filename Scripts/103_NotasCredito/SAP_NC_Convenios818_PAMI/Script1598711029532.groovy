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

WebUI.callTestCase(findTestCase('DG_Archivos_Pami'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login_SAP'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nZ_SD_ENTRADA_NC_OOS'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Cdigo de Convenio_en_FNET'), '818')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Mandataria'), '1')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Mandataria'), Keys.chord(Keys.F8))

findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/input_Cdigo de Convenio_en_FNET')

assert !(WebUI.verifyElementHasAttribute(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/img_Error_archivo'), 'src', 5))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/Z_SD_ENTRADA_NC_OOS/span_Aceptar'))

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nZ_PROC_LIQ_OOSS'], FailureHandling.STOP_ON_FAILURE)

actualDate = new Date().format('dd.MM.yyyy')

println(actualDate)

day = actualDate.substring(0, 2)

month = actualDate.substring(3, 5)

year = actualDate.substring(6, 10)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Convenio'), '818')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Ao Liquidacion'), year)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Mes Liquidacion'), month)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Periodo_Liquidacion'), '1')

WebUI.delay(1)

WebUI.click(findTestObject('SAP/Z_PROC_LIQ_OOSS/span_Procesar Liq Pendientes'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/Z_PROC_LIQ_OOSS/input_Periodo_Liquidacion'), Keys.chord(Keys.F8))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/Z_PROC_LIQ_OOSS/span_Si'))

WebUI.delay(1)

//Si aparece el span de liquidaciones pendientes realizarle click
popup_msg = WebUI.verifyElementVisible(findTestObject('SAP/Prueba_pami_nc/a_'), FailureHandling.OPTIONAL)

WebUI.delay(1)

if (popup_msg) {
	
	WebUI.delay(2)
	
	clickable_popup_msg = WebUI.verifyElementClickable(findTestObject('SAP/Prueba_pami_nc/a_'), FailureHandling.OPTIONAL)
	
	if(clickable_popup_msg){
		
		WebUI.delay(2)
	
		WebUI.click(findTestObject('SAP/Prueba_pami_nc/a_'))
	}
}

//Aca necesito obtener el numero del pedido generado

WebUI.delay(2)
//obtnego la cantidad de filas

rows = WebUI.getAttribute(findTestObject('SAP/Pami_documento_solicitante/div_Texto de mensaje_tablagrande'),'segrc')

id = WebUI.getAttribute(findTestObject('SAP/Pami_documento_solicitante/div_Texto de mensaje_tablagrande'),'id')

WebUI.delay(1)

println(rows)
println(id) //33.126-mrss-cont-none
//id_input = id
largo = id.length()
String cadenaId
for (i=0;i < largo ; i++){
   if (id[i] == '.'){
	break
  }
  cadenaId =cadenaId+ id[i]
}
stringOut = cadenaId.substring(4)

WebUI.delay(1)
filas = Integer.parseInt(rows)
for (i=1 ; i < filas+1 ; i++){
	
	expresionProperty = 'grid#' + stringOut + '.126#' + i + ',2#if'	
	innerText = WebUI.getAttribute(findTestObject('SAP/Pami_documento_solicitante/input_Texto_fila_uno', ['expresionProperty' : expresionProperty ]),'value')	
	println(innerText)
	WebUI.delay(1)
	
	innerText =~ 'documento'
	if(innerText =~ 'documento'){
		def result = (innerText =~ /\d+/).findAll()
		println(result.get(2))
		CustomKeywords.'utilities.excel.setValueToCellInExcel'('db_archivo_pami.xlsx', 'output', 'A', i, result.get(2))
	}	
	println(i)	
}

WebUI.delay(2)

WebUI.callTestCase(findTestCase('101_Pages/01_Buscador_Trx'), [('trx') : '/nVF06'], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Organizacin de ventas'), 'FNET')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Canal de distribucin'), '10')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Sector'), '02')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Sector_hasta'), '36')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/VF06/input_Clase de factura'), 'ZNC1')

WebUI.delay(1)

row_control = findTestData('output_pami').getRowNumbers()
for(i=1 ; i < row_control+1;i++){
	
	documento_comercial = findTestData('output_pami').getValue('documento_comercial', i)
	if (documento_comercial !='' ){
		
		WebUI.sendKeys(findTestObject('SAP/VF06/input_Documento comercial_'), documento_comercial)
		break
	}
}

for(i=row_control;i > 0; i--){
	
	documento_comercial = findTestData('output_pami').getValue('documento_comercial', i)
	if(documento_comercial!=''){
		
		WebUI.sendKeys(findTestObject('SAP/VF06/input_Documento comercial hasta'), documento_comercial)
		break		
	}
	
}

//aca falta agregar el documento comercial

WebUI.delay(1)

WebUI.click(findTestObject('SAP/VF06/span_Entregas'))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/VF06/span_Pedidos'))

WebUI.delay(1)

WebUI.click(findTestObject('SAP/VF06/span_Inicinmediato'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'),  Keys.chord(Keys.F8))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('101_Pages/00_CloseSap'), [:], FailureHandling.STOP_ON_FAILURE)
