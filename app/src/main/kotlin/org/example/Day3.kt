package org.example

class Day3 {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
fun celsiusToFahrenheit(c: Double): Double = c * 9 / 5 + 32
fun fahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9
fun celsiusToKelvin(c: Double): Double = c + 273.15

fun main() {
    println("Enter mode (C2F, F2C, C2K):")
    val mode = readlnOrNull()?.uppercase() ?: ""

    println("Enter value:")
    val inputStr = readlnOrNull()

    // this next line will likely throw if input isn't a valid number —
    // that's expected for now, we fix it properly on Day 6 (null safety)
    val input = inputStr!!.toDouble()

    val result = when (mode) {
        "C2F" -> celsiusToFahrenheit(input)
        "F2C" -> fahrenheitToCelsius(input)
        "C2K" -> celsiusToKelvin(input)
        else -> throw IllegalArgumentException("Unknown mode: $mode")
    }

    println("Input: $input, Mode: $mode, Result: $result")
}
