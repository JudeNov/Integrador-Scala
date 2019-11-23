package yaaaar.misiones

import Yaaaar.Item
import yaaaar.objetivos.Barco
import yaaaar.piratas.Pirata

class BusquedaDelTesoro(val objetosRequeridos: List[Item]) extends Mision {

  override def esUtil(unPirata: Pirata): Boolean = unPirata.tiene(objetosRequeridos) && unPirata.tieneCantidadDeMonedas(_ <=5)

  override def cumpleRequisitoDeLaMision(unBarco: Barco): Boolean = unBarco.tiene("llave de cofre")

}
