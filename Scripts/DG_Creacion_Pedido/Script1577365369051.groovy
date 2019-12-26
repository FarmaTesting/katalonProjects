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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

if (ambiente != '') {
    WebUI.selectOptionByLabel(findTestObject('GeneradorDatos_Page/ddwn_Ambiente'), ambiente, false)
}

if (materiales != '') {
    WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_Materiales'), materiales, FailureHandling.CONTINUE_ON_FAILURE)
}

if (comitente != '') {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/GeneradorDatos_Page/ddwn_Comitente'), comitente, false)
}

if (trazable != '\'OFF\'') {
    WebUI.uncheck(findTestObject('Object Repository/GeneradorDatos_Page/chk_Solo_Trazables'))
} else if (trazable == 'ON') {
    WebUI.check(findTestObject('GeneradorDatos_Page/chk_Solo_Trazables'))
}

if (crear_pedido != '\'OFF\'') {
    WebUI.uncheck(findTestObject('Object Repository/GeneradorDatos_Page/chk_Crear_Pedidos'))
} else if (crear_pedido == 'ON') {
    WebUI.check(findTestObject('GeneradorDatos_Page/chk_Crear_Pedidos'))
}

if (tipo_material != '') {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/GeneradorDatos_Page/ddwn_Tipo_Material'), tipo_material, 
        false)
}

if (cant_ingresar != '') {
    WebUI.sendKeys(findTestObject('GeneradorDatos_Page/txt_Cantidad_A_Ingresar'), cant_ingresar)
}

if (filtrar != 'SI') {
    WebUI.click(findTestObject('GeneradorDatos_Page/btn_Filtrar'))
}

if (generar != 'SI') {
    WebUI.click(findTestObject('GeneradorDatos_Page/btn_Generar'))
}

