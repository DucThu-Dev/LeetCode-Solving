import 'dart:math';

abstract class Pizza {
  String getDescription();

  double getCost();
}

class MargheritaPizza extends Pizza {
  @override
  double getCost() {
    return 5.99;
  }

  @override
  String getDescription() {
    return 'MargheritaPizza';
  }
}

abstract class ToppingDecorator implements Pizza {
  ToppingDecorator(this._pizza);

  final Pizza _pizza;

  @override
  double getCost() {
    return _pizza.getCost();
  }

  @override
  String getDescription() {
    return _pizza.getDescription();
  }
}

class ExtraCheese extends ToppingDecorator {
  ExtraCheese(super.pizza);

  @override
  double getCost() {
    return _pizza.getCost() + 1.5;
  }

  @override
  String getDescription() {
    return '${_pizza.getDescription()}, Extra Cheese';
  }
}

void main() {
  Pizza pizza = MargheritaPizza();
  print(pizza.getDescription() + ', \$${pizza.getCost()}');

  pizza = ExtraCheese(pizza);
  print(pizza.getDescription() + ', \$${pizza.getCost()}');
}
