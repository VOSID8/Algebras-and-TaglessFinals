
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

    case class WeatherForecaseRequest(lat: Double, lon: Double) // "Product type"

    sealed trait WeatherForecastResponse // "Sum type"
    case class valid(weather: Weather) extends WeatherForecastResponse // "Product type"
    case class invalid(error: String, description: String) extends WeatherForecastResponse

    //adts are a way to model data in a functional way
    //sum types are a way to model a type that can be one of a fixed set of values
    //product types are a way to model a type that is a combination of other types

    //advantages
    // illegal states are unrepresentable 
    // pattern matching
    // type safety
    // just data -> immutable, helps to structure the code

    type NaiveWeather = String
    def naiveFeeling(weather: Weather) = weather match {
      case Sunny => "I'm feeling happy"
      case Rainy => "I'm feeling sad"
      case Cloudy => "I'm feeling meh"
      case Snowy => "I'm feeling cold"
      case _ => "I'm feeling confused"
    }
    //ager Weather ki jgah String le rha hota toh rather than few defined products
    //we could have used anything jo baad me crash ker jaye
    //so we are using ADTs to make sure that we are using the correct type
    // complexity = number of possible values of ADT
    // goal = reduce complexity

}
