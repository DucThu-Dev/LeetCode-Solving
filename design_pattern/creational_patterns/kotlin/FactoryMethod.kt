package design_pattern.creational_patterns.kotlin

abstract class Animal {
    abstract fun makeNoise()
}

class Dog : Animal() {
    override fun makeNoise() {
        println("Gau Gau")
    }
}

class Cat : Animal() {
    override fun makeNoise() {
        println("Meow Meow")
    }
}

class Chicken : Animal() {
    override fun makeNoise() {
        println("O o o o")
    }
}

enum class AnimalType {
    DOG, CAT, CHICKEN
}

object AnimalFactory {
    fun createAnimal(type: AnimalType): Animal {
        return when (type) {
            AnimalType.DOG -> Dog()
            AnimalType.CAT -> Cat()
            AnimalType.CHICKEN -> Chicken()
        }
    }
}

fun main() {
    AnimalFactory.createAnimal(AnimalType.CHICKEN).makeNoise()
}
