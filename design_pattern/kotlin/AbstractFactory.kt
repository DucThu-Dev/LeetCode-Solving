package design_pattern.kotlin

/**
 * [Source](https://refactoring.guru/design-patterns/abstract-factory)
 */


abstract class Button

class WinButton : Button()

class MacButton : Button()

abstract class CheckBox

class WinCheckBox : CheckBox()

class MacCheckBox : CheckBox()

interface GUIFactory {
    fun createButton(): Button

    fun createCheckBox(): CheckBox
}

class WinFactory : GUIFactory {
    override fun createButton(): Button {
        return WinButton()
    }

    override fun createCheckBox(): CheckBox {
        return WinCheckBox()
    }
}

class MacFactory : GUIFactory {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): CheckBox {
        return MacCheckBox()
    }
}

fun main() {
    val configOS = "MAC"
    val factory: GUIFactory = if (configOS == "MAC") MacFactory() else WinFactory()
    val button = factory.createButton()
    val checkBox = factory.createCheckBox()
}