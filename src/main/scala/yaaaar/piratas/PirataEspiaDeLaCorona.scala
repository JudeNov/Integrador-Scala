package yaaaar.piratas

class PirataEspiaDeLaCorona(cantidadMonedas: Int, items: List[Item], nivelEbriedad: Int, invitante: Pirata) extends Pirata(cantidadMonedas, items, nivelEbriedad, invitante) {

  override def estaPasadoDeGrog(): Boolean = false

  override def estaAutorizadoASaquear(unObjetivo: Objetivo): Boolean = this.tiene("permiso de la corona")

}

