error id: file:///C:/Projects/Algebras-and-TaglessFinals/src/main/ADTs.scala:[579..580) in Input.VirtualFile("file:///C:/Projects/Algebras-and-TaglessFinals/src/main/ADTs.scala", "
object ADTs {
  

    sealed trait Weather // "Sum type"
    case object Sunny extends Weather
    case object Rainy extends Weather
    case object Cloudy extends Weather
    case object Snowy extends Weather

    // Weather = Sunny | Rainy | Cloudy | Snowy == SUM TYPE

    def feeling(weather: Weather): String = weather match {
      case Sunny => "I'm feeling happy"
      case Rainy => "I'm feeling sad"
      case Cloudy => "I'm feeling meh"
      case Snowy => "I'm feeling cold"
    }

    case class WeatherForecaseRequest(lat: Double, lon: Double)

    sealed trait 
}
")
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/ADTs.scala
file:///C:/Projects/Algebras-and-TaglessFinals/src/main/ADTs.scala:23: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace