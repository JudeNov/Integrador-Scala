import junit.framework.TestCase
import org.junit.Assert._
import yaaaar.misiones.{BusquedaDelTesoro, ConvertirseEnLeyenda, Saqueo}
import yaaaar.objetivos.{Barco, CiudadCostera}
import yaaaar.piratas.{Pirata, PirataEspiaDeLaCorona}

class Tests extends TestCase{

  var barbaNegra = new Pirata(16,List("brujula","cuchillo","cuchillo","diente de oro","grogXD","grogXD","grogXD","espada","pierna","pierna"),40,rico)
  var gabriel = new Pirata(3,List("brujula","cuchillo","grogXD"),86,invitante=daniel)
  var daniel = new Pirata(6,List("brujula","cuchillo","diente de oro","grogXD","grogXD"),88,invitante=gabriel)
  var pedro = new Pirata(2,List("cuchillo","diente de oro"),95,invitante=daniel)
  var quinteros= new PirataEspiaDeLaCorona(2,List("cuchillo","diente de oro","permiso"),85,invitante=rico)
  var rico = new Pirata(11,List("brujula","cuchillo","cuchillo","diente de oro","grogXD","grogXD","grogXD","espada","pierna","pierna"),90,invitante=gabriel)

  var misionLeyenda= new ConvertirseEnLeyenda("cuhillo")
  var misionSaqueo = new Saqueo(barquito)
  var misionAsaltoCiudad = new Saqueo(constitucion)
  var misionOro = new BusquedaDelTesoro()

  var barquito = new Barco(2,misionLeyenda,List(barbaNegra))
  var barcote = new Barco(4,misionSaqueo,List(pedro,daniel,gabriel))

  var constitucion = new CiudadCostera(10)
  
  
  def barbaNegraPuedeserTripulanteDelBarcote() = {
    barcote.agregar(barbaNegra)
    assertFalse(barcote.puedeUnirse(barbaNegra))
  }

  def pedroNoEsUtilParaLaBusquedaDelTesoro() = {
	  assertFalse(misionOro.esUtil(pedro))
  } 

  def barbaNegraPuedeSerLeyenda() = {
	  assertTrue(misionLeyenda.esUtil(barbaNegra))
  }

  def ricoPuedeSerSaqueador() = {
	  assertTrue(misionSaqueo.esUtil(rico))
  } 

  /* def barcoteSaquea(){
    barcote.anclarEn(constitucion)  no entiendo que hace este test (marti)
    assertTrue(barcote.esTemible())
  } */

  def elTotalDePiratasPasadosDeGrogEnBarcoteSon2() = {
    gabriel.tomarUnTrago()
    assertEquals(2,barcote.cantidadDeTripulantesPasadosDeGrog())
  }

  def elTripulanteMasInvitadorDeBarcoteEsGabriel() = {
    assertEquals(gabriel,barcote.tripulanteMasInvitador())
  }

  def elPirataMasEbrioDelBarcoteEssPedro() = {
    assertEquals(pedro, barcote.pirataMasEbrio())
  }

  def cuandoBarquitoAnclaEnConstitucionPierdeUnTripulante() = {
    barquito.anclarEn(constitucion)
    assertEquals(11, constitucion.cuantosHabitantes()) //se une un pirata a la ciudad
  }

  def barquitoEsTemible() = {
    barquito.agregar(rico)
    assertTrue(barquito.esTemible())
  }

  def totalTripulantesPasadosDeGrogEnElBarcoteEs2() = {
    assertEquals(2, barcote.cantidadDeTripulantesPasadosDeGrog())
  }

  def elTotalDeItemsJuntadosPorElBarquitoEs5() = {
    val prato = new Pirata(5,List("brujula","cuchillo","diente de oro","grogXD","grogXD","llave de cofre"),91,gabriel)
    barquito.agregar(prato)
    assertEquals(5, barquito.cantidadItemsDistintosEntreTripulantesPasadosDeGrog())
  }

  def elTripulantePasadoDeGrogMasRicoDelBarcoteEsDaniel() = {
    assertEquals(daniel, barcote.tripulantePasadosDeGrogConMasDinero())
  }

  def elAgenteEspiaQuinterosNuncaEstaPasadoDeGrog() = {
    quinteros.tomarUnTrago()                                  
    assertFalse(quinteros.estaPasadoDeGrog())
  } 

  def quinterosNoEstaAutorizadoASaquearElBarquito() = {
    assertFalse(quinteros.estaAutorizadoASaquear(barquito))
  }

  //def esSaqueablePor
  //def esVulnerableA
}
