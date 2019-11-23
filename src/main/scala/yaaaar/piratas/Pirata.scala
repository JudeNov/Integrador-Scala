package yaaaar.piratas

import Yaaaar.Item
import yaaaar.misiones.Mision
import yaaaar.objetivos.{Barco, Objetivo}

case class Pirata(var cantidadMonedas: Int, val items: List[Item], var nivelEbriedad: Int, val invitante: Pirata){

  def esUtilPara(unaMision: Mision): Boolean = unaMision.esUtil(this)

  def tiene[T](elemento:T): Boolean = elemento match {
    case elemento: Item => items.contains(elemento)
    case elemento: List[Item] => elemento.forall { items.contains }
  }

  /*def tiene(unItem: Item): Boolean = items.contains(Item)

  def tiene(unosItems: List(Item)): Boolean = unosItems.forall { items.contains }*/ REVISAR QUE QUEDA MEJOR

  def tieneCantidadDeMonedas(unCriterio: Int => Boolean): Boolean = unCriterio(cantidadMonedas)

  def tieneCantidadDeItems(unCriterio: Int => Boolean): Boolean = unCriterio(this.cantidadDeItems())

  def cantidadDeItems(): Int = items.size

  def tieneNivelDeEbriedad(unCriterio: Int => Boolean): Boolean = unCriterio(nivelEbriedad)

  def estaPasadoDeGrog(): Boolean = this.tieneNivelDeEbriedad(_ >= 90)

  def tomarUnTrago(): Unit = {
    this.modificarNivelEbriedad(5)
    this.gastarMonedas(1)
  }

  def modificarNivelEbriedad(unaModificacion: Int): Unit = nivelEbriedad += unaModificacion

  def gastarMonedas(unaCantidad: Int): Unit = if(this.puedeGastarDinero(unaCantidad)) cantidadMonedas -= unaCantidad

  def puedeGastarDinero(unaCantidad: Int): Boolean = unaCantidad > cantidadMonedas

  def seAnimaASaquear(unObjetivo: Objetivo): Boolean = unObjetivo.esSaqueablePor(this)

  def estaAutorizadoASaquear(unObjetivo: Objetivo): Boolean = true

  def cantidadDeInvitadosPara(unBarco: Barco): Int = unBarco.cantidadDeInvitadosPor(this)

  def fueInvitadoPor(unTripulante: Pirata): Boolean = invitante == unTripulante

}
