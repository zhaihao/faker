package dev.qinx.faker.entity

case class Airport(iataCode: String, airportType: String, countryCode: String) {

  def this(args: Array[String]) = this(args(0), args(1), args(2))

}
