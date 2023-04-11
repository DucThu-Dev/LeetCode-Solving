package design_pattern.structure_patterns.kotlin

class MobileFixerEngineer(var mobile: Mobile) {
    fun fixNewMobile(mobile: Mobile) {
        this.mobile = mobile
        println("Engineer receive new mobile!")
    }

    fun fixScreen() {
        mobile.replaceScreen()
    }

    fun fixBattery() {
        mobile.replaceBattery()
    }

    fun applyNewColor(color: String) {
        mobile.remakeColor(color)
    }
}

abstract class Mobile(var screen: String, var battery: String, var color: String) {
    abstract fun replaceScreen()

    abstract fun replaceBattery()

    fun remakeColor(color: String) {
        this.color = color
        println("Apply new color for Mobile")
    }
}

class Iphone(screen: String, battery: String, color: String) : Mobile(screen, battery, color) {
    override fun replaceScreen() {
        println("Replace Iphone screen!")
    }

    override fun replaceBattery() {
        println("Replace battery!")
    }
}

class SamsungGalaxy(screen: String, battery: String, color: String) : Mobile(screen, battery, color) {
    override fun replaceScreen() {
        println("Replace Samsung screen!")
    }

    override fun replaceBattery() {
        println("Replace Samsung battery!")
    }
}

fun main() {
    val iphone = Iphone("Iphone screen", "Iphone Battery", "Black")
    val mobileFixerEngineer = MobileFixerEngineer(iphone)
    mobileFixerEngineer.fixScreen()
    mobileFixerEngineer.fixBattery()
    mobileFixerEngineer.applyNewColor("Red")

    val samsungGalaxy = SamsungGalaxy("Samsung Galaxy Screen", "Samsung Galaxy Battery", "Blue")
    mobileFixerEngineer.fixNewMobile(samsungGalaxy)
    mobileFixerEngineer.fixScreen()
    mobileFixerEngineer.fixBattery()
    mobileFixerEngineer.applyNewColor("Green")
}