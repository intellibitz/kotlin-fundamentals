package org.example

class Day3 {
    fun celsiusToFahrenheit(c: Double): Double = c * 9 / 5 + 32
    fun fahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9
    fun celsiusToKelvin(c: Double): Double = c + 273.15
}

fun main() {
    println("Enter mode (C2F, F2C, C2K):")
    val mode =
        readlnOrNull()?.uppercase()
            ?: run {
                println("No mode provided.")
                return
            }
    println("Enter value:")
    val input = readlnOrNull()?.toDoubleOrNull()
    if (input == null) {
        println("Invalid input. Please enter a valid number.")
        return
    }
    val day3 = Day3()
    val result =
        when (mode) {
            "C2F" -> day3.celsiusToFahrenheit(input)
            "F2C" -> day3.fahrenheitToCelsius(input)
            "C2K" -> day3.celsiusToKelvin(input)
            else -> {
                println("Unknown mode: $mode")
                return
            }
        }
    println("Input: $input, Mode: $mode, Result: $result")
}
