import junit.framework.TestCase
import org.junit.Assert._
import yaaaar.misiones.{BusquedaDelTesoro, ConvertirseEnLeyenda, Saqueo}
import yaaaar.objetivos.{Barco, CiudadCostera}
import yaaaar.piratas.{Pirata, PirataEspiaDeLaCorona}

class Tests extends TestCase{

  var barbanegra = new Pirata(16,List("brujula","cuchillo","cuchillo","diente de oro","grogXD","grogXD","grogXD","espada","pierna","pierna"),40,null)
  var gabriel = new Pirata(3,List("brujula","cuchillo","grogXD"),86,null)
  var daniel = new Pirata(6,List("brujula","cuchillo","diente de oro","grogXD","grogXD"),88,gabriel)
  var pedro = new Pirata(2,List("cuchillo","diente de oro"),95,daniel)
  var quinteros= new PirataEspiaDeLaCorona(2,List("cuchillo","diente de oro","permiso"),0,null)
  var serLeyenda1 = new ConvertirseEnLeyenda("cuhillo")
  var barquito= new Barco(2,serLeyenda1,List(barbanegra))
  var saqueo1 = new Saqueo(barquito)
  var barcote= new Barco(4,saqueo1,List(pedro,daniel,gabriel))
  var constitucion = new CiudadCostera(10)
  var oro = new BusquedaDelTesoro()
  var asaltoCiudad = new Saqueo(constitucion)

  def meterAlBarco(){
    barcote.agregar(barbanegra)
    assertFalse(barcote.puedeUnirse(barbanegra))
  }

  def barquitoLeyenda(){
    val rico = new Pirata(11,List("brujula","cuchillo","cuchillo","diente de oro","grogXD","grogXD","grogXD","espada","pierna","pierna"),90,gabriel)
    barquito.agregar(rico)
    assertTrue(barquito.esTemible())
  }

  def barcoteSaquea(){
    barcote.anclarEn(constitucion)
    assertTrue(barcote.esTemible())
  }

  def pasadosDeGrog(){
    gabriel.tomarUnTrago()
    assertEquals(barcote.cantidadDeTripulantesPasadosDeGrog(),2)
  }

  def invitoAMasGente(){
    val rico = new Pirata(5,List("brujula","cuchillo","diente de oro","grogXD","grogXD"),90,gabriel)
    barcote.agregar(rico)
    assertEquals(barcote.tripulanteMasInvitador(),gabriel) //superaria a daniel en invitaciones
  }

  def busquedaTesoro(){
    barquito.cambiarMision(oro)
    assertFalse(barcote.esTemible()) //cumple requisito de busqueda del tesoro
  }

  def pirataMasEbrio(){
    assertEquals(barcote.pirataMasEbrio(),pedro)
  }

  def unoMenos(){
    barquito.anclarEn(constitucion)
    assertEquals(constitucion.cantidadHabitantes,11) //se une un pirata a la ciudad
  }

  def cantidadItemsJuntados(){
    val prato = new Pirata(5,List("brujula","cuchillo","diente de oro","grogXD","grogXD","llave de cofre"),90,gabriel)
    barcote.agregar(prato)
    assertEquals(barcote.cantidadItemsDistintosEntreTripulantesPasadosDeGrog(),5)
  }

  def esAgenteEspia(){
    for (_ <- 1 to 18) { //18 porque se aumenta en 5 el nivel de ebriedad por cada trago, 18 * 5 = 90
      quinteros.tomarUnTrago()
    }
    assertFalse(quinteros.estaPasadoDeGrog())
  }

  def noAsaltaCiudad(){
    barcote.cambiarMision(asaltoCiudad) //por cantidad de tripulantes
    assertFalse(barcote.esTemible())
  }

  //def esSaqueablePor
  //def esVulnerableA
}
