package yaaaar.misiones

import yaaaar.objetivos.{Barco, Objetivo}
import yaaaar.piratas.Pirata

class Saqueo(val objetivo: Objetivo) extends Mision {

  override def esUtil(unPirata: Pirata): Boolean = unPirata.tieneCantidadDeMonedas(_ <= Saqueo.cantidadMaxima()) && objetivo.esSaqueablePor(unPirata)

  override def cumpleRequisitoDeLaMision(unBarco: Barco): Boolean = objetivo.esVulnerableA(unBarco)

}

object Saqueo {
  var _cantidadMaxima = 1000
  def cantidadMaxima(): Int = _cantidadMaxima
  def cantidadMaxima(_cm: Int): Unit = _cantidadMaxima = _cm
}