package yaaaar.objetivos

import yaaaar.piratas.Pirata

class CiudadCostera(var cantidadHabitantes: Int) extends Objetivo {

  override def loPuedeSaquear(unPirata: Pirata): Boolean = unPirata.tieneNivelDeEbriedad(_ >=50)

  def agregarUnHabitante(): Unit = cantidadHabitantes += 1

  override def cantidadNecesariaDeTripulantes(): Int => Boolean = _ >= (cantidadHabitantes * 0.4)

  override def cumpleRequisitos(unBarco: Barco): Boolean = unBarco.estanTodosPasadosDeGrog()

}
