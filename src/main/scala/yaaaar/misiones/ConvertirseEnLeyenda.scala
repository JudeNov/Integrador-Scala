package yaaaar.misiones

import yaaaar.piratas.Pirata

class ConvertirseEnLeyenda(itemObligatorio: Item) extends Mision {

  override def esUtil(unPirata: Pirata): Boolean = this.tieneSuficientesItems(unPirata) && unPirata.tiene(itemObligatorio)

  def tieneSuficientesItems(unPirata: Pirata): Boolean = unPirata.tieneCantidadDeItems(_ >=10)

}