abstract class MobilePhone {
  MobilePhone([MobilePhone? source]) {
    if (source != null) {
      model = source.model;
      brand = source.brand;
      color = source.color;
      price = source.price;
    }
  }

  String model = "";

  String brand = "";

  String color = "";

  String price = "";

  MobilePhone clone();
}

class FoldablePhone extends MobilePhone {
  FoldablePhone([FoldablePhone? source]) : super(source) {
    if (source != null) {
      foldHeight = source.foldHeight;
      unfoldHeight = source.unfoldHeight;
    }
  }

  int foldHeight = 400;
  int unfoldHeight = 800;

  @override
  MobilePhone clone() => FoldablePhone(this);
}

class IPhone extends MobilePhone {
  IPhone([IPhone? source]) : super(source) {
    if (source != null) {
      countryCode = source.countryCode;
    }
  }

  String countryCode = "VN";

  @override
  MobilePhone clone() => IPhone(this);
}

void main() {
  final phoneRegistry = <String, MobilePhone>{};

  final foldablePhone = FoldablePhone();
  foldablePhone.brand = "Samsung";
  foldablePhone.model = "XP4";
  foldablePhone.color = "Pink";
  foldablePhone.price = r"$999";
  phoneRegistry["FoldableSamsung"] = foldablePhone;

  final iphoneXSMax = IPhone();
  iphoneXSMax.brand = "Apple";
  iphoneXSMax.countryCode = "US";
  iphoneXSMax.model = "XSMax";
  iphoneXSMax.price = r"$1999";
  iphoneXSMax.color = "Black";
  phoneRegistry["IphoneXSMax"] = iphoneXSMax;

  print("Let \'s produce 100 Iphone");
  final producedIphone = <MobilePhone>[];
  for (int i = 0; i < 100; i++) {
    print("Producing ${i}th Iphone!");
    producedIphone.add(phoneRegistry["IphoneXSMax"]!.clone());
  }
}
