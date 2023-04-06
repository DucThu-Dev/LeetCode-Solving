class Car {
  const Car(this.brand, this.model, this.engine, this.color, this.transmission);

  final String brand;
  final String model;
  final String engine;
  final String color;
  final String transmission;
}

abstract class CarBuilder {
  void setBrand(String brand);

  void setModel(String model);

  void setEngine(String engine);

  void setColor(String color);

  void setTransmission(String transmission);

  Car buildCar();
}

class CarBuilderImpl implements CarBuilder {
  String brand = '';

  String model = '';

  String engine = '';

  String color = '';

  String transmission = '';

  @override
  void setBrand(String brand) {
    this.brand = brand;
  }

  @override
  void setColor(String color) {
    this.color = color;
  }

  @override
  void setEngine(String engine) {
    this.engine = engine;
  }

  @override
  void setModel(String model) {
    this.model = model;
  }

  @override
  void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  @override
  Car buildCar() {
    return Car(brand, model, engine, color, transmission);
  }
}

class CarDirector {
  CarDirector(this.builder);

  final CarBuilder builder;

  void constructSportCar() {
    builder
      ..setBrand('Ford')
      ..setEngine('V8')
      ..setColor('Black')
      ..setModel('S4')
      ..setTransmission('Transmission C7');
  }

  void constructSUV() {
    builder
      ..setBrand('Hyundai')
      ..setEngine('V6')
      ..setColor('Red')
      ..setModel('S2')
      ..setTransmission('Transmission C1');
  }
}

void main() {
  final builder = CarBuilderImpl();
  final director = CarDirector(builder);
  director.constructSportCar();
  final sportCar = builder.buildCar();
  print(sportCar);

  director.constructSUV();
  final suvCar = builder.buildCar();
  print(suvCar);
}
