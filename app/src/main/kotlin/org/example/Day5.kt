package org.example

sealed class OperationResult<out T>
data class Ok<T>(val value: T) : OperationResult<T>()
data class Failed(val reason: String) : OperationResult<Nothing>()
object Empty : OperationResult<Nothing>() 

fun <T> printAll(items: List<T>) {
    for (item in items) {
        println(item)
    }
}

fun addContactSafely(book: MutableList<Contact>, contact: Contact): OperationResult<Contact> {
    if (book.any { it.name.equals(contact.name, ignoreCase = true) }) {
        return Failed("Contact '${contact.name}' already exists")
    }
    book.add(contact)
    return Ok(contact)
}

fun findContact(book: List<Contact>, name: String): OperationResult<Contact> {
    if (book.isEmpty()) return Empty
    val found = book.find { it.name.equals(name, ignoreCase = true) }
    return if (found != null) Ok(found) else Failed("Contact '$name' not found")
}

fun handleResult(result: OperationResult<Contact>, label: String) {
    print("Test [$label]: ")
    when (result) {
        is Ok -> println("Success -> Found ${result.value}")
        is Failed -> println("Handled Error -> ${result.reason}")
        is Empty -> println("Handled Empty -> List was empty.")
    }
}

fun main() {
    val contacts = mutableListOf<Contact>()

    println("--- 1. Searching Empty List ---")
    handleResult(findContact(contacts, "Alice"), "Empty Search")

    println("\n--- 2. Adding Contacts ---")
    addContactSafely(contacts, Contact("Alice", "555-1234"))
    addContactSafely(contacts, Contact("Charlie", "555-0000"))
    println("Added Alice and Charlie.")

    println("\n--- 3. Searching for Zack (The Failing Test) ---")
    val zackResult = findContact(contacts, "Zack")
    handleResult(zackResult, "Missing Contact")
    
    println("--- Continuation Check: The program is still running! ---")

    println("\n--- 4. Generic printAll Tests ---")
    println("Contacts:")
    printAll(contacts) 
    println("Integers:")
    printAll(listOf(1, 2, 3))

    println("\n--- 5. Final Status ---")
    println("Program reached the end successfully.")
}
