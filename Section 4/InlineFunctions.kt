@file:Suppress("unused")

inline fun modifyPerson(person: Person, modifier: (Person) -> Unit) {
    modifier(person)
}

fun modifyPersonCall() {
    val person = Person()
    modifyPerson(person) { p ->
        p.country = "Sweden"
        p.name = "Fred"
        p.yearOfBirth = 201
    }
}

fun modifyPersonCompilerGeneratedCode() {
    val person = Person()
    person.country = "Sweden"
    person.name = "Fred"
    person.yearOfBirth = 201
}


inline fun modifyPerson(person: Person, modifier: (Person) -> Unit, noinline log: (String) -> Unit) {
    modifier(person)
    log("modifying Person")
}

inline fun takeIf(person: Person, crossinline takeIf: (Person) -> Boolean) {
    person.takeIf { takeIf(it) }
}

//Inline restrictions

private var storedAction: () -> Unit = {}

inline fun cantInline(action: () -> Unit) {
    storedAction = action
}