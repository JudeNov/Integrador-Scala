package yaaaar.piratas

import Yaaaar.Item
import  yaaaar.objetivos.Objetivo


case class PirataEspiaDeLaCorona(override var cantidadMonedas: Int,override  val items: List[Item],override var nivelEbriedad: Int,override val invitante: Pirata) extends Pirata(cantidadMonedas, items, nivelEbriedad, invitante) {

  override def estaPasadoDeGrog(): Boolean = false


  override def estaAutorizadoASaquear(unObjetivo: Objetivo): Boolean = this.tiene("permiso de la corona")

}
