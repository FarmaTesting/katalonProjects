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

WebUI.delay(2)

WebUI.click(findTestObject('SAP/general/txt_buscador_trx'))

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), trx)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('SAP/general/txt_buscador_trx'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

switch (trx) {
    case '/nse16n':
        KeywordUtil.logInfo('/nse16n')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'name', ('toObject') : findTestObject(
                    'SAP/se16n/txt_se16n_buscador_tablas'), ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        break
    case '/nz_sd_libera_pedidos':
        KeywordUtil.logInfo('/nz_sd_libera_pedidos')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/z_sd_libera_pedidos/txt_bloqueo_buscar')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        break
    case '/nz_sd_punto_arranque':
        KeywordUtil.logInfo('/nz_sd_punto_arranque')

        WebUI.callTestCase(findTestCase('101_Pages/00_Wait'), [('attributeName') : 'id', ('toObject') : findTestObject('SAP/z_sd_punto_arranque/txt_nro_doc_comercial_n_pedidosap')
                , ('timeOut') : 5], FailureHandling.STOP_ON_FAILURE)

        break
    default:
        KeywordUtil.logInfo('trx desconocido')

        assert false

        break
}