package yaaaar.objetivos

import yaaaar.piratas.Pirata

trait Objetivo {

  def esSaqueablePor(unPirata: Pirata): Boolean = this.loPuedeSaquear(unPirata) && unPirata.estaAutorizadoASaquear()
 
  def esVulnerableA(unBarco: Barco): Boolean = unBarco.tieneCantidadDeTripulantes(this.cantidadNecesariaDeTripulantes()) || this.cumpleRequisitos(unBarco)

  def cumpleRequisitos(unBarco: Barco): Boolean = false

  def cantidadNecesariaDeTripulantes(): Int => Boolean

  def loPuedeSaquear(unPirata: Pirata): Boolean

}

