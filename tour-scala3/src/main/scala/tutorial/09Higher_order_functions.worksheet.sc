// Higher-order Functions

val salaries = Seq(20_000, 70_000, 40_000)

val doubleSalary = (x: Int) => x * 2

val newSalaries = salaries.map(doubleSalary)

// skip defining the function
val newSalaries2 = salaries.map(x => x * 2)

// Shorter version
val newSalaries3 = salaries.map(_ * 2)


//* Coercing methods into functions *

// It is also possible to pass methods as arguments to higher-order functions because the Scala compiler will coerce the method into a function.

case class weeklyWeatherForecast(temperatures: Seq[Double]):

  private def convertCtoF(temp: Double) =
    temp * 1.8 + 32.0

  // pass a private method
  def forecastInFahrenheit: Seq[Double] =
    temperatures.map(convertCtoF)


//* Functions that accept functions *

val salaries2 = List(20_000.0, 70_000.0, 40_000.0)

object SalaryRaiser:

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)

val newSalaries4 = SalaryRaiser.greatPromotion(salaries2)


// To simplify, you can extract the repeated code into a higher-order function

object SalaryRaiser2:

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

val newSalaries5 = SalaryRaiser2.greatPromotion(salaries2)


//* Functions that return functions *

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String =
  val schema = if ssl then "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"

val domainName = "www.example.com"
def getURL = urlBuilder(ssl=true, domainName)
val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query)
