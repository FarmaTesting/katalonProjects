package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

import org.sikuli.script.Match
import org.sikuli.script.Region
import org.sikuli.script.FindFailed
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.script.Key
import org.sikuli.script.KeyModifier

import org.sikuli.script.ImagePath

import Tools

public class Sikuli {

	//user.dir C:\Users\moviedo\Katalon Studio\sce-farmanet-rya
	static String rutaImagenesABuscar = System.getProperty("user.dir") + "\\imagenesABuscar\\"

	Screen s = new Screen()
	Region r = new Region()
	Tools h = new Tools()



	/*
	 ********************************* METODOS ***********************
	 */


	def String rutaImagenesABuscar(String nombreimagen) {
		String imagen = rutaImagenesABuscar + nombreimagen + ".png"
		KeywordUtil.logInfo("ruta imagen a buscar " + imagen)
		return imagen
	}


	/*
	 ********************************* ACCIONES ***********************
	 */
	def void SelectRegionyClick(String imagenregion, String imagenclick) throws FindFailed {
		h.espera(500)
		Match f = s.find(rutaImagenesABuscar(imagenregion)).find(rutaImagenesABuscar(imagenclick))
		f.click()
	}

	def void SelectRegionyClickAll(String imagenregion, String imagenclick) throws FindFailed {
		Match f = s.find(rutaImagenesABuscar(imagenregion))
		Iterator<Match> r = f.findAll(rutaImagenesABuscar(imagenclick))
		r.next().click()
	}

	def void SelectRegionyDClick(String imagenregion, String imagenclick) throws FindFailed {
		s.wait(rutaImagenesABuscar(imagenregion), 10)
		Match f = s.find(rutaImagenesABuscar(imagenregion))
		h.espera(500)
		Region r = f.find(rutaImagenesABuscar(imagenclick))
		h.espera(500)
		r.doubleClick()
	}

	def void wait(String nombreimagen,int espera) throws FindFailed {
		s.wait(rutaImagenesABuscar(nombreimagen), espera)
	}
	/**
	 * Espera una imagen el tiempo que se le indique
	 * @param findnombreimage
	 * @param nombreimagen
	 * @throws FindFailed
	 */
	@Keyword
	def void waitImage(String nombreimagen, float similarity, int segundos) throws FindFailed {
		h.espera(500)

		Pattern p = new Pattern(rutaImagenesABuscar(nombreimagen))

		s.wait(p.similar(similarity), segundos)
	}
	/**
	 *
	 * @param nombreimagen
	 * @param similarity
	 * @throws FindFailed
	 */
	@Keyword
	def void clickSimilarity(String nombreimagen, float similarity) throws FindFailed {
		h.espera(500)

		Pattern p = new Pattern(rutaImagenesABuscar(nombreimagen))

		s.click(p.similar(similarity))
	}


	/**
	 * Marca en rojo segun las coordenadas un rectangulo en la pantalla
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param segundos
	 * @throws FindFailed
	 */
	@Keyword
	def void regionHighlight (int x, int y, int w, int h, int segundos) throws FindFailed {
		Region hx = new Region(x,y,w,h)
		hx.highlight(segundos)
	}


	/**
	 *
	 * @param espera
	 * @throws FindFailed
	 */

	def void wait(double espera) throws FindFailed {
		s.wait(espera)
	}


	/**
	 * Hace un click
	 * @param nombreimagen
	 * @throws FindFailed
	 */
	@Keyword
	def void click(String nombreimagen) {
		h.espera(500)
		Match findI = s.find(rutaImagenesABuscar(nombreimagen))

		findI.wait(rutaImagenesABuscar(nombreimagen), 5)
		findI.click(rutaImagenesABuscar(nombreimagen))
	}

	@Keyword
	def void clickFind(String findImage, String nombreimagen) {
		h.espera(500)
		Match findI = s.find(rutaImagenesABuscar(findImage))

		findI.wait(rutaImagenesABuscar(nombreimagen), 5)
		findI.click(rutaImagenesABuscar(nombreimagen))
	}




	def void rClick(String nombreimagen) throws FindFailed {
		s.wait(rutaImagenesABuscar(nombreimagen), 10)
		s.rightClick(rutaImagenesABuscar(nombreimagen))
	}


	def void find(String nombreimagen) throws FindFailed {
		h.espera(500)
		s.wait(rutaImagenesABuscar(nombreimagen), 60)
		h.espera(500)
		s.find(rutaImagenesABuscar(nombreimagen))
		h.espera(500)
	}

	@Keyword
	def void dclick(String nombreimagen) throws FindFailed {
		h.espera(500)
		s.wait(rutaImagenesABuscar(nombreimagen), 60)
		h.espera(500)
		s.doubleClick(rutaImagenesABuscar(nombreimagen))
		h.espera(500)
	}


