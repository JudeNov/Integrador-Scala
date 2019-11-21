package yaaaar.misiones

import yaaaar.objetivos.{Barco, Objetivo}
import yaaaar.piratas.Pirata

class Saqueo(objetivo: Objetivo) extends Mision {

  override def esUtil(unPirata: Pirata): Boolean = unPirata.tieneCantidadDeMonedas(_ <= Saqueo.cantidadMaxima()) && unPirata.seAnimaASaquear(objetivo)

  override def cumpleRequisitoDeLaMision(unBarco: Barco): Boolean = objetivo.esVulnerableA(unBarco)

}

object Saqueo {
  var _cantidadMaxima = 0
  def cantidadMaxima():Int = _cantidadMaxima
  def cantidadMaxima(_cm: Int): Unit= _cantidadMaxima = _cm
}