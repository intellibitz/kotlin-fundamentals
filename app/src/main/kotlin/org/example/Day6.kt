package org.example

fun main() {
    println("Enter mode (C2F, F2C, C2K):")
    val mode = readlnOrNull()?.uppercase()?.trim() ?: run {
        println("No mode entered, exiting.")
        return
    }

    println("Enter value:")
    val inputStr = readlnOrNull()?.trim()

    // toDoubleOrNull() returns null instead of throwing, if parsing fails
    val input = inputStr?.toDoubleOrNull() ?: run {
        println("Invalid number entered: '$inputStr'")
        return
    }

    val result: Double? = when (mode) {
        "C2F" -> celsiusToFahrenheit(input)
        "F2C" -> fahrenheitToCelsius(input)
        "C2K" -> celsiusToKelvin(input)
        else -> null
    }

    if (result == null) {
        println("Unknown mode: '$mode'")
        return
    }

    println("Input: $input, Mode: $mode, Result: $result")
}
