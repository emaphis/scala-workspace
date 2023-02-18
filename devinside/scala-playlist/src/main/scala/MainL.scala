import java.lang.module.ModuleDescriptor.Modifier
// Video # 17 - Traits and their super powers
// includes files Base.scala, Core.scala, Modification.scala
object MainL {

  /** A Trait Example */
  def code1(args: Array[String]) = {
    class Animal

    trait Pet {
      def allowedToSleepInBed: Boolean
      def disallowedToSleepInBed: Boolean = {
        !allowedToSleepInBed
      }
    }

    class Cat extends Animal with Pet {
      val allowedToSleepInBed: Boolean = true
    }

    class Turtle extends Animal with Pet {
      val allowedToSleepInBed: Boolean = false
    }

    def show(pet: Pet): Unit = {
      println(pet.disallowedToSleepInBed)
    }
    
    //show(new Cat)
    //show(new Turtle)

    // val path = "./src/main/scala.MainL.scala"
    
    //val file = new java.io.File(path)
    //println(file.getName())

    trait TimeStamp {
      val creationTime: String = {
        val formatter =
          java.time.format
            .DateTimeFormatter
            .ofPattern("HH:mm:ss")
        
        java.time
          .LocalDateTime.now.format(formatter)

      }
    }

    class FileWithTimeStamp(path: String)
      extends java.io.File(path) with TimeStamp {

    }

    val path = "./src/main/scala/MainL.scala"
    val file1 = new FileWithTimeStamp(path)
    // anonymous class
    val file = new java.io.File(path) with TimeStamp {

    }

    def showName(file: java.io.File): Unit = {
      println(file.getName)
    }

    def showCreationTime(timeStamp: TimeStamp): Unit = {
      println(timeStamp.creationTime)
    }

    showName(file)
    showCreationTime(file)
  }

  /** Car with traits */
  def code(args: Array[String]) = {
    final class Lamborghini(override val model: String)
      extends Core.SportsCar(model)
      with Modification.Spoiler {
        override def brand: String = "Lamborghini"
      }
      
    final class BMW(override val model: String)
      extends Core.OrdinaryCar(model)
      with Modification.Spoiler
      with Modification.EngineControlUnit
      with Modification.TurboCharger {
        override def brand: String = "BMW"
      }
    
    println(new Lamborghini("Murcialago"))
    println(new BMW("GR-3"))

    println("\nHello there, Cars")
  }

  /** main program */
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }
}
