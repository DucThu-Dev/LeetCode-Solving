package design_pattern.behaviour_patterns.kotlin

abstract class MobilePhoneSetup {
    fun initialize() {
        checkBattery()
        setUpKernelEnvironment()
        setUpSim()
        startUp()
        checkSound()
        makeSound()
        requirePassword()
    }

    fun setUpKernelEnvironment() {
        println("Set up environment necessary for device to start up.")
    }

    fun setUpSim() {
        println("Activate SIM")
    }

    fun checkBattery() {
        println("Is there enough battery energy to start up?")
    }

    fun checkSound() {
        println("Validate if device set to mute or vibrate mode.")
    }

    abstract fun makeSound()

    fun requirePassword() {
        println("Ask user to input password on first time start up.")
    }

    fun startUp() {
        println("Start Up the mobile phone")
    }
}

class IphoneSetUp() : MobilePhoneSetup() {
    override fun makeSound() {
        println("Play Iphone \'s start up sound!")
    }
}

class SamsungSetUp() : MobilePhoneSetup() {
    override fun makeSound() {
        println("Play Samsung \'s start up sound!")
    }
}

fun main() {
    val iphoneSetUp = IphoneSetUp()
    iphoneSetUp.initialize()
}