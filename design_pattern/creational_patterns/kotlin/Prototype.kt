package design_pattern.creational_patterns.kotlin

abstract class Shape(source: Shape? = null) {

    var x: Int
    var y: Int
    var color: String

    abstract fun clone(): Shape;

    init {
        this.x = source?.x ?: 0
        this.y = source?.y ?: 0
        this.color = source?.color ?: "Red"
    }
}

class Rectangle(source: Rectangle? = null) : Shape(source) {

    var width: Int
    var height: Int

    override fun clone(): Shape {
        return Rectangle(this)
    }

    init {
        this.width = source?.width ?: 0
        this.height = source?.height ?: 0
    }
}

class Circle(source: Circle? = null) : Shape(source) {

    var radius: Int
    override fun clone(): Shape {
        return Circle(this)
    }

    init {
        this.radius = source?.radius ?: 0
    }
}

fun main() {
    val shapes: MutableList<Shape> = mutableListOf()

    val circle = Circle()
    circle.x = 10
    circle.y = 10
    circle.radius = 20
    shapes.add(circle)

    val anotherCircle = circle.clone()
    shapes.add(anotherCircle)


}