package yaaaar.piratas

import Yaaaar.Item

case class PirataEspiaDeLaCorona(var cantidadMonedas: Int, val items: List[Item], var nivelEbriedad: Int, var invitante: Pirata) extends Pirata(cantidadMonedas, items, nivelEbriedad, invitante) {

  override def estaPasadoDeGrog(): Boolean = false

  override def estaAutorizadoASaquear(unObjetivo: Objetivo): Boolean = this.tiene("permiso de la corona")

}
