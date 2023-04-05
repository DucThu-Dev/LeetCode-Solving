package design_pattern.kotlin

data class Car(val brand: String, val model: String, val color: String, val engine: String, val transmission: String)

interface CarBuilder {
    fun setBrand(brand: String)

    fun setModel(model: String)

    fun setColor(color: String)

    fun setEngine(engine: String)

    fun setTransmission(transmission: String)

    fun build(): Car
}

class CarBuilderImpl : CarBuilder {
    private var brand: String = ""

    private var model: String = ""

    private var color: String = ""

    private var engine: String = ""

    private var transmission: String = ""

    override fun setBrand(brand: String) {
        this.brand = brand
    }

    override fun setModel(model: String) {
        this.model = model
    }

    override fun setColor(color: String) {
        this.color = color
    }

    override fun setEngine(engine: String) {
        this.engine = engine
    }

    override fun setTransmission(transmission: String) {
        this.transmission = transmission
    }

    override fun build(): Car {
        return Car(brand, model, color, engine, transmission)
    }
}

class CarDirector(private val builder: CarBuilder) {
    fun constructSportCar() {
        builder.setBrand("Ferrari")
        builder.setModel("488 GTB")
        builder.setColor("Red")
        builder.setEngine("V8")
        builder.setTransmission("7-Speed dual clutch")
    }

    fun constructSUV() {
        builder.setBrand("BMW")
        builder.setModel("X5")
        builder.setColor("Black")
        builder.setEngine("V6")
        builder.setTransmission("8-Speed automatic")
    }
}

fun main() {
    val builder = CarBuilderImpl()
    val director = CarDirector(builder)

    director.constructSportCar()
    val sportCar = builder.build()
    println(sportCar)

    director.constructSUV()
    val suvCar = builder.build()
    println(suvCar)
}