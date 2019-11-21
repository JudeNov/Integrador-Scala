package yaaaar.misiones

import yaaaar.objetivos.Barco
import yaaaar.piratas.Pirata

abstract class Mision {

  def esUtil(unPirata: Pirata): Boolean

  def puedeRealizarla(unBarco: Barco): Boolean = unBarco.tieneSuficienteTripulacion() && this.cumpleRequisitoDeLaMision(unBarco)

  def cumpleRequisitoDeLaMision(unBarco: Barco): Boolean = true

}