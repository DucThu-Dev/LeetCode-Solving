abstract class Button {}

class WinButton extends Button {}

class MacButton extends Button {}

abstract class CheckBox {}

class WinCheckBox extends CheckBox {}

class MacCheckBox extends CheckBox {}

abstract class GUIFactory {
  Button createButton();

  CheckBox createCheckBox();
}

class WinFactory implements GUIFactory {
  @override
  Button createButton() => WinButton();

  @override
  CheckBox createCheckBox() => WinCheckBox();
}

class MacFactory implements GUIFactory {
  @override
  Button createButton() => MacButton();

  @override
  CheckBox createCheckBox() => MacCheckBox();
}

void main() {
  final configOS = 'MAC';
  final factory = configOS == 'MAC' ? MacFactory() : WinFactory();
  final button = factory.createButton();
  final checkBox = factory.createCheckBox();
}