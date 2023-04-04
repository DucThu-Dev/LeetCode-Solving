abstract class Animal {
  static Animal createAnimal(AnimalType type) {
    switch (type) {
      case AnimalType.Dog:
        return Dog();
      case AnimalType.Cat:
        return Cat();
      case AnimalType.Chicken:
        return Chicken();
    }
  }

  void makeNoise();
}

enum AnimalType { Dog, Cat, Chicken }

class Dog extends Animal {
  @override
  void makeNoise() {
    print('Gau Gau');
  }
}

class Cat extends Animal {
  @override
  void makeNoise() {
    print('Meow Meow');
  }
}

class Chicken extends Animal {
  @override
  void makeNoise() {
    print('O o o o');
  }
}
