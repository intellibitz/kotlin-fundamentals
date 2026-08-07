package org.example

fun fahrenheitToCelsius(f: Double): Double = (f - 32.0) / 1.8
fun celsiusToKelvin(c: Double): Double = c + 273.15
fun celsiusToFahrenheit(c: Double): Double = (c * 1.8) + 32.0

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
    val result =
        when (mode) {
            "C2F" -> celsiusToFahrenheit(input)
            "F2C" -> fahrenheitToCelsius(input)
            "C2K" -> celsiusToKelvin(input)
            else -> {
                println("Unknown mode: $mode")
                return
            }
        }
    println("Input: $input, Mode: $mode, Result: $result")
}
