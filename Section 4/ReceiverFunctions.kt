@file:Suppress("unused")

data class Person(var name: String? = null,
                  var yearOfBirth: Int? = null,
                  var country: String? = null)

fun newPerson(init: Person.() -> Unit): Person {
    val person = Person()
    person.init()
    init(person)
    return person
}

fun person() = newPerson {
    name = "Fred"
    yearOfBirth = 1965
    country = "Sweden"
}

fun personApply() = Person().apply {
    name = "Fred"
    yearOfBirth = 1965
    country = "Sweden"
}

