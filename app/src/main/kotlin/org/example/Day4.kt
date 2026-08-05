package org.example

data class Contact(val name: String, val phone: String)

object ContactBook {
    private val contacts = mutableListOf<Contact>()

    fun add(contact: Contact) {
        contacts.add(contact)
    }

    fun findByName(name: String): Contact? =
        contacts.firstOrNull { it.name.equals(name, ignoreCase = true) }

    fun all(): List<Contact> = contacts
}

fun main() {
    ContactBook.add(Contact("Alice", "555-1234"))
    ContactBook.add(Contact("Bob", "555-5678"))

    println("All contacts:")
    ContactBook.all().forEach { println(it) }

    val found = ContactBook.findByName("alice")
    println("Found: $found")

    val notFound = ContactBook.findByName("Zara")
    println("Not found result: $notFound")
}
