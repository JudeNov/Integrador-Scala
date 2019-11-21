package yaaaar.misiones

import yaaaar.objetivos.Barco
import yaaaar.piratas.Pirata

class BusquedaDelTesoro(objetosRequeridos: List[String]) extends Mision {

  override def esUtil(unPirata: Pirata): Boolean = unPirata.tiene(objetosRequeridos) && unPirata.tieneCantidadDeMonedas(_ <=5)

  override def cumpleRequisitoDeLaMision(unBarco: Barco): Boolean = unBarco.tiene("llave de cofre")

}
