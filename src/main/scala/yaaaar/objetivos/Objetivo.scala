package yaaaar.objetivos

import yaaaar.piratas.Pirata

trait Objetivo {

  def esSaqueablePor(unPirata: Pirata): Boolean = unPirata match {
    case unPirata => this.loPuedeSaquear(unPirata)
    case unPirata => this.loPuedeSaquear(unPirata) && unPirata.estaAutorizadoASaquear(this)
  }

  def esVulnerableA(unBarco: Barco): Boolean = unBarco.tieneCantidadDeTripulantes(this.cantidadNecesariaDeTripulantes()) || this.cumpleRequisitos(unBarco)

  def cumpleRequisitos(unBarco: Barco): Boolean = false

  def cantidadNecesariaDeTripulantes(): Int => Boolean

  def loPuedeSaquear(unPirata: Pirata): Boolean

}

