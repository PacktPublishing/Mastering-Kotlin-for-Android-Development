@file:Suppress("unused")

package classes

sealed class Animal(val name: String)

class Dog(name: String) : Animal(name)

class Cat(name: String) : Animal(name)


fun nameOfAnimal(animal: Animal): String {
    return when (animal) {
        is Dog -> "Animal is a dog with name ${animal.name}"
        is Cat -> "Animal is a cat with name ${animal.name}"
    }
}