	/**
	 * Escribe un texto
	 * @param nombreimagen
	 * @param txt
	 * @throws FindFailed
	 */
	@Keyword
	def void type(String txt) throws FindFailed {
		h.espera(500)
		r.type(txt)
	}

	/**
	 * Elimina texto
	 */
	@Keyword
	def void clearString (){
		h.espera(500)
		r.type("a",KeyModifier.CTRL)
		h.espera(500)
		r.type(Key.DELETE)
	}

	/*
	 * recibe un KeyModifier
	 */
	def void typeCtrl(int ctrl) {
		type(ctrl)
	}
	
	@Keyword
	def paste(String txt) {
		r.paste(txt)
	}


	def void clickandtype(String nombreimagen, String txt) throws FindFailed {
		h.espera(500)
		s.type(rutaImagenesABuscar(nombreimagen), txt)
	}

	def void dclickfocustype(String nombreimagen, int x, String txt) throws FindFailed {
		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
		imagen.setTargetOffset(x, 0)
		imagen.doubleClick()
		h.espera(500)
		type(txt)
	}

	def void clickfocustype(String nombreimagen, int x, String txt) throws FindFailed {
		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
		imagen.setTargetOffset(x, 0)
		h.espera(500)
		imagen.click()
		h.espera(500)
		type(txt)
		h.espera(500)
	}

	def void clickfocustype(String nombreimagen, int x, int y, String txt) throws FindFailed {
		h.espera(500)
		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
		h.espera(500)
		imagen.setTargetOffset(x, y)
		h.espera(500)
		imagen.click()
		h.espera(500)
		type(txt)
	}

	def void dclickfocustype(String nombreimagen, int x, int y, String txt) throws FindFailed {
		h.espera(500)
		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
		imagen.setTargetOffset(x, y)
		h.espera(500)
		imagen.doubleClick()
		h.espera(500)
		type(txt)
	}

	//	def void clickfocus(String nombreimagen, int x) throws FindFailed {
	//		h.espera(500)
	//		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
	//		imagen.setTargetOffset(x, 0)
	//		imagen.click()
	//		h.espera(500)
	//	}
	/**
	 * Hace click segun las cordenadas "x" "y"
	 * @param nombreimagen
	 * @param x
	 * @param y
	 * @throws FindFailed
	 */
	@Keyword
	def void clickfocus(String nombreimagen, int x, int y) throws FindFailed {
		h.espera(500)
		Match f = s.find(rutaImagenesABuscar(nombreimagen))

		Pattern p = new Pattern(rutaImagenesABuscar(nombreimagen))

		f.click(p.targetOffset(x, y))

	}

	/**
	 *
	 * @param nombreimagen
	 * @param similarity
	 * @param x
	 * @param y
	 * @throws FindFailed
	 */
	@Keyword
	def void clickSimilarTarget(String nombreimagen, float similarity, int x, int y) throws FindFailed {
		h.espera(500)
		//Match f = s.find(rutaImagenesABuscar(nombreimagen))

		Pattern p = new Pattern(rutaImagenesABuscar(nombreimagen))

		s.click(p.targetOffset(x, y).similar(similarity))

	}





	def void dclickfocus(String nombreimagen, int x, int y) throws FindFailed {
		h.espera(500)
		Match imagen = s.find(rutaImagenesABuscar(nombreimagen))
		imagen.setTargetOffset(x, y)
		imagen.doubleClick()
		h.espera(500)
	}


	def void KeyDown(String keys) {
		s.keyDown(keys)
	}

	def void KeyUp(String keys) {
		s.keyUp(keys)
	}

	/**
	 *
	 * @param nombreimagen
	 * @return valor: puede ser true o false
	 * @throws FindFailed
	 */
	@Keyword
	def boolean exists(String nombreimagen) throws FindFailed {
		boolean valor = true
		String imagen = rutaImagenesABuscar(nombreimagen)

		h.espera(500)
		if (s.exists(imagen)) {
			KeywordUtil.logInfo("Imagen encontrada")
			valor = true
		} else {
			KeywordUtil.logInfo("Imagen NO encontrada")
			valor = false
		}
		return valor
	}
	/**
	 *
	 * @param nombreimagen
	 * @param similarity
	 * @return
	 * @throws FindFailed
	 */
	@Keyword
	def boolean existsSimilar (String nombreimagen, float similarity) throws FindFailed {
		boolean valor = true
		String imagen = rutaImagenesABuscar(nombreimagen)

		Pattern p = new Pattern(imagen)


		h.espera(500)
		if (p.similar(similarity)) {
			KeywordUtil.logInfo("Imagen encontrada")
			valor = true
		} else {
			KeywordUtil.logInfo("Imagen NO encontrada")
			valor = false
		}
		return valor
	}


}
