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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.delay(1)

WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), trx)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

switch (trx) {
    case '/nse16n':
        KeywordUtil.logInfo('/nse16n')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'name', ('toObject') : findTestObject(
                    'SAP/se16n/txt_se16n_buscador_tablas'), ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nse37':
        KeywordUtil.logInfo('/nse37')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'name', ('toObject') : findTestObject(
                    'SAP/se37_ws_123/txt_modulo_funciones'), ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nwe19':
        KeywordUtil.logInfo('/nwe19')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/se19_ws_125/txt_idoc_a_buscar')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nvkm4':
        KeywordUtil.logInfo('/nvkm4')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'name', ('toObject') : findTestObject(
                    'SAP/vkm4/txt_doc_comercial_n_pedido_sap'), ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nz_sd_libera_pedidos':
        KeywordUtil.logInfo('/nz_sd_libera_pedidos')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nz_sd_punto_arranque':
        KeywordUtil.logInfo('/nz_sd_punto_arranque')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
    case '/nz_sd_doc_comit':
        KeywordUtil.logInfo('/nz_sd_doc_comit')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/factura_remito/txt_comitente')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        break
	case '/nva01':
		KeywordUtil.logInfo('/nva01')

		WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'title', ('toObject') : findTestObject('SAP/nva01/txt_tipo_pedido')
				, ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(1)

		break
		
	case '/nvf01':
		KeywordUtil.logInfo('/nvf01')

		WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/vf01/txt_nc_documento')
				, ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(1)

		break
		
    default:
        KeywordUtil.logInfo('trx desconocido')

        assert false

        break
}